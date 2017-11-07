package chapter4_ClassesAndObjects

import chapter4_ClassesAndObjects.ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  if (args.length > 0)
    args.foreach(println)
  else {
    for (season <- List("fall", "winter", "spring"))
      println(season + ": " + calculate(season))
  }
}
