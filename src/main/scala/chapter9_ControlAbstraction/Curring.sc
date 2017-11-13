def plaintOldSuum(x: Int, y: Int) = x.+(y)
plaintOldSuum(1, 2)

def curriedSum(x: Int)(y: Int): Int = x + y
curriedSum(1)(2)

//The underscore in curriedSum(1)_ is a placeholder for the second parameter list.
val onePlus = curriedSum(1) _
onePlus(2)


//These first and second functions are just an illustration of the currying process.
def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)