package time2

class Time (private var h: Int, private var m: Int = 0) {
   /**
   * "Max" time in a day is 23:59 (military time); can't have negative time
   */
  if (h < 0 || h > 23 || m > 59) throw new IllegalArgumentException
  
  /**
   * Accessor for h (hour)
   */
  def hours = h
  
  /**
   * Mutator for h (hour)
   */
  def hours_= (hour: Int) = {
    if (h < 0 || h > 23) throw new IllegalArgumentException
    else this.h = hour
  }
  
  /**
   * Accessor for m (minute)
   */
  def minutes = m
  
  /**
   * Mutator for m (minute)
   */
  def minutes_= (minute: Int) = {
    if (minute < 0 || minute > 59) throw new IllegalArgumentException
    else this.m = minute
  }
  
  /**
   * Prints the time in hh:mm format
   */
  override def toString = {
    if (m < 10) h.toString + ":0" + m.toString
    else h.toString + ":" + m.toString
  }
  
  /** 
   *  Check if this time is less than that time.
   */
  def before(t: Time): Boolean = {
    t match {
      case h if (this.h < t.h) => true
      case hm if (this.h == t.h) => if (this.m < t.m) true else false
      case _ => false
    }
    
  }
}

  /**
   * Companion Object
   */
  object Time {
    def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
  }