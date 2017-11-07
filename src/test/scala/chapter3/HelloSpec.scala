package chapter3

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }
  it should "current time" in {
    Hello.executionStart === System.currentTimeMillis()
  }
}