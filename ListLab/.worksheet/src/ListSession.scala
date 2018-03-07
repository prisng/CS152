object listSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(241); 
//1, 2, 6, 7, & 8 -- 4 versions
// iterative, recursive, tail-recursive, map-filter-reduce

	/********** #1 **********/ // Cubing and summing the odd numbers in a list
	def isOdd(n: Int) = if (n % 2 != 0) true else false;System.out.println("""isOdd: (n: Int)Boolean""");$skip(30); 
	def cube(n: Int) = n * n * n;System.out.println("""cube: (n: Int)Int""");$skip(165); 
	
	// Iterative
	def cubeSumIterative(vals: List[Int]) = {
		var sum = 0
		for (value <- vals if value % 2 != 0) {
			sum = sum + value * value * value
		}
		sum
	};System.out.println("""cubeSumIterative: (vals: List[Int])Int""");$skip(39); val res$0 = 
	cubeSumIterative(List(1, 2, 3, 4, 5));System.out.println("""res0: Int = """ + $show(res$0));$skip(36); val res$1 = 
	cubeSumIterative(List(2, 4, 6, 8));System.out.println("""res1: Int = """ + $show(res$1));$skip(33); val res$2 = 
	cubeSumIterative(List(3, 3, 3));System.out.println("""res2: Int = """ + $show(res$2));$skip(254); 
	
	// Recursive
	def cubeSumRecursive(vals: List[Int]): Int = {
		if (vals == Nil) 0	// Nil = the empty list; base case
		else if (isOdd(vals.head))
			vals.head * vals.head * vals.head + cubeSumRecursive(vals.tail)
		else cubeSumRecursive(vals.tail)
	};System.out.println("""cubeSumRecursive: (vals: List[Int])Int""");$skip(41); val res$3 = 
	
	cubeSumRecursive(List(1, 2, 3, 4, 5));System.out.println("""res3: Int = """ + $show(res$3));$skip(36); val res$4 = 
	cubeSumRecursive(List(2, 4, 6, 8));System.out.println("""res4: Int = """ + $show(res$4));$skip(33); val res$5 = 
	cubeSumRecursive(List(3, 3, 3));System.out.println("""res5: Int = """ + $show(res$5));$skip(282); 
	
	def cubeSumTR(vals: List[Int]) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (isOdd(vals(count)))
				helper(count - 1, result + vals(count) * vals(count) * vals(count))
			else helper(count - 1, result)
		}
		helper(vals.size - 1, 0)
	};System.out.println("""cubeSumTR: (vals: List[Int])Int""");$skip(34); val res$6 = 
	
	cubeSumTR(List(1, 2, 3, 4, 5));System.out.println("""res6: Int = """ + $show(res$6));$skip(29); val res$7 = 
	cubeSumTR(List(2, 4, 6, 8));System.out.println("""res7: Int = """ + $show(res$7));$skip(26); val res$8 = 
	cubeSumTR(List(3, 3, 3));System.out.println("""res8: Int = """ + $show(res$8));$skip(31); 
	
	val x = List(1, 2, 3, 4, 5);System.out.println("""x  : List[Int] = """ + $show(x ));$skip(8); val res$9 = 
	x.size;System.out.println("""res9: Int = """ + $show(res$9));$skip(6); val res$10 = 
	x(3);System.out.println("""res10: Int = """ + $show(res$10));$skip(6); val res$11 = 
	x(4);System.out.println("""res11: Int = """ + $show(res$11))}
	
	
	// Map-filter-reduce

	/********** #2 **********/
	
	/********** #3 **********/

	/********** #6 **********/
	
	/********** #7 **********/

	/********** #8 **********/
	
	/********** #10 **********/

	/********** #13 **********/
}
