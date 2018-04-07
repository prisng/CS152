package value
import context._
import expression._

case class Integer(val value: Int) extends Literal with Ordered[Integer] with Equals {
  // Operators
  def +(other: Integer) = Integer(this.value + other.value)
  def -(other: Integer) = Integer(this.value - other.value)
  def *(other: Integer) = Integer(this.value * other.value)
  def /(other: Integer) = {
    if (other.value == 0) throw new JediException("Divide by 0 error")
    else Integer(this.value / other.value)
  }
  // Unary negation operator
  def unary_- = Integer(-this.value)
  
  def compare(other: Integer): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  
  override def toString = value.toString
  
  override def canEqual(other: Any) =  other.isInstanceOf[Integer]
  
  override def equals(other: Any): Boolean = 
    other match {
       case other: Integer => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
  
}

/**
 * Companion object for Integer
 */
object Integer {
  implicit def intToReal(n: Integer): Real = Real(n.value.toDouble)
}