import chapter10_CompositionAndInheritance.Element
/**
  * The expression assert(condition) throws an AssertionError if condition does not hold.
  * There's also a two-argument version of assert: The expression assert(condition, explanation)
  * tests condition and, if it does not hold, throws an AssertionError that contains
  * the given explanation. The type of explanation is Any, so you can pass any object
  * as the explanation.
  */
def above(that: Element): Element = {
  val this1 = this widen that.width
  val that1 = that widen this.width
  assert(this1.width == that1.width)
  elem(this1.contents ++ that1.contents)
}

/**Another way, the ensuring method can be used with any result type because of an implicit
  * conversion.Although it looks in this code as if we're invoking ensuring on
  * widen's result, which is typeElement, we're actually invoking ensuring on
  * a type to which Element is implicitly converted. The ensuring method takes
  * one argument, a predicate function that takes a result type and returnsBoolean,
  * and passes the result to the predicate. If the predicate returns true,
  * ensuring will return the result; otherwise, ensuring will throw an AssertionError.
  * */

private def widen(w: Int): Element =
  if (w <= width)
    this
  else {
    val left = elem(' ', (w - width) / 2, height)
    var right = elem(' ', w - width - left.width, height)
    left beside this beside right
  } ensuring (w == _.width)

/**Assertions can be enabled and disabled using the JVM's -ea and -da command-line flags.
  * When enabled, each assertion serves as a little test that uses the actual data encountered
  * as the software runs
  * */