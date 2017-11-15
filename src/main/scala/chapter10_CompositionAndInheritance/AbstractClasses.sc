abstract class Element {
  def contents: Array[String]

  val height: Int = contents.length

  val width: Int = if (height == 0) 0 else contents(0).length
}


//To summarize, it is encouraged in Scala to define methods that take no parameters and have
//no side effects as parameterless methods (i.e., leaving off the empty parentheses).
//On the other hand, you should never define a method that has side-effects without parentheses,
//because invocations of that method would then look like a field selection.
//So your clients might be surprised to see the side effects.

"hello".length // no () because no side-effect
println() // better to not drop the ()


class ElementArray(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

val ae: Element = new ElementArray(Array("test-0", "test-1", ""))
ae.height
ae.width
ae.contents.apply(0)
ae.contents(1)

//AnyRef -> Element -> ElementArray
//superclass  -> subclass/superclass  -> subclass

//Inheritance means that all members of the superclass are also members of the subclass,
//with two exceptions. First, private members of the superclass are not inherited in a subclass.
//Second, a member of a superclass is not inherited if a member with the same name and parameters
//is already implemented in the subclass. In that case we say the member of the subclass overrides
//the member of the superclass. If the member in the subclass is concrete and the member
//of the superclass is abstract, we also say that the concrete memberimplements the abstract one.


//Generally, Scala has just two namespaces for definitions in place of Java's four.
//Java's four namespaces are fields, methods, types, and packages.
//By contrast, Scala's two namespaces are:
//• values (fields, methods, packages, and singleton objects)
//• types (class and trait names)

//DEFINING PARAMETRIC FIELDS
//Note that now the contents parameter is prefixed by val (should be var).
//This is a shorthand that defines at the same
//time a parameter and field with the same name.
class ArrayElement(val contents: Array[String]) extends Element

//the same as
//class ArrayElement(x123: Array[String]) extends Element {
//  val contents: Array[String] = x123
//}

//You can also prefix a class parameter with var, in which case the corresponding field would be
//reassignable. Finally, it is possible to add modifiers, such as private, protected,
//or override to these parametric fields, just as you can for any other class member.
//Consider, for instance, the following class definitions:
class Cat {
  val dangerous = false
}

class Tiger(
             override val dangerous: Boolean,
             private var age: Int
           ) extends Cat

val tgr = new Tiger(true,1)
tgr.dangerous
