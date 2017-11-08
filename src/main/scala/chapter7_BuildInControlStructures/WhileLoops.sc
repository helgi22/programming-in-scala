
object WhileLoops {
  def main(args: Array[String]): Unit = {

    //   Do while loop
    /*var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")*/
  }

  //!!!Because the while loop results in no value (it is Unit ),
  // it is often left out of pure functional languages.
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    // while loop. The type of the result is Unit and is written ()
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  //  The same but in functional style with recursion
  def gcd(x: Long, y: Long): Long = {
    if (y == 0) x else gcd(y, x % y)
  }
}


WhileLoops.main(Array[String]("test"))

//The existence of () is how Scala's Unit differs from Java's void.
//Because no equals sign precedes its body, greet is defined to be a procedure
// with a result type of Unit.
def greet() {
  println("hi")
}
() == greet()
