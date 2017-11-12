
var increase = (x: Int) => x + 5
increase(2)
//because increase is var not a val
increase = (x: Int) => x + 1999
increase(2)
increase = (x: Int) => {
  println("We")
  println("are")
  println("here!")
  x + 1
}
increase(10)

//Usage first-class functions with foreach collection
val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x: Int) => println(x))
//at org.apache.commons.chain.impl.ChainBase.execute(ChainBase.java:190)
someNumbers.filter((x: Int) => x > 0)
//the same leave off the parameter types.
someNumbers.filter((x) => x > 0)
//or
someNumbers.filter(x => x > 0)
//Чтобы сделать литерал функции еще более кратким, вы можете использовать символы подчеркивания
// в качестве заполнителей для одного или нескольких  параметров,
// пока каждый параметр появляется только один раз в функциональном литерале.
someNumbers.filter(_ > 1)
someNumbers.foreach(println _)

val f = (x: Int, y: Int) => x + y
f(2, 3)
val f1 = (_: Int) + (_: Int)
f1(3, 5)

//PARTIALLY APPLIED FUNCTIONS
def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)
val a = sum _
a(4, 5, 6)
//the same
a.apply(1, 2, 3)
val b = sum(1, _: Int, _: Int)
b(2, 3)
val sumc = sum(1, 2, _: Int)
c(6)

//If you are writing a partially applied function expression in which you leave off all parameters,
//such as println _ or sum _, you can express it more concisely by leaving off the underscore
//if a function is required at that point in the code. For example, instead of printing out
//each of the numbers in someNumbers (defined here) like this:
someNumbers.foreach(println _)
//You could just write:
someNumbers.foreach(println)
//or
someNumbers.foreach(sumc _)
someNumbers.foreach(sumc)