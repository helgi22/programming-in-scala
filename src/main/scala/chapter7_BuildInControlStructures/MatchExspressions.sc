object MatchExspressions {
  def main(args: Array[String]): Unit = {
    val firstArg = if (args.length > 0) args(0) else ""

    val friend = firstArg match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
    println(friend + "><" + firstArg)
  }
}

MatchExspressions.main(Array("salt"))
MatchExspressions.main(Array("eggs"))
MatchExspressions.main(Array("s"))
