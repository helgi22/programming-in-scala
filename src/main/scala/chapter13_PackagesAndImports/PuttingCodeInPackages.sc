/** 13.1 PUTTING CODE IN PACKAGES */
package bobsrockets.navigation

class Navigator

//or
package bobsrockets.navigation {

  class Navigator

}

/**
  * However, one use of the more general notation is to have different parts of a file
  * in different packages. For example, you might include a class's tests in the same file
  * as the original code, but put the tests in a different package.
  */

package bobsrockets {
  package navigation {

    // In package bobsrockets.navigation
    class Navigator
    package tests {

      // In package bobsrockets.navigation.tests
      class NavigatorSuite

    }

  }

}

/** Multiple packages in the same file. */
package bobsrockets1 {

  package navigation {

    class Navigator {
      // No need to say bobsrockets.navigation.StarMap
      val map = new StarMap
    }

    class StarMap

  }

  class Ship {
    // No need to say bobsrockets.navigation.Navigator
    val nav = new navigation.Navigator
  }
  package fleets {

    class Fleet {
      // No need to say bobsrockets.Ship
      def addShip() = {
        new Ship
      }
    }

  }

}

/**
  * Listing 13.5 - Symbols in enclosing packages not automatically available.
  * Scala provides a package named _root_ that is outside any package a user can
  *write. Put another way, every top-level package you can write is treated as a member of
  * package _root_
  */
// In file launch.scala
package launch {

  class Booster3

}

// In file bobsrockets.scala
package bobsrockets {
  package navigation {
    package launch {

      class Booster1

    }

    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      val booster3 = new _root_.launch.Booster3
    }

  }

  package launch {

    class Booster2

  }

}