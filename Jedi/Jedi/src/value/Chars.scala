package value
import expression._

case class Chars(val value: String) extends Literal with Equals {
  override def toString = value.toString
  def <(other: Chars) = if (this.value < other.value) Boole(true) else Boole(false)
  def >(other: Chars) = if (this.value > other.value) Boole(true) else Boole(false)
  def +(other: Chars): Chars = {
    println(Notification.ok)
    Chars(this.value + other.value)
    //this.value.toString + other.value.toString
  }
  def ==(other: Chars) = if (this.equals(other)) Boole(true) else Boole(false)
  def substring(n: Integer, m: Integer) = Chars(this.value.substring(n.value, m.value))
  
  override def equals(other: Any): Boolean = 
    other match {
       case other: Chars => this.canEqual(other) && (other.value == this.value)
       case _ => false
    }
  
  override def hashCode = this.toString.##
  
}