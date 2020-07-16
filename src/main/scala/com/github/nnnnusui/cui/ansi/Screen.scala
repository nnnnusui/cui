package com.github.nnnnusui.cui
package ansi

sealed trait Screen extends AnsiEscapeCode
object Screen{
  sealed trait Erase extends Screen{
    protected val code: Int
    override def toAnsi = toAnsi(code.toString)
  }
  object Erase{
    sealed trait InDisplay extends Erase{
      override val suffix: String = "J"
    }
    object InDisplay{
      case object Forward extends InDisplay{ val code = 0 }
      case object Back    extends InDisplay{ val code = 1 }
      case object All     extends InDisplay{ val code = 2 } // cursor move to top left.
      case object AllLine extends InDisplay{ val code = 3 }
    }
    sealed trait InLine extends Erase{
      override val suffix: String = "K"
    }
    object InLine{
      case object Forward extends InDisplay{ val code = 0 }
      case object Back    extends InDisplay{ val code = 1 }
      case object All     extends InDisplay{ val code = 2 } // cursor does not move.
    }
  }
  sealed trait Scroll extends Screen{
    protected val scalar: Int
    override def toAnsi: String = toAnsi(scalar.toString)
  }
  object Scroll{
    case class Up  (scalar: Int) extends Scroll{ val suffix = "S" }
    case class Down(scalar: Int) extends Scroll{ val suffix = "T" }
  }
}
