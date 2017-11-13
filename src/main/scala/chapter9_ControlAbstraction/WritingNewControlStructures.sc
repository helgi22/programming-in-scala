
def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 3, 5) //5 + 3 + 3 =11.0

//Рассмотрим теперь более широко используемую схему кодирования: откройте ресурс,
// выполнить на нем действия, а затем закрыть ресурс.
// Вы можете зафиксировать это в абстракции управления,
// используя метод, подобный следующему:

import java.io.{File, PrintWriter}

def withPrintWriter(file: java.io.File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
//The advantage of using this method is that it's withPrintWriter, not user code,
// that assures the file is closed at the end. So it's impossible to forget to close the file.
// This technique is called the loan pattern, because a control-abstraction function,
// such as withPrintWriter, opens a resource and "loans" it to a function.
//usage

withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

//One way in which you can make the client code look a bit more like a built-in control structure
//is to use curly braces instead of parentheses to surround the argument list.
// In any method invocation in Scala in which you're passing in exactly one argument,
// you can opt to use curly braces to surround the argument instead of parentheses.
//For example, instead of:
println("Hello, world!")
//You could write:
println {
  "Hello, world!"
}
//This curly braces technique will work, however, only if you're passing in one argument.

val g = "Hello, world!"
g.substring(7, 9)
//g.substring { 7, 9 }  //:1: error: ';' expected but ',' found.

//The purpose of this ability to substitute curly braces for parentheses for passing
//in one argument is to enable client programmers to write function literals between curly braces.
//This can make a method call feel more like a control abstraction.

def withPritWriten1(file: java.io.File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

//usage
val file = new File("date.txt")
withPritWriten1(file) {
  writer => writer.println(new java.util.Date())
}

//In this example, the first argument list, which contains one File argument, is written surrounded by
//parentheses. The second argument list, which contains one function argument, is surrounded by curly
//braces.