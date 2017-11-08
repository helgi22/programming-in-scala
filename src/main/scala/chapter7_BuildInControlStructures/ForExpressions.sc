val pathTo = "C:/MyProgram/Scala/programming-in-scala/src/main/scala/chapter3"

object ForExpressions {
  def main(args: Array[String]): Unit = {
    val listFiles = new java.io.File(args(0)).listFiles
    for (file <- listFiles)
      println(file)

  }
}

ForExpressions.main(Array[String](pathTo))

for (i <- 1 to 10) println("Iteration " + i)
for (i <- 1 until 10) println("Iteration " + i)

//Filtering
val filesHere = new java.io.File(pathTo).listFiles
for (file <- filesHere if file.getName.endsWith("e.dll")) println(file.getAbsolutePath)
//or alternatively

for (
  file <- filesHere)
  if (file.getName.endsWith("da.dll")
  ) println(file)

//Multi filtering
for (
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".scala")
) println(file)

//Nested iteration
def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file + ": " + trimmed)

grep(".*")

//Producing a new collection
def scalaFiles =
  for (
    file <- filesHere
    if file.getName.endsWith(".scala")
  ) yield file

scalaFiles.foreach(println)