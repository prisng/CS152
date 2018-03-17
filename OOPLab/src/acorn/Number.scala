package acorn

class Number(val num: Double) extends Expression {
  def execute = num
  override def toString = num.toString()
}

/**
 * Companion object for Number
 */
object Number {
  def apply(num: Double) = new Number(num)
}