object recursionSession {

  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int
	def dec(n: Int) = n - 1                   //> dec: (n: Int)Int
	def isZero(n: Int) = n == 0               //> isZero: (n: Int)Boolean
  
  /********** #1 **********/
  // Recursive
  def add(n: Int, m: Int): Int = {
  		if (isZero(m)) n
  		else add(inc(n), dec(m))
  }                                               //> add: (n: Int, m: Int)Int
  
  val t0 = System.nanoTime()                      //> t0  : Long = 4714298969936
  add(1, 2)                                       //> res0: Int = 3
  add(3, 5)                                       //> res1: Int = 8
  add(5, 5)                                       //> res2: Int = 10
 	add(100, 99)                              //> res3: Int = 199
  val t1 = System.nanoTime()                      //> t1  : Long = 4714304266227
  val recurDiff = t1 - t0                         //> recurDiff  : Long = 5296291
  println("Time elapsed: " + recurDiff + "ns")    //> Time elapsed: 5296291ns
  
  
  /********** #2 **********/
  // Recursive
  def mul(n: Int, m: Int): Int = {
    	var result = n
  		if (isZero(n) || isZero(m)) result = 0
  		if (m > 1) {
  			result = add(n, mul(n, dec(m))) // result = n * (m - 1) + n
  		}
  		result
  }                                               //> mul: (n: Int, m: Int)Int
  
  mul(0, 999)                                     //> res4: Int = 0
  mul(3, 5)                                       //> res5: Int = 15
  mul(5, 5)                                       //> res6: Int = 25
  mul(12, 12)                                     //> res7: Int = 144
  mul(30, 3)                                      //> res8: Int = 90
  
  
  /********** #3 **********/
  // Recursive
  def exp2(m: Int): Int = {
  		if (isZero(m)) 1
  		else mul(2, exp2(dec(m)))
  }                                               //> exp2: (m: Int)Int
  
  exp2(0)                                         //> res9: Int = 1
  exp2(1)                                         //> res10: Int = 2
  exp2(2)                                         //> res11: Int = 4
  exp2(3)                                         //> res12: Int = 8
  exp2(4)                                         //> res13: Int = 16
  exp2(5)                                         //> res14: Int = 32
  exp2(10)                                        //> res15: Int = 1024
 	// Stack overflow once m >= 15 is called


  /********** #4 **********/
  // Recursive
  def hyperExp(n: Int): Int = {
  		if (isZero(n)) 1
  		else exp2(hyperExp(dec(n)))
  }                                               //> hyperExp: (n: Int)Int
	
	hyperExp(0)                               //> res16: Int = 1
	hyperExp(1)                               //> res17: Int = 2
	hyperExp(2)                               //> res18: Int = 4
	hyperExp(3)                               //> res19: Int = 16
	// Stack overflow once n >= 4 is called


  /********** #5 **********/
	/** Tail-recursive implementations of #1-4 **/
	
	// Tail-recursive implementation of #1
  def addTR(n: Int, m: Int) = {
  		def addHelper(result: Int, count: Int): Int =
  		  	if (isZero(count)) result
  			else addHelper(inc(result), dec(count))
  		addHelper(n, m)
  }                                               //> addTR: (n: Int, m: Int)Int
  
  val t2 = System.nanoTime()                      //> t2  : Long = 4714309963704
  addTR(1, 2)                                     //> res20: Int = 3
  addTR(3, 5)                                     //> res21: Int = 8
  addTR(5, 5)                                     //> res22: Int = 10
 	addTR(100, 99)                            //> res23: Int = 199
  val t3 = System.nanoTime()                      //> t3  : Long = 4714310277353
  val trDiff = t3 - t2                            //> trDiff  : Long = 313649
  println("Time elapsed: " + (t3 - t2) + "ns")    //> Time elapsed: 313649ns
  
  // Testing computation time
  if (trDiff < recurDiff) println("Tail-recurisve is faster by " + (recurDiff - trDiff) + "ns")
                                                  //> Tail-recurisve is faster by 4982642ns
                                                  
	// When implementing #1-4 tail-recursively, the stack overflow problem is resolved and
	// the computation-time is improved as well.

