package com.github.nnnnusui.cui
package ansi

sealed trait Cursor extends AnsiEscapeCode
object Cursor{
  sealed trait UsesScalar extends Cursor {
    protected val scalar: Int
    override def toAnsi = toAnsi(scalar.toString)
  }
  case class Up     (scalar: Int) extends UsesScalar{ val suffix = "A" }
  case class Down   (scalar: Int) extends UsesScalar{ val suffix = "B" }
  case class Forward(scalar: Int) extends UsesScalar{ val suffix = "C" }
  case class Back   (scalar: Int) extends UsesScalar{ val suffix = "D" }
  case class NextLine(scalar: Int) extends UsesScalar{ val suffix = "E" }
  case class PreviousLine(scalar: Int) extends UsesScalar{ val suffix = "F" }
  case class HorizontalAbsolute(scalar: Int) extends UsesScalar{ val suffix = "G" }
  case class Position(x: Int, y: Int) extends Cursor{
    protected val suffix = "H"
    override def toAnsi: String = toAnsi(s"$x;$y")
  }
}
