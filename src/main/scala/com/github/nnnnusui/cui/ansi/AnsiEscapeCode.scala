package com.github.nnnnusui.cui
package ansi

trait AnsiEscapeCode{
  def toAnsi: String
  protected val suffix: String
  protected def toAnsi(code: String) = s"\u001b[$code$suffix"
}
