object combinators {

  /********** #1 **********/
  // Generic compose combinator
  // (the input of f should be the same as the output of g)
	def compose[A, B](f: A => B, g: B => A): B => B = {
		def r(x: B):
			B = f(g(x))
   	r _
	}                                         //> compose: [A, B](f: A => B, g: B => A)B => B
	
	// --- Tester functions --- //
	def triple(x: Int): Int = 3 * x           //> triple: (x: Int)Int
	def square(x: Int) = x * x                //> square: (x: Int)Int
	val squareTriple = compose(square _, triple _)
                                                  //> squareTriple  : Int => Int = combinators$$$Lambda$10/398887205@506e6d5e
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
  		else	 compose(f, selfIter(f, n - 1))
  }                                               //> selfIter: [T](f: T => T, n: Int)T => T
  
  // --- Tester functions --- //
  def inc(x: Double) = x + 1                      //> inc: (x: Double)Double
	def double(x: Double) = 2 * x             //> double: (x: Double)Double
	
	// Testing the selfIter function
	val selfDouble = selfIter(double _, 3)    //> selfDouble  : Double => Double = combinators$$$Lambda$10/398887205@35f983a6
	// double(double(double(5))) = double(double(10)) = double(20) = 40
	selfDouble(5)                             //> res4: Double = 40.0
	val selfInc = selfIter(inc _, 2)          //> selfInc  : Double => Double = combinators$$$Lambda$10/398887205@edf4efb
	// inc(inc(5)) = inc(6) = 7
	selfInc(5)                                //> res5: Double = 7.0
	val doubleIncSelfIter = selfIter(compose(double _, inc _), 3)
                                                  //> doubleIncSelfIter  : Double => Double = combinators$$$Lambda$10/398887205@6
                                                  //| 108b2d7
	// double(inc(double(inc(double(inc(4))))))
	// = double(inc(double(inc(double(5)))))
	// = double(inc(double(inc(10))))
	// = double(inc(double(11)))
	// = double(inc(22))
	// = double(23) = 46
	doubleIncSelfIter(4)                      //> res6: Double = 46.0


  /********** #3 **********/
  
  def countPass[T](values: Array[T], test: T => Boolean): Int = {
		def counter(result: Int, count: Int): Int =
  			if (count >= values.length) result
  			else if (test(values(count))) counter(result + 1, count + 1)
  			else counter(result, count + 1)
		counter(0,0)
		/* Iterative solution:
  		var count = 0
		for(value <- values if (test(value) == true)) count = count + 1
		count
		*/
  }                                               //> countPass: [T](values: Array[T], test: T => Boolean)Int
  
  // --- Tester functions --- //
  def odd(n: Int) = n % 2 != 0                    //> odd: (n: Int)Boolean
  def pal(n: String) = n == n.reverse             //> pal: (n: String)Boolean
  
  countPass(Array(1, 2, 3, 4, 5), odd _)          //> res7: Int = 3
  countPass(Array(2, 5, 13, 17, 19, 20), odd _)   //> res8: Int = 4

  countPass(Array("mom", "dad", "dog"), pal _)    //> res9: Int = 2
  countPass(Array("racecar", "civic", "anna", "madam"), pal _)
                                                  //> res10: Int = 4
  
  /********** #4 **********/
  
  def recur(baseVal: Int, combiner: (Int, Int) => Int): Int => Int = {
 		def f(n: Int): Int = {
			if (n == 0) baseVal
			else combiner(n, f(n - 1))
 		}
 		f _
  }                                               //> recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int
  
  
 	// --- Tester functions --- //
	val factorial = recur(1, _ * _)           //> factorial  : Int => Int = combinators$$$Lambda$21/998351292@783e6358
	val tri = recur(0, (n: Int, m: Int) => n + m)
                                                  //> tri  : Int => Int = combinators$$$Lambda$21/998351292@735f7ae5
	
	factorial(5)                              //> res11: Int = 120
	factorial(4)                              //> res12: Int = 24
	factorial(3)                              //> res13: Int = 6
	
	tri(5)                                    //> res14: Int = 15
 	tri(4)                                    //> res15: Int = 10
 	tri(3)                                    //> res16: Int = 6


  /********** #5 **********/
  
	def deOptionize[S, T](f: T => Option[S]): T => S = {
		def g(x: T): S = {
			f(x) match {
				case None => throw new Exception("This is not a string of digits.")
				case Some(result) => result
			}
		}
		g _
	}                                         //> deOptionize: [S, T](f: T => Option[S])T => S
	
  	// --- Tester function --- //
	def parseDigits(digits: String): Option[Int] =
		if (digits.matches("[0-9]*")) Some(digits.toInt) else None
                                                  //> parseDigits: (digits: String)Option[Int]
	
	val f = deOptionize(parseDigits _)        //> f  : String => Int = combinators$$$Lambda$24/321142942@2c6a3f77
	try {
		println(f("809123"))
		println(f("0101010101"))
		println(f("blah123blah"))
		println(f("these are not digits"))
	} catch {
    case e: Exception => println(e)
 	}                                         //> 809123
                                                  //| 101010101
                                                  //| java.lang.Exception: This is not a string of digits.
}