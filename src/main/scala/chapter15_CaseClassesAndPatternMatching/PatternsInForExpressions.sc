

/** Patterns in for expressions */
/*A for expression with a tuple pattern.*/
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

for ((country, city) <- capitals)
  println("The capital of " + country + " is " + city)


/*As you can see from this example, generated values that do not match the pattern are discarded. */
val results = List(Some("apple"), None, Some("orange"))
for (Some(fruit) <- results)
  println(fruit)

