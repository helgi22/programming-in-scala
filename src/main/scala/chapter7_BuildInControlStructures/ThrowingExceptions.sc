object ThrowingExceptions {
  def main(args: Array[String]): Unit = {
    val half = if (args(0).toInt % 2 == 0)
      args(0).toInt % 2
    else
    //    an exception throw has type Nothing.
      throw new RuntimeException("args must be even")
  }
}

//ThrowingExceptions.main(Array("5"))


import java.net.{MalformedURLException, URL}

//Yielding a value
def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }


//The finally clause
import java.io.{FileNotFoundException, FileReader, IOException}

val fileReader: FileReader = new FileReader("input.txt")
try {
  // Use and close file
} finally {
  //The best way to think  of finally clauses is as a way to ensure some side effect happens,
  //such as closing an open file.
  println("Finally clause exec")
  fileReader.close()
}

//Catching exceptions
try {
  val file = new FileReader("input.txt")
  // Use and close file
  file.read()
} catch {
  case ex: FileNotFoundException => println(ex.toString + " FileNotFoundException") // Handle missing file
  case ex: IOException => println(ex.toString + " IOException") // Handle other I/O error
}
