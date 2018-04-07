package value
import expression._

/**
 * A notification encapsulates a predefined message such as "DONE," "OK," and "UNSPECIFIED."
 */
class Notification(val message: String) extends Value {
  override def toString = message
}

/**
 * Companion object for Notification
 */
object Notification {
  def apply(message: String) = new Notification(message)
  
  val ok = new Notification("OK")
  val done = new Notification("DONE")
  val unspecified = new Notification("UNSPECIFIED")
}