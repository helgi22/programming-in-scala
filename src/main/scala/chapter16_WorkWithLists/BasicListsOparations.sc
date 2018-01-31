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
  fruit.tail
  fruit.reverse


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

