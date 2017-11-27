
class ElementSuite extends FunSuite {
  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}


val width = 3
assert(width == 2)

assert(List(1, 2, 3).contains(4))

/** If you wish to emphasize the distinction between actual and expected, you can alternatively
  * use ScalaTest's assertResult method, like this:
  */
assertResult(2) {
  ele.width
}

/** With this expression you indicate that you expect the code between the curly braces to result in 2. Were
  * the code between the braces to result in 3, you'd see the message, "Expected 2, but got 3" in the test
  * failure report.
  * */


/**
  * If you want to check that a method throws an expected exception, you can use
  * ScalaTest'sassertThrows method, like this:
  */
assertThrows[IllegalArgumentException] {
  elem('x', -2, 3)
}

/** If the code between the curly braces throws a different exception than expected, or throws no
  * exception, assertThrows will complete abruptly with a TestFailedException. */


/** On the other hand, if the code completes abruptly with an instance of the passed exception
  * class, assertThrows will return normally. If you wish to inspect the expected exception further,
  * you can use intercept instead of assertThrows. The intercept method works the same asassertThrows,
  * except if the expected exception is thrown, intercept returns it: */
val caught =
  intercept[ArithmeticException] {
    1 / 0
  }
assert(caught.getMessage == "/ by zero")

