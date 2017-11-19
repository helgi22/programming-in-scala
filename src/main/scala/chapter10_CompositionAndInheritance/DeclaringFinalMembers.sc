//DECLARING FINAL MEMBERS
//Sometimes when designing an inheritance hierarchy, you want to ensure that a member cannot be
//overridden by subclasses. In Scala, as in Java, you do this by adding a finalmodifier to the member.

abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
}

class ArrayElement extends Element {
  final override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

//////////////method demo cannot override final member/////////////
//class LineElement extends ArrayElement {
//  override def demo() = {
//    println("LineElement's implementation invoked")
//  }
//}


//You may also at times want to ensure that an entire class not be subclassed. To do this you simply
//declare the entire class final by adding a final modifier to the class declaration.
final class ArrayOtherElement extends Element {
  override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}
//With this version of ArrayElement, any attempt at defining a subclass would fail to compile
//error: illegal inheritance from final class
//class  ArraySomeElement extends ArrayOtherElement
