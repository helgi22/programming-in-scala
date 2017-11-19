
object Ex12 {

  import Ex12.Element.LineElement

  abstract class Element {

    import Element.elem

    def contents: Array[String]

    def width: Int =
      if (height == 0) 0 else contents(0).length

    def height: Int = contents.length

    def above(that: Element): Element =
      elem(this.contents ++ that.contents)

    def beside(that: Element): Element =
      elem(
        for (
          (line1, line2) <- this.contents zip that.contents
        ) yield line1 + line2
      )

    override def toString = contents mkString "\n"
  }

  object Element {

    def elem(contents: Array[String]): Element =
      new ArrayElement(contents)

    def elem(chr: Char, width: Int, height: Int): Element =
      new UniformElement(chr, width, height)

    def elem(line: String): Element =
      new LineElement(line)


    class ArrayElement(conts: Array[String]) extends Element {
      def contents: Array[String] = conts
    }

    class LineElement(s: String) extends ArrayElement(Array(s)) {
      override def width = s.length

      override def height = 1
    }

    class UniformElement(
                          ch: Char,
                          override val width: Int,
                          override val height: Int
                        ) extends Element {
      private val line = ch.toString * width

      def contents = Array.fill(height)(line)
    }

  }

  def main(args: Array[String]) {
    val lineElem = new LineElement("foo")
    println("lineElem [" + lineElem + "]")
  }
}


/************************************************/
import Ex12.Element
import Ex12.Element.elem

object Spiral {

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]) = {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}

Spiral.main(Array("11"))