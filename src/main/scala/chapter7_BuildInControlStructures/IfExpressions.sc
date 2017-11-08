object IfExpressions {

  def main(args: Array[String]) {

    var fileName = "default.txt"
    if (!args.isEmpty)
      fileName = args(0)

//    Other way to use immutable val instead of a var (functional style)
    val fileNameImmutable = if (!args.isEmpty) args(0) else "default.txt"
    Console.println(fileNameImmutable)
//    Or just
    Console.println(if (!args.isEmpty) args(0) else "default.txt")
  }
}


IfExpressions.main(Array[String]("SideEffect", "test2"))