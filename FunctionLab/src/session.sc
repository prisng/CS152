object session {

  /********** #1 **********/
  // Generic compose combinator
  // (the input of f should be the same as the output of g)
	def compose[A, B](f: A => B, g: B => A): B => B = {
		def r(x: B):
			B = f(g(x));
   	r _
	}                                         //> compose: [A, B](f: A => B, g: B => A)B => B
	
	// --- Tester functions --- //
	def triple(x: Int): Int = 3 * x           //> triple: (x: Int)Int
	def square(x: Int) = x * x                //> square: (x: Int)Int
	val squareTriple = compose(square _, triple _)
                                                  //> squareTriple  : Int => Int = session$$$Lambda$10/434091818@2acf57e3
	// Test without composition function
	square(triple(2))                         //> res0: Int = 36
	square(triple(5))                         //> res1: Int = 225
	
	// Testing the composition function
	squareTriple(2)                           //> res2: Int = 36
	squareTriple(5)                           //> res3: Int = 225
	
  
  /********** #2 **********/
  
  
  /********** #3 **********/
  
  
  /********** #4 **********/
  
  
  /********** #5 **********/
  
  
}