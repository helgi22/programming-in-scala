import scala.io.Source

object LongLines {

  def processFiles(fileName: String, widh: Int): Unit = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines())
      processLines(fileName, widh, line)
  }

  private def processLines(fileName: String, width: Int, line: String): Unit = {
    if (line.length > width)
      println(fileName + ": " + line.trim)
  }
}

//The same with local function, simpler than previous
object LongFile1 {
  def processFile(filename: String, width: Int) = {

    // local processLine function
    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(line)
    }
  }
}

object FindLongLines {
  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFiles(arg, width)
  }
}

//run script like
//scala FindLongLines 45 LongLines.scala
//FindLongLines.main(Array("45", "LongLines.sc"))
