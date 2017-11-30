/** PATTERNS EVERYWHERE
  * Patterns are allowed in many parts of Scala, not just in standalone match expressions.
  * Take a look at some other places you can use patterns. */
/*Patterns in variable definitions*/
val myTuple = (123, "abc")
val (number, string) = myTuple

/** This construct is quite useful when working with case classes.
  * If you know the precise case class you
  * are working with, then you can deconstruct it with a pattern. */

sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

val exp = new BinOp("*", Number(5), Number(1))
val BinOp(op, left, right) = exp
println(op+" "+ left+" "+right)