/** 12.5 TRAITS AS STACKABLE MODIFICATIONS
  * */
abstract class IntQueue {
  def get(): Int

  def put(x: Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  def get() = buf.remove(0)

  def put(x: Int) = {
    buf += x
  }
}


/** Since super calls in a trait are dynamically bound, the super call in
  * trait Doubling will work so long as the trait is mixed in after another
  * trait or class that gives a concrete definition to the method.
  */
trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = {
    super.put(2 * x)
  }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = {
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}

class MyQueue extends BasicIntQueue with Doubling


object RunTest {
  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue
    queue.put(10)
    queue.put(20)
    println(queue.get())
    println(queue.get())

    val queue1 = new MyQueue
    queue1.put(10)
    println(queue1.get())
    //or
    /** The order of mixins is significant.[2] The precise rules are given in the following section,
      * but, roughly speaking, traits further to the right take effect first. When you call
      * a method on a class with mixins, the method in the trait furthest to the right
      * is called first. If that method calls super, it invokes the method in the next trait
      * to its left, and so on. In the previous example, Filtering's put is invoked first,
      * so it removes integers that were negative to begin with. Incrementing's put is invoked
      * second, so it adds one to those integers that remain. */
    val queue2 = new BasicIntQueue with Doubling with Incrementing with Filtering
    queue2.put(-10);
    queue2.put(-1);
    queue2.put(0);
    queue2.put(1)

    println(queue2.get())
  }
}

RunTest.main(Array(""))