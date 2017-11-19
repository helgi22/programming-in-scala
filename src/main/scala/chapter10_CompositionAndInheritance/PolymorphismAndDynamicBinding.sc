//The method invocations on variables and expressions are dynamically bound.
// This means that the actual method implementation invoked is determined at run
// time based on the class of the object, not the type of the variable or expression.
abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
}

class ArrayElement extends Element {
  override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

class LineElement extends ArrayElement {
  override def demo() = {
    println("LineElement's implementation invoked")
  }
}

// UniformElement inherits Element's demo
class UniformElement extends Element

//////////////////////
def invokeDemo(e: Element) = {
  e.demo()
}

invokeDemo(new ArrayElement)
invokeDemo(new LineElement)
//Because UniformElement does not override demo, it inherits the implementation of demo from its
//superclass, Element. Thus, Element's implementation is the correct implementation of demo to invoke
//when the class of the object is UniformElement.
invokeDemo(new UniformElement)


