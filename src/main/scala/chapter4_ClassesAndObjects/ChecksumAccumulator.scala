package chapter4_ClassesAndObjects

class ChecksumAccumulatorRedundant {
  //   var sum = 0   //  Public is Scala's default access level.
  private var sum = 0

  def add(b: Byte): Unit = {
    //    b = 1  // This won't compile, because b is a val
    sum += b
  }

  def checksum(): Int = {
   return ~(sum & 0xFF) + 1  // redundant return
  }
}

/** **************************************************************************/
//A class and its companion object can access each other's private members.

//companion class
class ChecksumAccumulator {
  private var sum = 0

  // It is often better to explicitly provide the result types of
  // public methods declared in a class even when the compiler would infer it for you.
  def add(b: Byte): Unit = sum += b

  def checksum(): Int = ~(sum & 0xFF) + 1
}

//companion object
object ChecksumAccumulator {

  import scala.collection.mutable

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}
