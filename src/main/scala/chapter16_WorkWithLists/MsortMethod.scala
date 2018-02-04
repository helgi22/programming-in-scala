package chapter16_WorkWithLists

object MsortMethod {

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y))
          x :: merge(xs1, ys)
        else
          y :: merge(xs, ys1)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  def main(args: Array[String]): Unit = {

    val inSort = msort((x: Int, y: Int) => x < y) _
    val reverseInSort = msort((x: Int, y: Int) => x > y) _
    val rez = inSort(List(1, 3, 2, 7, 5, 6))
    val reverseRes = reverseInSort(List(1, 3, 2, 7, 5, 6))
    println(s"Result is $rez and reverse $reverseRes")
  }
}
