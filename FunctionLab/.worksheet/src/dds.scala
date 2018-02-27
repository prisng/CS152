object dds {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(290); 

  /********** #1 **********/
  
  // Tail-recursive implementation of controlLoop
	def controlLoop[S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S): S =
		if (halt(state, cycle)) state
		else controlLoop(update(state, cycle), cycle + 1, halt, update);System.out.println("""controlLoop: [S](state: S, cycle: Int, halt: (S, Int) => Boolean, update: (S, Int) => S)S""");$skip(356); 
		
  /********** #2 **********/
  
  // Initial pop = 1, doubles every week, stops after pop > 10^5, final pop = ?
	def amoebaPop(): Int = {
		val birthRate = 2
		def updatePop(currentPop: Int, numWeeks: Int) = currentPop * birthRate
		def halt(currentPop: Int, numWeeks: Int) = (currentPop > scala.math.pow(10, 5))
		controlLoop(1, 0, halt, updatePop)
	};System.out.println("""amoebaPop: ()Int""");$skip(28); 
	val finalPop = amoebaPop();System.out.println("""finalPop  : Int = """ + $show(finalPop ));$skip(571); 
	
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
	};System.out.println("""solve: (f: Double => Double)Double""");$skip(109); 
  
  // --- Tester functions --- //
  // x^2 - x - 6 = 0 => x = 3, x = -2
  def f(x: Double) = x * x - x - 6;System.out.println("""f: (x: Double)Double""");$skip(78); 
  // x^2 + 3x - 4 = 0 => x = 1, x = -4
  def g(x: Double) = x * x	+ 3 * x - 4;System.out.println("""g: (x: Double)Double""");$skip(14); val res$0 = 
  
  solve(f);System.out.println("""res0: Double = """ + $show(res$0));$skip(11); val res$1 = 
  solve(g);System.out.println("""res1: Double = """ + $show(res$1));$skip(121); 
  
  
  /********** #4 **********/
  
  def squareRoot(x: Double) = {
  		def f(y: Double) = y * y - x
  		solve(f)
  	};System.out.println("""squareRoot: (x: Double)Double""");$skip(19); val res$2 = 
  
  squareRoot(9);System.out.println("""res2: Double = """ + $show(res$2));$skip(17); val res$3 = 
  squareRoot(16);System.out.println("""res3: Double = """ + $show(res$3));$skip(17); val res$4 = 
  squareRoot(25);System.out.println("""res4: Double = """ + $show(res$4));$skip(122); 
  
  
  /********** #5 **********/
  
  def cubeRoot(x: Double) = {
  		def f(y: Double) = y * y * y - x
  		solve(f)
  };System.out.println("""cubeRoot: (x: Double)Double""");$skip(18); val res$5 = 
  
  cubeRoot(27);System.out.println("""res5: Double = """ + $show(res$5));$skip(15); val res$6 = 
  cubeRoot(64);System.out.println("""res6: Double = """ + $show(res$6));$skip(16); val res$7 = 
  cubeRoot(125);System.out.println("""res7: Double = """ + $show(res$7));$skip(134); 
  
  
  /********** #6 **********/
  
  def nthRoot(x: Double, n: Int) = {
  		def f(y: Double) = math.pow(y, n) - x
  		solve(f)
  };System.out.println("""nthRoot: (x: Double, n: Int)Double""");$skip(19); val res$8 = 
  
  nthRoot(9, 2);System.out.println("""res8: Double = """ + $show(res$8));$skip(17); val res$9 = 
  nthRoot(27, 3);System.out.println("""res9: Double = """ + $show(res$9));$skip(16); val res$10 = 
  nthRoot(4, 2);System.out.println("""res10: Double = """ + $show(res$10));$skip(17); val res$11 = 
  nthRoot(16, 2);System.out.println("""res11: Double = """ + $show(res$11))}
  
}
