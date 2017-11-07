/*To add two rationals, you must first obtain a common denominator, then add the two numerators.
For example, to add1/2 + 2/3, you multiply both parts of the left operand by 3 and both parts of
the right operand by 2, which gives you 3/6 + 4/6.
Adding the two numerators yields the result, 7/6. To multiply two rational numbers, you can simply
multiply their numerators and multiply their denominators. Thus, 1/2 * 2/5 gives 2/10, which can be
represented more compactly in its "normalized" form as 1/5. You divide by swapping the numerator
and denominator of the right operand and then multiplying. For instance 1/2 / 3/5 is the same
as 1/2 * 5/3, or 5/6. */

class Rational(n: Int, d: Int) {
  require(d != 0, "denominator should not be equals zero")
  private val g: Int = gcd(n.abs, d.abs)
  //To get this to compile, you would need to insert an extra space before the colon, as in:
  val numer_ : Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) //Auxiliary constructor

  //  printf("Created %s/%s\n", n, d)

  def +(that: Rational): Rational = add(that)

  def +(i: Int): Rational = new Rational(numer_ + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(
      numer_ * that.denom - that.numer_ * denom,
      denom * that.denom
    )

  def -(i: Int): Rational =
    new Rational(numer_ - i * denom, denom)

  def *(that: Rational): Rational = new Rational(numer_ * that.numer_, denom * that.denom)

  def *(i: Int): Rational = new Rational(numer_ * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer_ * that.denom, denom * that.numer_)

  def /(i: Int): Rational =
    new Rational(numer_, denom * i)

  def lessThen(that: Rational): Boolean = this.numer_ * that.denom < that.numer_ * this.denom

  def max(that: Rational): Rational = if (lessThen(that)) that else this

  private def add(that: Rational): Rational =
    new Rational(
      numer_ * that.denom + that.numer_ * denom,
      that.denom * denom
    )

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else {
      printf("a %% b = %s %% %s = %s \n", a, b, a % b);
      gcd(b, a % b)
    }

  override def toString = n + "/" + d + " and greatest common divisor " + numer_ + "/" + denom
}

val wholeNum = new Rational(5)
val oneHalf = new Rational(1, 2)
val twoThirds = new Rational(2, 3)
val gcdNum = new Rational(66, 42)
//val dnz = new Rational(1, 0)

val resSum = oneHalf + twoThirds
println(resSum.numer_)
println(resSum.denom)

val resMult = oneHalf * twoThirds
val resMult1 = oneHalf * 20

implicit def intToRational(x: Int) = new Rational(x)

val implicitNum = 2 * gcdNum
oneHalf.lessThen(twoThirds)

oneHalf max wholeNum
