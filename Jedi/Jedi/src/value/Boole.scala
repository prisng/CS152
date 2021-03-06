package value
import expression._

case class Boole(val value: Boolean) extends Literal {
  // Operators
  def &&(other: Boole) = if (this.value && other.value) Boole(true) else Boole(false)
  def ||(other: Boole) = if (this.value || other.value) Boole(true) else Boole(false)
  // Unary negation operator
  def unary_! = if (this.value) Boole(false) else Boole(true)
  
  override def toString = value.toString
  
  // Note: a == b calls a.equals(b)
  override def equals(other: Any): Boolean = 
    other match {
       case other: Boole => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
}