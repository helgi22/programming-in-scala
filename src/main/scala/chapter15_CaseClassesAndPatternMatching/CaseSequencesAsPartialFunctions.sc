/** Case sequences as partial functions */
val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}
withDefault(Some(10))
withDefault(None)

/** One other generalization is worth noting: a sequence of cases gives you a partial function.
  * If you apply such a function on a value it does not support, it will generate a run-time exception */
//val second: List[Int] => Int = {
//  case x :: y :: _ => y
//}
//warning: match is not exhaustive!
//missing combination Nil

//This function will succeed if you pass it a three-element list, but not if you pass it an empty list:
//  scala> second(List(5, 6, 7))
//res24: Int = 6
//scala> second(List())
//scala.MatchError: List()
//at $anonfun$1.apply(<console>:17)
//  at $anonfun$1.apply(<console>:17)

/** If you want to check whether a partial function is defined, you must first tell the compiler
  * that you know you are working with partial functions. */
val second: PartialFunction[List[Int], Int] = {
  case x :: y :: _ => y
}

/** Partial functions have a method isDefinedAt, which can be used to test whether the function
  * is defined at a particular value. In this case, the function is defined for any list that
  * has at least two elements: */
second.isDefinedAt(List(5, 6, 7))
second.isDefinedAt(List())


/**
  * the function literal { case x :: y :: _ => y } gets translated to the following partial function
  * value:
  */
new PartialFunction[List[Int], Int] {
  def apply(xs: List[Int]) = xs match {
    case x :: y :: _ => y
  }

  def isDefinedAt(xs: List[Int]) = xs match {
    case x :: y :: _ => true
    case _ => false
  }
}

/** In general, you should try to work with complete functions whenever possible, because using partial
  * functions allows for runtime errors that the compiler cannot help you with. Sometimes partial functions
  * are really helpful though. You might be sure that an unhandled value will never be supplied.
  * Alternatively, you might be using a framework that expects partial functions and so will always
  * check isDefinedAt before calling the function. An example of the latter is the react example given
  * above, where the argument is a partially defined function, defined precisely for those messages that the
  * caller wants to handle. */