package value
import context._
import expression._

case class Real(val value: Double) extends Literal with Ordered[Real] with Equals {

  // Operators
  def +(other: Real) = Real(this.value + other.value)
  def -(other: Real) = Real(this.value - other.value)
  def *(other: Real) = Real(this.value * other.value)
  def /(other: Real) = {
    if (other.value == 0.0) throw new JediException("Divide by 0 error")
    else Real(this.value / other.value)
  }
  
  // Unary negation operator
  def unary_- : Real = Real(-this.value)
  
  // Note: a < b and a > b calls a.compare(b)
  def compare(other: Real): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  
  override def toString = value.toString
  
  override def canEqual(other: Any) =  other.isInstanceOf[Real]
  
  // Note: a == b calls a.equals(b)
  override def equals(other: Any): Boolean = 
    other match {
       case other: Real => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
}