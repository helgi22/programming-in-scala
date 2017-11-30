abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

/** Pattern matching */

/** Wildcard patterns and Constructor patterns
  * Constructors are where pattern matching becomes really powerful.
  * A constructor pattern looks like "BinOp("+", e, Number(0))". It consists of
  * a name (BinOp) and then a number of patterns within parentheses: "+", e, and
  * Number(0). Assuming the name designates a case class, such a pattern means
  * to first check that the object is a member of the named case class, and then
  * to check that the constructor parameters of the object match the extra patterns supplied.
  * These extra patterns mean that Scala patterns support deep matches
  *
  * The wildcard pattern (_) matches any object whatsoever. You have already seen it used as
  * a default, catch-all alternative, like this: */
def d(expr: Any) = expr match {
  case BinOp("op", Var("qqq"), Number(100)) => println(expr + " is the Constructor patterns")
  case _ => println("he wildcard pattern ") // handle the default case
}
d("test")
d(BinOp("Str", Var("var"), Number(2)))
d(BinOp("op", Var("qqq"), Number(100)))

/** Wildcards can also be used to ignore parts of an object that you do not care about. */
def dd(expr: Any) = expr match {
  case BinOp(_, _, _) => println(expr + " is a binary operation")
  case _ => println("It's something else")
}
dd(BinOp("Str", Var("var"), Number(2)))

/** Constant patterns */
/** A constant pattern matches only itself. Any literal may be used as a constant.
  * For example, 5,true, and "hello" are all constant patterns. Also, any val or
  * singleton object can be used as a constant. For example, Nil, a singleton object,
  * is a pattern that matches only the empty list.Listing 15.5 shows some
  * examples of constant patterns: */
def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

/** Variable patterns */
val variable = (expr: AnyVal) => expr match {
  case 0 => "zero"
  case somethingElse => "not zero: " + somethingElse
}
variable(0)
variable(2)
variable("two")

/** Variable or constant? */

import scala.math.{E, Pi}

E match {
  case Pi => "strange math? Pi = " + Pi
  case _ => "OK"
}
//res11: String = OK

/**
  * How does the Scala compiler know that Pi is a constant imported from
  * scala.math, and not a variable that stands for the selector value itself?
  * Scala uses a simple lexical rule for disambiguation: a simple name starting
  * with a lowercase letter is taken to be a pattern variable; all other
  * references are taken to be constants. To see the difference, create a lowercase
  * alias for pi and try with that:
  */
val pi = math.Pi

//pi: Double = 3.141592653589793
pi match {
  case pi => "strange math? Pi = " + pi
}
//res12: String = strange math ? Pi = 2.718281828459045

/**
  * Here the compiler will not even let you add a default case at all. Since pi is a variable pattern, it will
  * match all inputs, and so no cases following it can be reached:
  */
E match {
  case pi => "strange math? Pi = " + pi
  case _ => "OK"
}
//<console>:12: warning: unreachable code
//  case _ => "OK"

/**
  * You can still use a lowercase name for a pattern constant, if you need to,
  * by using one of two tricks.
  * First, if the constant is a field of some object, you can prefix it with
  * a qualifier. For instance, pi is a variable pattern, but this.pi or obj.pi
  * are constants even though they start with lowercase letters. If that does not work
  * (because pi is a local variable, say), you can alternatively enclose the variable
  * name in back ticks. For instance, `pi` would again be interpreted as a constant,
  * not as a variable:
  */
Pi match {
  case `pi` => "truth math? Pi = " + pi
  case _ => "OK"
}
//res14: String = OK

/** Sequence patterns
  * Listing below shows a pattern that checks for a three-element list starting with zero. */
val seqval = (x: List[Int]) => x match {
  case List(0, _, _) => println("matching this list " + x)
  case _ => println(" " + x)
}
seqval(List(0, 2, 90))
seqval(List(1, 2, 90))

/** If you want to match against a sequence without specifying how long it can be,
  * you can specify _* as the last element of the pattern. */

