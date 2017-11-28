/**More detail on ScalaTest is available from
  * http://www.scalatest.org/
  * You can download specs2 from
  * http://specs2.org/.
  */
/** TESTS AS SPECIFICATIONS */

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import Element.elem

class ElementSpec extends FlatSpec with Matchers {
  "A UniformElement" should
    "have a width equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.width should be(2)
  }
  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be(3)
  }
  it should "throw an IAE if passed a negative width" in {
    an[IllegalArgumentException] should be thrownBy {
      elem('x', -2, 3)
    }
  }
}


scala > (new ElementSpec).execute()

/**
  * One of the big ideas of BDD is that tests can be used to facilitate communication between the people
  * who decide what a software system should do, the people who implement the software, and the people
  * who determine whether the software is finished and working. Although any of ScalaTest's or specs2's
  * styles can be used in this manner, ScalaTest'sFeatureSpec in particular is designed for it. Listing
  *14.6 shows an example:
  */
import org.scalatest._
class TVSetSpec extends FeatureSpec with GivenWhenThen {
  feature("TV power button") {
    scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      When("the power button is pressed")
      Then("the TV should switch on")
      pending
    }
  }
}

