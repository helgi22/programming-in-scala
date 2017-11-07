import scala.collection.mutable.ListBuffer

/** ************************* LIST **********************************/
val oneTwo = List(1, 2)
val threeFour = List.apply(3, 4)
//List has a method named `:::' for list concatenation.
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

/** ------------------------------------------------------------ **/
//Perhaps the most common operator you'll use with lists is `::', which is pronounced "cons."Cons
// prepends a new element to the beginning of an existing list and returns the resulting list.
val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)

//a shorthand way to specify an empty list is Nil, one way to initialize new lists is to string
//  together elements with the cons operator, with Nil as the last element
val oneTwoThree1 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree1)

val emp: List[String] = "q" :: "qq" :: Nil
val w = emp :+ "qqq"
w.flatten

/*the Best way to append existing List*/
val list: List[Int] = List(10000)
val newlist = list ::: new ListBuffer().:+(10).:+(21).:+(35).:+(44).toList
newlist.map(e => e * 10)

newlist.foreach(println)

/** ****************************** SET *****************************/

import scala.collection.immutable

var jetSet: Set[String] = immutable.Set("Boeing", "Airbas")
//the same
//var jetSet = Set.apply("Boeing","Airbas")
jetSet += "Lear"
jetSet.+=("Cessna")
println(jetSet.contains("Cessna"))
println(jetSet)

import scala.collection.mutable

val movieSet: mutable.Set[String] = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
movieSet.+=("Kot")
println(movieSet)


import scala.collection.immutable
val hashSet = immutable.HashSet("Tomatoes", "Chilies")
println(hashSet+"Coriander")