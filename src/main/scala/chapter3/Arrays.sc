import java.math.BigInteger

val big = new BigInteger("12345")

/** ****************************************/
//val greetString = new Array[String](3)
// the same
val greetString: Array[String] = new Array[String](3)
greetString(0) = "Hello"
//the same
greetString.update(0, "Hello")
greetString(1) = ", "
greetString(2) = "world! \n"

for (i <- 0 to 2)
  print(greetString(i))
//  the same
for (i <- 0.to(2))
  print(greetString.apply(i))

/** **********************************/
val numNames = Array("zero", "one", "two")
val numNames1 = Array.apply("zero", "one", "two")
/** **********************************/

Console.println(10)
//the same
Console println 10

1.+(2)
//the same
1 + 2