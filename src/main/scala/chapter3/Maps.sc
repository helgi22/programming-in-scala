import scala.collection.mutable

//val treasureMap: mutable.Map[Int,String] = mutable.Map.apply()
//val treasureMap = mutable.Map.apply[Int,String]()
//the same as
val treasureMap = mutable.Map[Int,String]()
treasureMap += (1 -> "Go to island")
//the same
treasureMap.+=(2 -> "Find big X on ground.")
//the same
treasureMap += ((3).->("Dig."))
println(treasureMap(2))

//Default import immutable Map
val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))
println(romanNumeral.apply(1))
println(romanNumeral.contains(6))