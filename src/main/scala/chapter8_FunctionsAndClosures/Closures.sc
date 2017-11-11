
var more = 1

val addMore = (x: Int) => x + more
more = addMore(10)

//more = 11

more = addMore(20)
addMore(30)



val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum= 0
someNumbers.foreach(sum += _)
println(sum)