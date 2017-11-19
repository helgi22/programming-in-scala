//In Scala, every class inherits from a common
//superclass named Any. At the top of the hierarchy is class Any, which
//defines methods that include the following:

//final def ==(that: Any): Boolean
//final def !=(that: Any): Boolean
//def equals(that: Any): Boolean
//def ##: Int
//def hashCode: Int
//def toString: String
42.toString
42.hashCode

42 == 42

val x = new String("abc")
val y = new String("abc")

x == y
x eq y
x ne y

//BOTTOM TYPES
//In scala you can see the two classes scala.Null andscala.Nothing
//Class Null is the type of the null reference; it is a subclass of every reference class
// (i.e., every class that itself inherits from AnyRef). Null is not compatible with value types.
//val i: Int = null //error: an expression of type Null is ineligible

//Тип Nothing находится в самом низу иерархии классов Scala; это подтип любого другого типа.
// Однако таких значений не существует. Почему имеет смысл иметь тип без значений?
// Как описано в разделе 7.4, одно использование Nothing - это то, что оно сигнализирует
// о ненормальном завершении.

def error(message: String): Nothing =
  throw new RuntimeException(message)

//The "then" branch of the conditional, x / y, has type Int, whereas the else branch,
// the call to error, has type Nothing. Because Nothing is a subtype of Int,
// the type of the whole conditional is Int, as required.
def divide(x: Int, y: Int): Int =
  if (y != 0) x / y
  else error("can't divide by zero")

//////////////////////////Avoiding a types monoculture///////////////////
//The compiler can be more helpful if you define a tiny type for each domain concept.
// For example, you could define a small class for styles, anchor identifiers, display text,
// and HTML. Since these classes have one parameter and no members, they can be defined
// as value classes:

class Anchor(val value: String) extends AnyVal

class Style(val value: String) extends AnyVal

class Text(val value: String) extends AnyVal

class Html(val value: String) extends AnyVal

//Given these classes, it is possible to write a version of title that has a less trivial type signature:
def title(text: Text, anchor: Anchor, style: Style): Html =
  new Html(
    s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" +
      text.value +
      "</h1></a>"
  )

//If you try to use this version with the arguments in the wrong order, the compiler can now detect the
//  error.