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
                                                  //> squareTriple  : Int => Int = session$$$Lambda$10/2114889273@96532d6
	// Test without composition function
	square(triple(2))                         //> res0: Int = 36
	square(triple(5))                         //> res1: Int = 225
	
	// Testing the composition function
	squareTriple(2)                           //> res2: Int = 36
	squareTriple(5)                           //> res3: Int = 225
	
  
  /********** #2 **********/
  // f is composed with itself n times
  def selfIter[T](f: T=>T, n: Int): T => T = {
  		def id[T](x: T) = x
  		if (n == 0) id
  		else	 {
  			def test = selfIter(f, n - 1)
  			compose(f, test)
  		}
  }                                               //> selfIter: [T](f: T => T, n: Int)T => T
  
  // --- Tester functions --- //
  def inc(x: Double) = x + 1                      //> inc: (x: Double)Double
	def double(x: Double) = 2 * x             //> double: (x: Double)Double
	
	// Testing the selfIter function
	val selfDouble = selfIter(double _, 3)    //> selfDouble  : Double => Double = session$$$Lambda$10/2114889273@7f690630
	// double(double(double(5))) = double(double(10)) = double(20) = 40
	selfDouble(5)                             //> res4: Double = 40.0
	val selfInc = selfIter(inc _, 2)          //> selfInc  : Double => Double = session$$$Lambda$10/2114889273@2f7a2457
	// inc(inc(5)) = inc(6) = 7
	selfInc(5)                                //> res5: Double = 7.0
	val doubleIncSelfIter = selfIter(compose(double _, inc _), 3)
                                                  //> doubleIncSelfIter  : Double => Double = session$$$Lambda$10/2114889273@1554
                                                  //| 909b
	// double(inc(double(inc(double(inc(4))))))
	// = double(inc(double(inc(double(5)))))
	// = double(inc(double(inc(10))))
	// = double(inc(double(11)))
	// = double(inc(22))
	// = double(23) = 46
	doubleIncSelfIter(4)                      //> res6: Double = 46.0

  /********** #3 **********/
  // how do i do this without iteration and with recursion instead
  def countPass[T](values: Array[T], test: T => Boolean): Int = {
  /*
  		var count = 0
		for(value <- values if (test(value) == true)) count = count + 1
		count
		*/
		1
  }                                               //> countPass: [T](values: Array[T], test: T => Boolean)Int
  
  // --- Tester functions --- //
  def odd(n: Int) = n % 2 != 0                    //> odd: (n: Int)Boolean
  def pal(n: String) = n == n.reverse             //> pal: (n: String)Boolean
  
  countPass(Array(1, 2, 3, 4, 5), odd _)          //> res7: Int = 1
  countPass(Array(2, 5, 13, 17, 19, 20), odd _)   //> res8: Int = 1

  countPass(Array("mom", "dad", "dog"), pal _)    //> res9: Int = 1
  countPass(Array("racecar", "civic", "anna", "madam"), pal _)
                                                  //> res10: Int = 1
  
  /********** #4 **********/
  // this is also the iterative solution, not recursive
  
  def recur(baseVal: Int, combiner: (Int, Int) => Int): Int => Int = {
  		/*
		def f(n: Int): Int = {
 			var result = baseVal
 			for (count <- 1 to n)
 				result = combiner(count, result)
 			result
 		}
 		f _
 		*/
 		def f(n: Int): Int = {
			//if (baseVal == 0) 0
 			//else f(combiner(n, n - 1))
 			1
 		}
 		f _
  }                                               //> recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int
  
  
 	// --- Tester functions --- //
	val factorial = recur(1, _ * _)           //> factorial  : Int => Int = session$$$Lambda$21/1020923989@7a5d012c
	val tri = recur(0, (n: Int, m: Int) => n + m)
                                                  //> tri  : Int => Int = session$$$Lambda$21/1020923989@7a5d012c
	
	factorial(5)                              //> res11: Int = 1
	factorial(4)                              //> res12: Int = 1
	factorial(3)                              //> res13: Int = 1
	
	tri(5)                                    //> res14: Int = 1
 	tri(4)                                    //> res15: Int = 1
 	tri(3)                                    //> res16: Int = 1
  
  /********** #5 **********/
  
  def deOptionize[S, T](f: S => Option[T]): S => T = { null }
                                                  //> deOptionize: [S, T](f: S => Option[T])S => T
  
}