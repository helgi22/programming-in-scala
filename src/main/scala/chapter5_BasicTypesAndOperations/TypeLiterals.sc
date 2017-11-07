//If the number begins with a 0x or 0X, it is hexadecimal (base 16)
val hex = 0x5
val hex2= 0x00ff
val magic = 0xcafebabe

// If the number begins with a non-zero digit, and is otherwise undecorated, it is decimal (base 10)
val dec1 = 31
val dec2 = 255
val dec3 = 20

//If an integer literal ends in an L or l, it is a Long;
val prog = 0XCAFEBABEL
val tower = 35L
val of = 31l

//short & Byte
val little: Short = 367
val littler: Byte = 38

//Floating point literals
val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45
val litttle = 1.2345F
val littleBigger = 3e5f
val anotherDouble = 3e5
//the same
val yetAnother = 3e5D

//Character literals
val a = 'A'

//a character using its Unicode code point.
val d = '\u0044'
val f = '\u0046'

//a few character literals represented by special escape sequences
val backslash = '\\'

//Literal Meaning
//  \n line feed (\u000A)
//\b backspace (\u0008)
//\t tab (\u0009)
//\f form feed (\u000C)
//\r carriage return (\u000D)
//\" double quote (\u0022)
//\' single quote (\u0027)
//\\ backslash (\u005C)

//String literals
val hello = "hello"
val escapes = "\\\"\'"
println(
  """Welcome to Ultamix 3000.
        Type "HELP" for help.""")

println("""|Welcome to Ultamix 3000.
                |Type "HELP" for help.""".stripMargin)


//Symbol literals
val s = 'aSymbol
val nm = s.name

//Boolean literals
val bool = true
val fool = false

/****************** STRING INTERPOLATION***************************/
//The expression, s"Hello, $name!" is a processed string literal.
val name = "reader"
println(s"Hello, $name!")

val otherName = s"The answer is ${6 * 7}."
println(otherName)

f"${math.Pi}%.5f"

val pi = "Pi"
f"$pi is approximately ${math.Pi}%.8f."

val ss = "Hello, world!"
ss indexOf 'o'
