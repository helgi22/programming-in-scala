/**12.7 TO TRAIT OR NOT TO TRAIT?*/

/**If the behavior will not be reused, then make it a concrete class.
  * It is not reusable behavior after all.
  * If it might be reused in multiple, unrelated classes, make it a trait.
  * Only traits can be mixed into different parts of the class hierarchy.
  * */

/**
  * If you want to inherit from it in Java code, use an abstract class.
  * Since traits with code do not have a close Java analog, it tends to be awkward
  * to inherit from a trait in a Java class. Inheriting from a Scala class, meanwhile,
  * is exactly like inheriting from a Java class. As one exception, a Scala trait with
  * only abstract members translates directly to a Java interface, so you should feel
  * free to define such traits even if you expect Java code to inherit from it.
  * See Chapter 31 for more information on working with Java and Scala together.
  * */

/**
  * If you plan to distribute it in compiled form, and you expect outside groups
  * to write classes inheriting from it, you might lean towards using an abstract class.
  * The issue is that when a trait gains or loses a member, any classes that inherit from
  * it must be recompiled, even if they have not changed. If outside clients will only call
  * into the behavior, instead of inheriting from it, then using a trait is fine.
  * */