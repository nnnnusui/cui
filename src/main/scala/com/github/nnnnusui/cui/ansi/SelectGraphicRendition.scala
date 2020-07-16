package com.github.nnnnusui.cui
package ansi

object SelectGraphicRendition{
  sealed trait SGREffect extends AnsiEscapeCode{
    protected val code: Int
    override val suffix = "m"
    override def toAnsi: String = toAnsi(code.toString)
  }
  case object Reset        extends SGREffect { val code = 0 }
  case object Bold         extends SGREffect { val code = 1 }
  case object Faint        extends SGREffect { val code = 2 }
  case object Italic       extends SGREffect { val code = 3 }
  case object Underline    extends SGREffect { val code = 4 }
  case object SlowBlink    extends SGREffect { val code = 5 }
  case object RapidBlink   extends SGREffect { val code = 6 }
  case object ReverseVideo extends SGREffect { val code = 7 }
  case object Conceal      extends SGREffect { val code = 8 }
  case object CrossedOut   extends SGREffect { val code = 9 }
  sealed trait Font extends SGREffect
  object Font {
    case object Primary extends Font { val code = 10 }
    case object F1 extends Font { val code = 11 }
    case object F2 extends Font { val code = 12 }
    case object F3 extends Font { val code = 13 }
    case object F4 extends Font { val code = 14 }
    case object F5 extends Font { val code = 15 }
    case object F6 extends Font { val code = 16 }
    case object F7 extends Font { val code = 17 }
    case object F8 extends Font { val code = 18 }
    case object F9 extends Font { val code = 19 }
  }
  sealed trait FontColor extends SGREffect
  object FontColor{
    case object Black   extends FontColor { val code = 30 }
    case object Red     extends FontColor { val code = 31 }
    case object Green   extends FontColor { val code = 32 }
    case object Yellow  extends FontColor { val code = 33 }
    case object Blue    extends FontColor { val code = 34 }
    case object Magenta extends FontColor { val code = 35 }
    case object Cyan    extends FontColor { val code = 36 }
    case object White   extends FontColor { val code = 37 }
    case object Default extends FontColor { val code = 39 }
  }
  sealed trait BackgroundColor extends SGREffect
  object BackgroundColor{
    case object Black   extends FontColor { val code = 40 }
    case object Red     extends FontColor { val code = 41 }
    case object Green   extends FontColor { val code = 42 }
    case object Yellow  extends FontColor { val code = 43 }
    case object Blue    extends FontColor { val code = 44 }
    case object Magenta extends FontColor { val code = 45 }
    case object Cyan    extends FontColor { val code = 46 }
    case object White   extends FontColor { val code = 47 }
    case object Default extends FontColor { val code = 49 }
  }
}
