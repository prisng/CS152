package time1

/**
 * Time Lab 1
 * A class that represents time in military-time format.
 */
class Time (val hour: Int, val minute: Int = 0) {
  
  /**
   * "Max" time in a day is 23:59 (military time); can't have negative time
   */
  if (hour < 0 || hour > 23 || minute > 59) throw new IllegalArgumentException
  
  /**
   * Prints the time in hh:mm format
   */
  override def toString = {
    if (minute < 10) hour.toString + ":0" + minute.toString
    else hour.toString + ":" + minute.toString
  }
  
  /** 
   *  Check if this time is less than that time.
   */
  def before(t: Time): Boolean = {
    t match {
      case hour if (this.hour < t.hour) => true
      case hourMin if (this.hour == t.hour) => if (this.minute < t.minute) true else false
      case _ => false
    }
  }
  
  /**
   * Computes minutes since midnight (00:00 is midnight)
   * Example: 03:45 --> 180 + 45 minutes = 225 minutes since midnight
   */
  def minutesSinceMidNight(): Int = {
    this.hour * 60 + this.minute
  }
}  // end of class Time

  /**
   * Companion Object
   */
  object Time {
    def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
  }