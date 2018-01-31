package chapter16_WorkWithLists

import org.scalameter._

import scala.annotation.tailrec

trait meg {
  def standardConfig = config(
    Key.exec.minWarmupRuns -> 5,
    Key.exec.maxWarmupRuns -> 10,
    Key.exec.benchRuns -> 10,
    Key.verbose -> true
  ) withWarmer new Warmer.Default
}

object AppendLists extends App with meg {
  val lf = List range(0, 10)
  val ls = List range(11, 20)

  val rez = standardConfig measure {
    //    append(lf, ls)
  }

  val cores = Runtime.getRuntime.availableProcessors()
  println(s"this machine have $cores cores")
  println(s"append result is $rez")


  def append[T](first: List[T], second: List[T]): List[T] = first match {
    case Nil =>
      second
    case x :: xs => x :: append(xs, second)
  }

  var r: List[AnyVal] = _
  val rez2 = standardConfig measure {
    r = append1(lf, ls)
  }
  println(s"appendtailrec result is $rez2 \n $r")

  def append1[T](first: List[T], second: List[T]): List[T] = first match {
    case Nil => second
    case x :: xs =>
      @tailrec
      def appendtailrec(accum: List[T], fst: List[T]): List[T] = fst match {
        case Nil => accum.reverse
        case y :: ys => {
          appendtailrec(y :: accum, ys)
        }
      }

      appendtailrec(x :: Nil, xs) ++ second
  }
}

//0665559955

