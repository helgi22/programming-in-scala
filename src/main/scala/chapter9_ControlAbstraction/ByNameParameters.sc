//Without using by-name parameters, you could write myAssert like this:
var assertionsEnabled = true
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError
//usage
myAssert(() => 5 > 3)

//You would really prefer to leave out the empty parameter list and => symbol in the function literal and
//  write the code like this:
//  myAssert(5 > 3) // Won't work, because missing () =>

//By-name parameters exist precisely so that you can do this. To make a by-name parameter, you give the
//parameter a type starting with => instead of () =>.

def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

//now it will work
byNameAssert(5 > 3)

//A by-name type, in which the empty parameter list, (), is left out, is only allowed for parameters.
// There is no such thing as a by-name variable or a by-name field.


//Now, you may be wondering why you couldn't simply write myAssert using a plain old Boolean for the
//type of its parameter, like this:
def boolAssert(predicate: Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

boolAssert(5 > 3)

//The difference between the two approaches, therefore, is that if assertions are disabled,
//you'll see any side effects that the expression inside the parentheses may have in boolAssert, but not
//in byNameAssert. For example, if assertions are disabled, attempting to assert on "x / 0 == 0" will yield
//an exception in boolAssert's case.
// But attempting to assert on the same code in byNameAssert's case will not yield an exception:
val x = 5
assertionsEnabled = false

byNameAssert(x / 0 == 0)

boolAssert(x / 0 == 0)