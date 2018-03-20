object combinator {
  
  def pipe[T, S](f: T => S, g: T => S): T => S = {
		// defining r because it's the function you're returning
		def r(t: T): S = {
			try {
				f(t)
			}
			catch {
				case e: Exception => g(t)
			}
		}
		r _
  }                                               //> pipe: [T, S](f: T => S, g: T => S)T => S
  
  // pipe takes in 2 anonymous functions
  val toInteger = pipe((s: String) => s.toInt, (s: String) => 0)
                                                  //> toInteger  : String => Int = combinator$$$Lambda$10/873415566@6fadae5d
  // should return 0
  toInteger("234s5")                              //> res0: Int = 0
  toInteger("12345")                              //> res1: Int = 12345
}