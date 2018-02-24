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
	squareTriple(5);System.out.println("""res3: Int = """ + $show(res$3))}
	
  
  /********** #2 **********/
  
  
  /********** #3 **********/
  
  
  /********** #4 **********/
  
  
  /********** #5 **********/
  
  
}
