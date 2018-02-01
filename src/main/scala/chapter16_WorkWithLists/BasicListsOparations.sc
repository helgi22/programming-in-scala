object run {

  val empty = List[Nothing]()
  //the same
  val empty1: List[Nothing] = Nil
  empty.isEmpty
  empty1.isEmpty

  val fruit: List[String] = "apples" :: "oranges" :: "pear" :: "cherry" :: Nil
  //val fruit = "apples"::("oranges"::("pear"::(Nil)))

  fruit.isEmpty
  //  fruit.isEmpty faster then fruit.length==0
  fruit.length

  fruit.head
  fruit.last

  fruit.tail
  fruit.init

  fruit.reverse

  fruit.drop(2)
  fruit.take(2)
  fruit.splitAt(2)

  fruit.apply(2)
  fruit(2)

  fruit.indices

  List(1, 2, 3) :: List(3, 4, 5) :: List(6, 7, 8) :: Nil.flatten

  val zipped = List(1, 3, 5).zip(List(2, 4, 6))
  val (fl, sl) = zipped.unzip
  Console.println(s"first list $fl and second list $sl")

  fruit.zipWithIndex

  val str: String = zipped.toString
  val strother = zipped.mkString(start = "list {", sep = "::", end = "::Nil}")
  val strother1 = zipped.mkString(sep = "::")

  fruit.addString(new StringBuilder, "< ", " : ", " >")

  List(1, 2, 3).toArray
  Array(1, 2, 3).toList

  val arr = Array[Int](10)

  List(1, 2, 3).copyToArray(arr)
  println(arr.toString)

  val it = fruit.iterator
  it.hasNext
  it.next()


  //decompose list or pattern matching
  //  val List(a, b, c, d): List[String] = fruit
  val a :: b :: c :: d :: e = fruit
  print(s"a = $a\nb = $b\nc = $c\nd=$d\n")

  val aa :: bb :: List(cc, dd) = fruit
  print(s"$aa, $bb, $cc ")

  val x :: xs = fruit


  def isort(list: List[Int]): List[Int] = list match {
    case Nil => {
      println("isort(Nil)")
      Nil
    }
    //    case x :: xs => insert(x,isort(xs))
    case x :: xs => {
      println(s"isort($xs) and x = $x ")
      insert(x, isort(xs))
    }
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => {
      println(s"inser($x)")
      List(x)
    }
    case y :: ys => if (x <= y) {
      println(s"insert($x <= $y)  return $x :: $xs")
      x :: xs
    }
    else {
      println(s"insert($x > $y)  $y :: rec insert($x, $ys)")
      y :: insert(x, ys)
    }
  }

  val lsort = isort _
  lsort(List(1, 4, 2, 6, 3, 8))
}

