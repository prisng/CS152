package value
import expression._

case class Chars(val value: String) extends Literal with Ordered[Chars] with Equals {
  // Operators
  def +(other: Chars): Chars = {
    println(Notification.OK)
    Chars(this.value + other.value)
  }
  def ==(other: Chars) = if (this.equals(other)) Boole(true) else Boole(false)
  def substring(n: Integer, m: Integer) = Chars(this.value.substring(n.value, m.value))
  
  override def toString = value.toString
  
  // Note: a < b and a > b calls a.compare(b)
  def compare(other: Chars): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  
  // Note: a == b calls a.equals(b)
  override def equals(other: Any): Boolean = 
    other match {
       case other: Chars => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
  
}