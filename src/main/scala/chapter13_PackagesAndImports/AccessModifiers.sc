/** 13.5 ACCESS MODIFIERS */
/**
  * Private members
  * Private members in Scala are treated similarly to Java. A member labeled private
  * is visible only inside  the class or object that contains the member definition.
  * In Scala, this rule applies also for inner classes
  */
class Outer {

  class Inner {
    private def f() = {
      println("f")
    }

    class InnerMost {
      f() // OK
    }

  }

  (new Inner).f() // error: f is not accessible
}


/**
  * Protected members
  * Access to protected members in Scala is also a bit more restrictive than in Java. In Scala,
  * a protected member is only accessible from subclasses of the class in which the member
  * is defined. In Java such accesses are also possible from other classes in the same package.
  */
package p {

  class Super {
    protected def f() = {
      println("f")
    }
  }

  class Sub extends Super {
    f()
  }

  class Other {
    (new Super).f() // error: f is not accessible
  }

}


/**
  * Public members
  * Scala has no explicit modifier for public members: Any member not labeled
  * private or protected is public. Public members can be accessed from anywhere
  */
package bobsrockets

package navigation {

  private[bobsrockets] class Navigator {
    protected[navigation] def useStarChart() = {}

    class LegOfJourney {
      private[Navigator] val distance = 100
    }

    private[this] var speed = 200
  }

}

package launch {

  object Vehicle {
    private[launch] val guide = new Navigator
  }

}


/**
  * Scope of protection
  * Access modifiers in Scala can be augmented with qualifiers. A modifier of the
  * form private[X]or protected[X] means that access is private or protected "up to" X,
  * where X designates some enclosing package, class or singleton object.
  */

/** no access modifier public access */
private[bobsrockets] //access within outer package
private[navigation] //same as package visibility in Java
private[Navigator] //same as private in Java
private[LegOfJourney] //same as private in Scala
private[this] //access only from same object

/**
  * Visibility and companion objects
  * In Java, static members and instance members belong to the same class, so access modifiers apply
  * uniformly to them. You have already seen that in Scala there are no static members; instead you can
  * have a companion object that contains members that exist only once. For instance, in Listing
  *13.13 object Rocket is a companion of class Rocket.
  */


/** Listing 13.13 - Accessing private members of companion classes and objects. */
class Rocket {

  import Rocket.fuel

  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10

  def chooseStrategy(rocket: Rocket) = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }

  def goHome() = {}

  def pickAStar() = {}
}

/**
  * Scala's access rules privilege companion objects and classes when it comes
  * to private or protected accesses. A class shares all its access rights with
  * its companion object and vice versa. In particular, an object can access all
  * private members of its companion class, just as a class can access all private
  * members of its companion object. One exception where the similarity between Scala
  * and Java breaks down concerns protected static members. A protected static member
  * of a Java class C can be accessed in all  subclasses of C. By contrast, a protected
  * member in a companion object makes no sense, as singleton objects don't have any subclasses.
  */

/**
  * 13.6 PACKAGE OBJECTS
  *
  **/

// In file bobsdelights/package.scala
package object bobsdelights {
  def showFruit(fruit: Fruit) = {
    println(name + "s are " + color)
  }
}

// In file PrintMenu.scala
package printmenu

import bobsdelights.showFruit

object PrintMenu {
  def main(args: Array[String]) = {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}