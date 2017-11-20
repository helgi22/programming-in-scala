class Point(val x: Int, val y: Int)

class Rectangle(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left

  // and many more geometric methods...
}

abstract class Component {
  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left

  // and many more geometric methods...
}

//Notice that the definitions of left, right, and width are exactly the same in the two classes above.

//This repetition can be eliminated with an enrichment trait. The trait will have two abstract methods:
//one that returns the top-left coordinate of the object, and another that returns the bottom-right
//coordinate. It can then supply concrete implementations of all the other geometric queries.
// Listing shows what it will look like:
trait Rectangular1 {
  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left

  // and many more geometric methods...
}

//Class Component can mix in this trait to get all the geometric methods provided by Rectangular:
abstract class Component1 extends Rectangular1 {
  //  other methods
  //  ...
}

//Similarly, Rectangle itself can mix in the trait:
class Rectangle1(val topLeft: Point, val bottomRight: Point)
  extends Rectangular1 {
  // other methods...
}


val rect = new Rectangle1(new Point(1, 1), new Point(10, 10))
rect.left
rect.right
rect.width
