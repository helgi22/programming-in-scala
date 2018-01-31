package chapter16_WorkWithLists

object IsortMethod {

  def main(args: Array[String]): Unit = {
    val lsort = isort _
    lsort(List(1, 4, 2, 6, 3, 8))
  }

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
}
