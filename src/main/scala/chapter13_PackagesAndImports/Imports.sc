/** *
  * A simple name x. This includes x in the set of imported names.
  * • A renaming clause x => y. This makes the member named x visible under the name y.
  * • A hiding clause x => _. This excludes x from the set of imported names.
  * • A catch-all `_'. This imports all members except those members mentioned in a preceding
  *clause. If a catch-all is given, it must come last in the list of import selectors.
  **/


package bobsdelights

abstract class Fruit(
                      val name: String,
                      val color: String
                    )

object Fruits {

  object Apple extends Fruit("apple", "red")

  object Orange extends Fruit("orange", "orange")

  object Pear extends Fruit("pear", "yellowish")

  val menu = List(Apple, Orange, Pear)
}


object Imports {
  // easy access to Fruit
  // easy access to all members of bobsdelights
  // easy access to all members of Fruits

  /** Listing 13.8 - Importing the members of a regular (not singleton) object. */
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }
}

/** This imports just members Apple and Orange from object Fruits. */ {
Apple => McIntosh, Orange
}

import java.sql.{Date => SDate}
import java.{sql => S}

S.Date

/** This imports all members from object Fruits but renames Apple to McIntosh. */

import bobsdelights.Fruits.{Apple => McIntosh}

/** This imports all members of Fruits except Pear. */

import bobsdelights.Fruits.{Pear => _}


/**13.4 IMPLICIT IMPORTS
  * Scala adds some imports implicitly to every program.
  * */
import java.lang._ // everything in the java.lang package
import scala._ // everything in the scala package
import Predef._ // everything in the Predef object