	// Tail-recursive implementation of 2
	
	def mulTR(n: Int, m: Int) = {
		if (isZero(n) || isZero(m)) 0
		def mulHelper(count: Int, result: Int): Int = {
			if (count >= m) result else mulHelper(inc(count), add(result, n))
		}
		mulHelper(1, n)
	}                                         //> mulTR: (n: Int, m: Int)Int
	
	mulTR(3, 5)                               //> res24: Int = 15
	mulTR(4, 5)                               //> res25: Int = 20
	mulTR(10, 10)                             //> res26: Int = 100
	mulTR(0, 150)                             //> res27: Int = 0
	mulTR(12, 12)                             //> res28: Int = 144
  
  // Tail-recursive implementation of 3
	def exp2TR(m: Int) = {
 		def helper (count: Int, result: Int): Int =
 			if (m < count) result else helper(count + 1, 2 * result)
 		helper(1, 1)
  }                                               //> exp2TR: (m: Int)Int
  
  exp2TR(0)                                       //> res29: Int = 1
  exp2TR(1)                                       //> res30: Int = 2
  exp2TR(4)                                       //> res31: Int = 16
  exp2TR(5)                                       //> res32: Int = 32
  exp2TR(10)                                      //> res33: Int = 1024
  exp2TR(20)                                      //> res34: Int = 1048576
  
  // Tail-recursive implementation of 4
	def hyperExpTR(n: Int) = {
	  if (n == 0) 1
	  else {
	    def hyperExpHelper(count: Int, result: Int): Int =
	      if (n < count) result else hyperExpHelper(inc(count), exp2(exp2(dec(n))))
	    hyperExpHelper(1, 1)
	  }
	}                                         //> hyperExpTR: (n: Int)Int

	hyperExpTR(0)                             //> res35: Int = 1
	hyperExpTR(1)                             //> res36: Int = 2
	hyperExpTR(2)                             //> res37: Int = 4
	hyperExpTR(3)                             //> res38: Int = 16
	hyperExpTR(4)                             //> res39: Int = 256
	
	
	/********** #9 **********/
	// Recursive
	def fib(n: Int): Int = {
		if (isZero(n)) 0
		else if (n == 1) 1
		else fib(n - 1) + fib(n - 2)
	}                                         //> fib: (n: Int)Int
	
	fib(0)                                    //> res40: Int = 0
	fib(1)                                    //> res41: Int = 1
	fib(2)                                    //> res42: Int = 1
	fib(3)                                    //> res43: Int = 2
	fib(5)                                    //> res44: Int = 5
	fib(6)                                    //> res45: Int = 8
	fib(10)                                   //> res46: Int = 55
	fib(15)                                   //> res47: Int = 610
	
	
	// Tail-recursive
	def fibTR(n: Int) = {
		def fibHelper(count: Int, result: Int, prevResult: Int): Int = count match {
			case 0 => 0
			case 1 => result
			case _ => fibHelper(count - 1, result + prevResult, result)
		}
		fibHelper(n, 1, 0)
	}                                         //> fibTR: (n: Int)Int
	
	fibTR(0)                                  //> res48: Int = 0
	fibTR(1)                                  //> res49: Int = 1
	fibTR(2)                                  //> res50: Int = 1
	fibTR(3)                                  //> res51: Int = 2
	fibTR(6)                                  //> res52: Int = 8
	fibTR(10)                                 //> res53: Int = 55
	fibTR(15)                                 //> res54: Int = 610
	fibTR(20)                                 //> res55: Int = 6765
	
	
	/********** #10 **********/
	def choose(n: Int, m: Int): Int =
		m match {
			case m if m == 0 || m == n => 1
			case m if m > n => 0
			case _ => choose(dec(n), m) + choose(dec(n), dec(m))
		}                                 //> choose: (n: Int, m: Int)Int
	
	choose(4, 5)                              //> res56: Int = 0
	choose(8, 4)                              //> res57: Int = 70
	choose(5, 3)                              //> res58: Int = 10
	choose(100, 1)                            //> res59: Int = 100
	choose(100, 0)                            //> res60: Int = 1
	choose(100, 100)                          //> res61: Int = 1
}