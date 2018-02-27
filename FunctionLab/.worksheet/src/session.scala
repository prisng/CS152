object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(233); 

  /********** #1 **********/
  // Generic compose combinator
  // (the input of f should be the same as the output of g)
	def compose[A, B](f: A => B, g: B => A): B => B = {
		def r(x: B):
			B = f(g(x));
   	r _
	};System.out.println("""compose: [A, B](f: A => B, g: B => A)B => B""");$skip(67); 
	
	// --- Tester functions --- //
	def triple(x: Int): Int = 3 * x;System.out.println("""triple: (x: Int)Int""");$skip(28); 
	def square(x: Int) = x * x;System.out.println("""square: (x: Int)Int""");$skip(48); 
	val squareTriple = compose(square _, triple _);System.out.println("""squareTriple  : Int => Int = """ + $show(squareTriple ));$skip(57); val res$0 = 
	// Test without composition function
	square(triple(2));System.out.println("""res0: Int = """ + $show(res$0));$skip(19); val res$1 = 
	square(triple(5));System.out.println("""res1: Int = """ + $show(res$1));$skip(56); val res$2 = 
	
	// Testing the composition function
	squareTriple(2);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
	squareTriple(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(242); 
	
  
  /********** #2 **********/
  // f is composed with itself n times
  def selfIter[T](f: T=>T, n: Int): T => T = {
  		def id[T](x: T) = x
  		if (n == 0) id
  		else	 {
  			def test = selfIter(f, n - 1)
  			compose(f, test)
  		}
  };System.out.println("""selfIter: [T](f: T => T, n: Int)T => T""");$skip(65); 
  
  // --- Tester functions --- //
  def inc(x: Double) = x + 1;System.out.println("""inc: (x: Double)Double""");$skip(31); 
	def double(x: Double) = 2 * x;System.out.println("""double: (x: Double)Double""");$skip(76); 
	
	// Testing the selfIter function
	val selfDouble = selfIter(double _, 3);System.out.println("""selfDouble  : Double => Double = """ + $show(selfDouble ));$skip(84); val res$4 = 
	// double(double(double(5))) = double(double(10)) = double(20) = 40
	selfDouble(5);System.out.println("""res4: Double = """ + $show(res$4));$skip(34); 
	val selfInc = selfIter(inc _, 2);System.out.println("""selfInc  : Double => Double = """ + $show(selfInc ));$skip(41); val res$5 = 
	// inc(inc(5)) = inc(6) = 7
	selfInc(5);System.out.println("""res5: Double = """ + $show(res$5));$skip(63); 
	val doubleIncSelfIter = selfIter(compose(double _, inc _), 3);System.out.println("""doubleIncSelfIter  : Double => Double = """ + $show(doubleIncSelfIter ));$skip(218); val res$6 = 
	// double(inc(double(inc(double(inc(4))))))
	// = double(inc(double(inc(double(5)))))
	// = double(inc(double(inc(10))))
	// = double(inc(double(11)))
	// = double(inc(22))
	// = double(23) = 46
	doubleIncSelfIter(4);System.out.println("""res6: Double = """ + $show(res$6));$skip(273); 

  /********** #3 **********/
  // how do i do this without iteration and with recursion instead
  def countPass[T](values: Array[T], test: T => Boolean): Int = {
  /*
  		var count = 0
		for(value <- values if (test(value) == true)) count = count + 1
		count
		*/
		1
  };System.out.println("""countPass: [T](values: Array[T], test: T => Boolean)Int""");$skip(67); 
  
  // --- Tester functions --- //
  def odd(n: Int) = n % 2 != 0;System.out.println("""odd: (n: Int)Boolean""");$skip(38); 
  def pal(n: String) = n == n.reverse;System.out.println("""pal: (n: String)Boolean""");$skip(44); val res$7 = 
  
  countPass(Array(1, 2, 3, 4, 5), odd _);System.out.println("""res7: Int = """ + $show(res$7));$skip(48); val res$8 = 
  countPass(Array(2, 5, 13, 17, 19, 20), odd _);System.out.println("""res8: Int = """ + $show(res$8));$skip(48); val res$9 = 

  countPass(Array("mom", "dad", "dog"), pal _);System.out.println("""res9: Int = """ + $show(res$9));$skip(63); val res$10 = 
  countPass(Array("racecar", "civic", "anna", "madam"), pal _);System.out.println("""res10: Int = """ + $show(res$10));$skip(418); 
  
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
  };System.out.println("""recur: (baseVal: Int, combiner: (Int, Int) => Int)Int => Int""");$skip(72); 
  
  
 	// --- Tester functions --- //
	val factorial = recur(1, _ * _);System.out.println("""factorial  : Int => Int = """ + $show(factorial ));$skip(47); 
	val tri = recur(0, (n: Int, m: Int) => n + m);System.out.println("""tri  : Int => Int = """ + $show(tri ));$skip(16); val res$11 = 
	
	factorial(5);System.out.println("""res11: Int = """ + $show(res$11));$skip(14); val res$12 = 
	factorial(4);System.out.println("""res12: Int = """ + $show(res$12));$skip(14); val res$13 = 
	factorial(3);System.out.println("""res13: Int = """ + $show(res$13));$skip(10); val res$14 = 
	
	tri(5);System.out.println("""res14: Int = """ + $show(res$14));$skip(9); val res$15 = 
 	tri(4);System.out.println("""res15: Int = """ + $show(res$15));$skip(9); val res$16 = 
 	tri(3);System.out.println("""res16: Int = """ + $show(res$16));$skip(97); 
  
  /********** #5 **********/
  
  def deOptionize[S, T](f: S => Option[T]): S => T = { null };System.out.println("""deOptionize: [S, T](f: S => Option[T])S => T""")}
  
}
