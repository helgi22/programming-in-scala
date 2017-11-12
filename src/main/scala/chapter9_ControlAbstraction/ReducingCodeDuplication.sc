//higher-order functions—functions that take functions as parameters—give you extra
//opportunities to condense and simplify code.

object ReducingCodeDuplication {
  private def filesHere: Array[java.io.File] = (new java.io.File(".")).listFiles

  def filesEnding(query: String) = {
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file
  }

  //differ only contains and endWith functions
  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

//An example of another implementation with a higher-order function
  def filesEndingF(query: String) = {
    filesMatching(query, _.endsWith(_))
    //the same as (fileName: String, query: String) => fileName.endsWith(query)
  }

  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query))
      yield file
  }
}


//This example demonstrates the way in which first-class functions can help you eliminate code
//duplication where it would be very difficult to do so without them.
object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}

