/**
  * Created by Oleg.Galaykovskiy on 18.08.2017.
  * WRITE SOME SCALA SCRIPTS
  * Usage as <->  scala ./src/main/scala/chapter3/HelloScript.scala Oleg
  */
if (args.nonEmpty) {
  var i = 0
  while (i < args.length) {
    print(" ")
    print(args(i))
    i += 1
  }
  println
  println("Hello world, from script " + args(0) + "!")

}
else

  println("Hello world, from script!")
//Iterate with FOREACH
  args.foreach((arg: String) => println(arg))
//the same
  args.foreach(arg => println(arg))
//If a function literal consists of one statement that takes a single argument
  args.foreach(println)