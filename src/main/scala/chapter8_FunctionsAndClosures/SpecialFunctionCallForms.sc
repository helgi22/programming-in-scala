//Repeated parameters
object SpecialFunctionCallForms {
  def main(args: Array[String]): Unit = {
    echo("test", "test1", "test2")
    //
    //    echo(args)  error: type mismatch, so it needs special type as _*
    echo(args: _*)
  }

  def speed(distance: Float, time: Float): Float =
    distance / time

  //Default parameter values
  def printTime(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
    out.println("time = " + System.currentTimeMillis() / divisor)

  private def echo(args: String*): Unit = {
    for (arg <- args) println(arg)
  }
}

SpecialFunctionCallForms.main(Array("arg1", "arg2", "arg3"))

//Named arguments
SpecialFunctionCallForms.speed(distance = 100f, time = 60F)
SpecialFunctionCallForms.speed(time = 60F, distance = 100f)

//Default parameter values

SpecialFunctionCallForms.printTime(divisor = 1000)
SpecialFunctionCallForms.printTime(out = Console.err)
