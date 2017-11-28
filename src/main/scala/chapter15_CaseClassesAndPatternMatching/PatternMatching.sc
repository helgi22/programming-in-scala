/** Pattern matching */
/** Wildcard patterns
  * The wildcard pattern (_) matches any object whatsoever. You have already seen it used as a default,
  * catch-all alternative, like this: */
def d(expr: Any) = expr match {
  case BinOp(op, left, right) =>
    println(expr + " is a binary operation")
  case _ => // handle the default case
}

/** Wildcards can also be used to ignore parts of an object that you do not care about. */
def dd(expr: Any) = expr match {
  case BinOp(_, _, _) => println(expr + " is a binary operation")
  case _ => println("It's something else")
}

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
expr match {
  case 0 => "zero"
  case somethingElse => "not zero: " + somethingElse
}

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
E match {
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
E match {
  case `pi` => "strange math? Pi = " + pi
  case _ => "OK"
}
//res14: String = OK