val seqvalunzise = (x: List[Int]) => x match {
  case List(0, _*) => println("matching this list " + x)
  case _ => println("Wildcard matching" + x)
}
seqvalunzise(List())
seqvalunzise(List(0, 2, 4, 5, 6, 7, 8, 9))

/** Tuple patterns */
def tupleDemo(expr: Any) =
  expr match {
    case (a, b, c) => println("matched " + a + b + c)
    //    case (_*)  => println("matched others tuple" )
    case _ => println("Default matching" + expr)
  }

tupleDemo(("a ", 3, "-tuple"))
tupleDemo(("a", 3))
tupleDemo((1, 3, 6, 8, 0, 9))

/** Typed patterns
  * You can use a typed pattern as a convenient replacement for type tests and type casts.
  * Listing shows an example. */

def generalSize(x: Any) = x match {
  case s: String => s.length
  //  case l: Map[Int,Int] => println("Map[Int,Int] "+l.size)
  /**
    * warning: non-variable type argument Int in type  pattern
    * scala.collection.immutable.Map[Int,Int] (the underlying of Map[Int,Int])
    * Scala uses the erasure model of generics, just like Java does. This means that no
    * information about type arguments is maintained at runtime
    */
  case m: Map[_, _] => m.size
  case _ => -1
}
/*like this*/
val s: String = ""
if (s.isInstanceOf[String]) {
  val ss = s.asInstanceOf[String]
  ss.length
} else ???

generalSize("abc")
generalSize(Map(1 -> 'a', 2 -> 'b'))
generalSize(Map('1' -> 'a', '2' -> 'b'))
generalSize(math.Pi)

/** The only exception to the erasure rule is arrays, because they are handled specially
  * in Java as well as in Scala. The element type of an array is stored with the array
  * value, so you can pattern match on it. */
def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

isStringArray(Array(1, 2, 3))
isStringArray(Array("1", "2", "3"))

/** Variable binding
  * In addition to the standalone variable patterns, you can also add a variable to any other pattern. You
  * simply write the variable name, an at sign (@), and then the pattern. This gives you a variable-binding
  * pattern, which means the pattern is to perform the pattern match as normal, and if the pattern succeeds,
  * set the variable to the matched object just as with a simple variable pattern. */
val expr = (expr: Expr) => expr match {
  case UnOp("abs", e @ UnOp("abs", _)) => println(e)
  case _ => println("Default matching")
}

expr(UnOp("abs", UnOp("abs", Var(""))))
expr(UnOp("abs", Var("")))

/**PATTERN GUARDS
  * A pattern guard comes after a pattern and starts with an if. The guard can be an arbitrary boolean
  * expression, which typically refers to variables in the pattern. If a pattern guard is present, the match
  * succeeds only if the guard evaluates to true. */
def simplifyAdd(e: Expr) = e match {
  case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  case _ => e
}

// match only positive integers
//case n: Int if 0 < n => ???
// match only strings starting with the letter `a'
//case s: String if s(0) == 'a' => ???

/**PATTERN OVERLAPS*/

def simplifyAll(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => simplifyAll(e) // `-' is its own inverse
  case BinOp("+", e, Number(0)) => simplifyAll(e) // `0' is a neutral element for `+'
  case BinOp("*", e, Number(1)) => simplifyAll(e) // `1' is a neutral element for `*'
  case UnOp(op, e) => UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr
}

/** In this example, it is important that the catch-all cases come after the more specific simplification rules.
  * If you wrote them in the other order, then the catch-all case would be run in favor of the more specific
  *rules. In many cases, the compiler will even complain if you try. For example, here's
  * a match expression that won't compile because the first case will match anything that would be
  * matched by the second case: */
def simplifyBad(expr: Expr): Expr = expr match {
  case UnOp(op, e) => UnOp(op, simplifyBad(e))
  case UnOp("-", UnOp("-", e)) => e
}
//warning: unreachable code
//case UnOp("-", UnOp("-", e)) => e
