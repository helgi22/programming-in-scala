import scala.util.control.Breaks._
import java.io._
val in = new BufferedReader(new InputStreamReader(System.in))
//Class Breaks in package scala.util.control offers a break method,
// which can be used to exit an enclosing block that's marked with breakable.
//The Breaks class implements break by throwing an exception that is caught by
// an enclosing application of the breakable method.
// Therefore, the call to break does not need to be in the same method as the call to breakable.
  breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "")
      break
  }
}