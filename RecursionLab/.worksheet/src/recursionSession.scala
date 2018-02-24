object recursionSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(52); 

  def inc(n: Int) = n + 1;System.out.println("""inc: (n: Int)Int""");$skip(25); 
	def dec(n: Int) = n - 1;System.out.println("""dec: (n: Int)Int""");$skip(29); 
	def isZero(n: Int) = n == 0;System.out.println("""isZero: (n: Int)Boolean""");$skip(136); 
  
  /********** #1 **********/
  // Recursive
  def add(n: Int, m: Int): Int = {
  		if (isZero(m)) n
  		else add(inc(n), dec(m))
  };System.out.println("""add: (n: Int, m: Int)Int""");$skip(32); 
  
  val t0 = System.nanoTime();System.out.println("""t0  : Long = """ + $show(t0 ));$skip(12); val res$0 = 
  add(1, 2);System.out.println("""res0: Int = """ + $show(res$0));$skip(12); val res$1 = 
  add(3, 5);System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
  add(5, 5);System.out.println("""res2: Int = """ + $show(res$2));$skip(15); val res$3 = 
 	add(100, 99);System.out.println("""res3: Int = """ + $show(res$3));$skip(29); 
  val t1 = System.nanoTime();System.out.println("""t1  : Long = """ + $show(t1 ));$skip(26); 
  val recurDiff = t1 - t0;System.out.println("""recurDiff  : Long = """ + $show(recurDiff ));$skip(47); 
  println("Time elapsed: " + recurDiff + "ns");$skip(251); 
  
  
  /********** #2 **********/
  // Recursive
  def mul(n: Int, m: Int): Int = {
    	var result = n
  		if (isZero(n) || isZero(m)) result = 0
  		if (m > 1) {
  			result = add(n, mul(n, dec(m))) // result = n * (m - 1) + n
  		}
  		result
  };System.out.println("""mul: (n: Int, m: Int)Int""");$skip(17); val res$4 = 
  
  mul(0, 999);System.out.println("""res4: Int = """ + $show(res$4));$skip(12); val res$5 = 
  mul(3, 5);System.out.println("""res5: Int = """ + $show(res$5));$skip(12); val res$6 = 
  mul(5, 5);System.out.println("""res6: Int = """ + $show(res$6));$skip(14); val res$7 = 
  mul(12, 12);System.out.println("""res7: Int = """ + $show(res$7));$skip(13); val res$8 = 
  mul(30, 3);System.out.println("""res8: Int = """ + $show(res$8));$skip(133); 
  
  
  /********** #3 **********/
  // Recursive
  def exp2(m: Int): Int = {
  		if (isZero(m)) 1
  		else mul(2, exp2(dec(m)))
  };System.out.println("""exp2: (m: Int)Int""");$skip(13); val res$9 = 
  
  exp2(0);System.out.println("""res9: Int = """ + $show(res$9));$skip(10); val res$10 = 
  exp2(1);System.out.println("""res10: Int = """ + $show(res$10));$skip(10); val res$11 = 
  exp2(2);System.out.println("""res11: Int = """ + $show(res$11));$skip(10); val res$12 = 
  exp2(3);System.out.println("""res12: Int = """ + $show(res$12));$skip(10); val res$13 = 
  exp2(4);System.out.println("""res13: Int = """ + $show(res$13));$skip(10); val res$14 = 
  exp2(5);System.out.println("""res14: Int = """ + $show(res$14));$skip(11); val res$15 = 
  exp2(10);System.out.println("""res15: Int = """ + $show(res$15));$skip(178); 
 	// Stack overflow once m >= 15 is called


  /********** #4 **********/
  // Recursive
  def hyperExp(n: Int): Int = {
  		if (isZero(n)) 1
  		else exp2(hyperExp(dec(n)))
  };System.out.println("""hyperExp: (n: Int)Int""");$skip(15); val res$16 = 
	
	hyperExp(0);System.out.println("""res16: Int = """ + $show(res$16));$skip(13); val res$17 = 
	hyperExp(1);System.out.println("""res17: Int = """ + $show(res$17));$skip(13); val res$18 = 
	hyperExp(2);System.out.println("""res18: Int = """ + $show(res$18));$skip(13); val res$19 = 
	hyperExp(3);System.out.println("""res19: Int = """ + $show(res$19));$skip(346); 
	// Stack overflow once n >= 4 is called


  /********** #5 **********/
	/** Tail-recursive implementations of #1-4 **/
	
	// Tail-recursive implementation of #1
  def addTR(n: Int, m: Int) = {
  		def addHelper(result: Int, count: Int): Int =
  		  	if (isZero(count)) result
  			else addHelper(inc(result), dec(count))
  		addHelper(n, m)
  };System.out.println("""addTR: (n: Int, m: Int)Int""");$skip(32); 
  
  val t2 = System.nanoTime();System.out.println("""t2  : Long = """ + $show(t2 ));$skip(14); val res$20 = 
  addTR(1, 2);System.out.println("""res20: Int = """ + $show(res$20));$skip(14); val res$21 = 
  addTR(3, 5);System.out.println("""res21: Int = """ + $show(res$21));$skip(14); val res$22 = 
  addTR(5, 5);System.out.println("""res22: Int = """ + $show(res$22));$skip(17); val res$23 = 
 	addTR(100, 99);System.out.println("""res23: Int = """ + $show(res$23));$skip(29); 
  val t3 = System.nanoTime();System.out.println("""t3  : Long = """ + $show(t3 ));$skip(23); 
  val trDiff = t3 - t2;System.out.println("""trDiff  : Long = """ + $show(trDiff ));$skip(47); 
  println("Time elapsed: " + (t3 - t2) + "ns");$skip(129); 
  
  // Testing computation time
  if (trDiff < recurDiff) println("Tail-recurisve is faster by " + (recurDiff - trDiff) + "ns");$skip(434); 
                                                  
	// When implementing #1-4 tail-recursively, the stack overflow problem is resolved and
	// the computation-time is improved as well.

	// Tail-recursive implementation of 2
	
	def mulTR(n: Int, m: Int) = {
		if (isZero(n) || isZero(m)) 0
		def mulHelper(count: Int, result: Int): Int = {
			if (count >= m) result else mulHelper(inc(count), add(result, n))
		}
		mulHelper(1, n)
	};System.out.println("""mulTR: (n: Int, m: Int)Int""");$skip(15); val res$24 = 
	
	mulTR(3, 5);System.out.println("""res24: Int = """ + $show(res$24));$skip(13); val res$25 = 
	mulTR(4, 5);System.out.println("""res25: Int = """ + $show(res$25));$skip(15); val res$26 = 
	mulTR(10, 10);System.out.println("""res26: Int = """ + $show(res$26));$skip(15); val res$27 = 
	mulTR(0, 150);System.out.println("""res27: Int = """ + $show(res$27));$skip(15); val res$28 = 
	mulTR(12, 12);System.out.println("""res28: Int = """ + $show(res$28));$skip(195); 
  
  // Tail-recursive implementation of 3
	def exp2TR(m: Int) = {
 		def helper (count: Int, result: Int): Int =
 			if (m < count) result else helper(count + 1, 2 * result)
 		helper(1, 1)
  };System.out.println("""exp2TR: (m: Int)Int""");$skip(15); val res$29 = 
  
  exp2TR(0);System.out.println("""res29: Int = """ + $show(res$29));$skip(12); val res$30 = 
  exp2TR(1);System.out.println("""res30: Int = """ + $show(res$30));$skip(12); val res$31 = 
  exp2TR(4);System.out.println("""res31: Int = """ + $show(res$31));$skip(12); val res$32 = 
  exp2TR(5);System.out.println("""res32: Int = """ + $show(res$32));$skip(13); val res$33 = 
  exp2TR(10);System.out.println("""res33: Int = """ + $show(res$33));$skip(13); val res$34 = 
  exp2TR(20);System.out.println("""res34: Int = """ + $show(res$34));$skip(269); 
  
  // Tail-recursive implementation of 4
	def hyperExpTR(n: Int) = {
	  if (n == 0) 1
	  else {
	    def hyperExpHelper(count: Int, result: Int): Int =
	      if (n < count) result else hyperExpHelper(inc(count), exp2(exp2(dec(n))))
	    hyperExpHelper(1, 1)
	  }
	};System.out.println("""hyperExpTR: (n: Int)Int""");$skip(16); val res$35 = 

	hyperExpTR(0);System.out.println("""res35: Int = """ + $show(res$35));$skip(15); val res$36 = 
	hyperExpTR(1);System.out.println("""res36: Int = """ + $show(res$36));$skip(15); val res$37 = 
	hyperExpTR(2);System.out.println("""res37: Int = """ + $show(res$37));$skip(15); val res$38 = 
	hyperExpTR(3);System.out.println("""res38: Int = """ + $show(res$38));$skip(15); val res$39 = 
	hyperExpTR(4);System.out.println("""res39: Int = """ + $show(res$39));$skip(146); 
	
	
	/********** #9 **********/
	// Recursive
	def fib(n: Int): Int = {
		if (isZero(n)) 0
		else if (n == 1) 1
		else fib(n - 1) + fib(n - 2)
	};System.out.println("""fib: (n: Int)Int""");$skip(10); val res$40 = 
	
	fib(0);System.out.println("""res40: Int = """ + $show(res$40));$skip(8); val res$41 = 
	fib(1);System.out.println("""res41: Int = """ + $show(res$41));$skip(8); val res$42 = 
	fib(2);System.out.println("""res42: Int = """ + $show(res$42));$skip(8); val res$43 = 
	fib(3);System.out.println("""res43: Int = """ + $show(res$43));$skip(8); val res$44 = 
	fib(5);System.out.println("""res44: Int = """ + $show(res$44));$skip(8); val res$45 = 
	fib(6);System.out.println("""res45: Int = """ + $show(res$45));$skip(9); val res$46 = 
	fib(10);System.out.println("""res46: Int = """ + $show(res$46));$skip(9); val res$47 = 
	fib(15);System.out.println("""res47: Int = """ + $show(res$47));$skip(251); 
	
	
	// Tail-recursive
	def fibTR(n: Int) = {
		def fibHelper(count: Int, result: Int, prevResult: Int): Int = count match {
			case 0 => 0
			case 1 => result
			case _ => fibHelper(count - 1, result + prevResult, result)
		}
		fibHelper(n, 1, 0)
	};System.out.println("""fibTR: (n: Int)Int""");$skip(12); val res$48 = 
	
	fibTR(0);System.out.println("""res48: Int = """ + $show(res$48));$skip(10); val res$49 = 
	fibTR(1);System.out.println("""res49: Int = """ + $show(res$49));$skip(10); val res$50 = 
	fibTR(2);System.out.println("""res50: Int = """ + $show(res$50));$skip(10); val res$51 = 
	fibTR(3);System.out.println("""res51: Int = """ + $show(res$51));$skip(10); val res$52 = 
	fibTR(6);System.out.println("""res52: Int = """ + $show(res$52));$skip(11); val res$53 = 
	fibTR(10);System.out.println("""res53: Int = """ + $show(res$53));$skip(11); val res$54 = 
	fibTR(15);System.out.println("""res54: Int = """ + $show(res$54));$skip(11); val res$55 = 
	fibTR(20);System.out.println("""res55: Int = """ + $show(res$55));$skip(199); 
	
	
	/********** #10 **********/
	def choose(n: Int, m: Int): Int =
		m match {
			case m if m == 0 || m == n => 1
			case m if m > n => 0
			case _ => choose(dec(n), m) + choose(dec(n), dec(m))
		};System.out.println("""choose: (n: Int, m: Int)Int""");$skip(16); val res$56 = 
	
	choose(4, 5);System.out.println("""res56: Int = """ + $show(res$56));$skip(14); val res$57 = 
	choose(8, 4);System.out.println("""res57: Int = """ + $show(res$57));$skip(14); val res$58 = 
	choose(5, 3);System.out.println("""res58: Int = """ + $show(res$58));$skip(16); val res$59 = 
	choose(100, 1);System.out.println("""res59: Int = """ + $show(res$59));$skip(16); val res$60 = 
	choose(100, 0);System.out.println("""res60: Int = """ + $show(res$60));$skip(18); val res$61 = 
	choose(100, 100);System.out.println("""res61: Int = """ + $show(res$61))}
}
