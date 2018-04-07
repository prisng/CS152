package value
import context._
import expression._

case class Real(val value: Double) extends Literal with Ordered[Double] with Equals {

  // Operators
  def +(other: Real) = Real(this.value + other.value)
  def -(other: Real) = Real(this.value - other.value)
  def *(other: Real) = Real(this.value * other.value)
  def /(other: Real) = {
    if (other.value == 0.0) throw new JediException("Divide by 0 error")
    else Real(this.value / other.value)
  }
  def <(other: Real) = {
    val digit = this.value.compare(other.value)
    digit match {
      case -1 => true
      case 1 => false
      case _ => false
    }
  }
  def >(other: Real) = {
    val digit = this.value.compare(other.value)
    digit match {
      case -1 => false
      case 1 => true
      case _ => false
    }
  }  
  // Unary negation operator
  def unary_- : Real = Real(-this.value)
  
  def compare(other: Double): Int = if (this.value < other) -1 else if (other < this.value) 1 else 0
  
  override def toString = value.toString
  
  override def canEqual(other: Any) =  other.isInstanceOf[Integer]
  
  override def equals(other: Any): Boolean = 
    other match {
       case other: Integer => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
}