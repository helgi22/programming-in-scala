//definitions of trait
//It default extends AnyRef
trait HasLegs

class Animal

trait Philosophical {
  def pilisifize(): Unit = {
    Console.println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString: String = "green"
}

val frog: Philosophical = new Frog()

frog.pilisifize()

class Tadpole extends Frog with Philosophical with HasLegs {
  override def toString: String = "green"
  override def pilisifize(): Unit = {
    Console.println("It ain't easy being " + toString + "!")
  }
}

