/** THE OPTION TYPE */
/** Scala has a standard type named Option for optional values. Such a value can be of two
  * forms:
  * Some(x), where x is the actual value, or the
  * None object, which represents a missing value. */
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals get "France"
//res0: Option[String] = Some(Paris)
capitals get "North Pole"
//res1: Option[String] = None

/** The most common way to take optional values apart is through a pattern match. For instance: */
def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "no element"
}

show(capitals get "Japan")
show(capitals get "France")
show(capitals get "North Pole")
