/** Case classes */
abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

/** First, it adds a factory method with the name of the class. This means that, for instance, you can
  * write Var("x") to construct a Var object, instead of the slightly longer new Var("x")
  * */
val v = Var("x")
val op = BinOp("+", Number(1), v)

/** The second syntactic convenience is that all arguments in the parameter list of
  * a case class implicitly get a val prefix, so they are maintained as fields:
  * */

v.name
op.left

/** Third, the compiler adds "natural" implementations of methods toString, hashCode,
  * and equals to your class. They will print, hash, and compare a whole tree consisting
  * of the class and (recursively) all its arguments. Since == in Scala always delegates
  * to equals, this means that elements of case classes are always compared structurally:
  * */
println(op)
op.right == Var("x")

/** Finally, the compiler adds a copy method to your class for making modified copies.
  * This method is useful for making a new instance of the class that is the same as
  * another one except that one or two attributes are different. The method works
  * by using named and default parameters (see Section 8.8). You specify the
  * changes you'd like to make by using named parameters. For any parameter you don't
  * specify, the value from the old object is used */
val opp = op.copy(operator = "-",Number(2))
println(opp)
