object dds {

  /********** #1 **********/
  
  // Tail-recursive implementation of controlLoop
	def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S =
		if (halt(state, cycle)) state
		else controlLoop(update(state, cycle), cycle + 1, halt, update)
                                                  //> controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S
                                                  //| , Int) => S)S
		
  /********** #2 **********/
  
  // Initial pop = 1, doubles every week, stops after pop > 10^5, final pop = ?
	def amoebaPop(): Int = {
		val birthRate = 2
		def updatePop(currentPop: Int, numWeeks: Int) = currentPop * birthRate
		def halt(currentPop: Int, numWeeks: Int) = (currentPop > scala.math.pow(10, 5))
		controlLoop(1, 0, halt, updatePop)
	}                                         //> amoebaPop: ()Int
	val finalPop = amoebaPop()                //> finalPop  : Int = 131072
	
	// The final population size is 131072.
	
	
  /********** #3 **********/
  
  	def solve(f: Double => Double): Double = {
  		// Note: the smaller the delta, the longer it takes to run
		val delta = 0.00001

		// Derivative equation: except you get rid of the limit part (just an approximation)
		def df(x: Double) = (f(x + delta) - f(x)) / delta
		
		def improveApprox(guess: Double, numGuesses: Int) =
			guess - (f(guess) / df(guess))
			
		def halt(guess: Double, numGuesses: Int) =
			math.abs(f(guess)) <= delta
			
		controlLoop(1.0, 0, halt, improveApprox)
	}                                         //> solve: (f: Double => Double)Double
  
  // --- Tester functions --- //
  // x^2 - x - 6 = 0 => x = 3, x = -2
  def f(x: Double) = x * x - x - 6                //> f: (x: Double)Double
  // x^2 + 3x - 4 = 0 => x = 1, x = -4
  def g(x: Double) = x * x	+ 3 * x - 4       //> g: (x: Double)Double
  
  solve(f)                                        //> res0: Double = 3.00000000005014
  solve(g)                                        //> res1: Double = 1.0
  
  
  /********** #4 **********/
  
  def squareRoot(x: Double) = {
  		def f(y: Double) = y * y - x
  		solve(f)
  	}                                         //> squareRoot: (x: Double)Double
  
  squareRoot(9)                                   //> res2: Double = 3.0000000015508212
  squareRoot(16)                                  //> res3: Double = 4.000000639575587
  squareRoot(25)                                  //> res4: Double = 5.0000000000769855
  
  
  /********** #5 **********/
  
  def cubeRoot(x: Double) = {
  		def f(y: Double) = y * y * y - x
  		solve(f)
  }                                               //> cubeRoot: (x: Double)Double
  
  cubeRoot(27)                                    //> res5: Double = 3.0000000000019176
  cubeRoot(64)                                    //> res6: Double = 4.000000000119973
  cubeRoot(125)                                   //> res7: Double = 5.000000000364238
  
  
  /********** #6 **********/
  
  def nthRoot(x: Double, n: Int) = {
  		def f(y: Double) = math.pow(y, n) - x
  		solve(f)
  }                                               //> nthRoot: (x: Double, n: Int)Double
  
  nthRoot(9, 2)                                   //> res8: Double = 3.0000000015508212
  nthRoot(27, 3)                                  //> res9: Double = 3.000000000001917
  nthRoot(4, 2)                                   //> res10: Double = 2.0000000944796694
  nthRoot(16, 2)                                  //> res11: Double = 4.000000639575587
  
}