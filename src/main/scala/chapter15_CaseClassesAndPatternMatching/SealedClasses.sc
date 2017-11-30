/** SEALED CLASSES */
/**
  * If you write a hierarchy of classes intended to be pattern matched, you should consider sealing them.
  * Simply put the sealed keyword in front of the class at the top of the hierarchy. Programmers using
  * your class hierarchy will then feel confident in pattern matching against it. The sealed keyword,
  * therefore, is often a license to pattern match. Listing 15.16 shows an example in which Expr
  * is turned into a sealed class.
  */

sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

//def describe(e: Expr): String = e match {
//  case Number(_) => "a number"
//  case Var(_) => "a variable"
//}
//You will get a compiler warning like the following:
// warning: match is not exhaustive!
// missing combination UnOp
// missing combination BinOp

/** However, at times you might encounter a situation where the compiler is too picky in emitting the
  *warning. For instance, you might know from the context that you will only ever apply
  * the describe method above to expressions that are either Numbers or Vars, so you know that
  * no MatchError will be produced. To make the warning go away, you could add an @unchecked annotation
  * to the selector expression of the match. This is done as follows: */

def describe(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_) => "a variable"
}

