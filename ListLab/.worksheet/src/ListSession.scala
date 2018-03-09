object listSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(177); 
//1, 2, 6, 7, & 8 -- 4 versions
// iterative, recursive, tail-recursive, map-filter-reduce
	
	// --- Tester functions --- //
	def isOdd(n: Int) = n % 2 != 0;System.out.println("""isOdd: (n: Int)Boolean""");$skip(30); 
	def cube(n: Int) = n * n * n;System.out.println("""cube: (n: Int)Int""");$skip(94); 
	def add(list: List[Int]): Int = {
		var sum = 0
		for (num <- list) sum = sum + num
		sum
	};System.out.println("""add: (list: List[Int])Int""");$skip(33); 
	def isEven(x: Int) = x % 2 == 0;System.out.println("""isEven: (x: Int)Boolean""");$skip(46); 
	def isPalindrome(n: String) = n == n.reverse;System.out.println("""isPalindrome: (n: String)Boolean""");$skip(281); 
  // ------------------------ //
  
  
	/********** #1 **********/ // Cubing and summing the odd numbers in a list
  
	// Iterative
	def cubeSumIterative(vals: List[Int]) = {
		var sum = 0
		for (value <- vals if value % 2 != 0) {
			sum = sum + value * value * value
		}
		sum
	};System.out.println("""cubeSumIterative: (vals: List[Int])Int""");$skip(41); val res$0 = 
	
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
	cubeSumRecursive(List(3, 3, 3));System.out.println("""res5: Int = """ + $show(res$5));$skip(301); 
	
	// Tail-recursive
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
	cubeSumTR(List(3, 3, 3));System.out.println("""res8: Int = """ + $show(res$8));$skip(182); 
	
	// Map-filter-reduce
	def cubeSumMFR(vals: List[Int]) = {
		// filter -> odd numbers
		// map -> cube them
		// reduce -> sum them
		vals.filter(isOdd).map(cube).reduce(_ + _)
	};System.out.println("""cubeSumMFR: (vals: List[Int])Int""");$skip(245); 
	

	/********** #2 **********/ // Sum of numbers in a list of lists of numbers

	// Iterative
	def sumOfSumsIterative(lists: List[List[Int]]) = {
		var sum = 0
		for (list <- lists) {
			for (num <- list) {
				sum = sum + num
			}
		}
		sum
	};System.out.println("""sumOfSumsIterative: (lists: List[List[Int]])Int""");$skip(58); val res$9 = 
	
	sumOfSumsIterative(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res9: Int = """ + $show(res$9));$skip(80); val res$10 = 
	sumOfSumsIterative(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)));System.out.println("""res10: Int = """ + $show(res$10));$skip(271); 
	
	// Recursive
	def sumOfSumsRecursive(lists: List[List[Int]]): Int = {
		def sumOfList(nums: List[Int]): Int = {
			if (nums == Nil) 0
			else nums.head + sumOfList(nums.tail)
		}
			if (lists == Nil) 0
			else sumOfList(lists.head) + sumOfSumsRecursive(lists.tail)
	};System.out.println("""sumOfSumsRecursive: (lists: List[List[Int]])Int""");$skip(58); val res$11 = 
	
	sumOfSumsRecursive(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res11: Int = """ + $show(res$11));$skip(80); val res$12 = 
	sumOfSumsRecursive(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)));System.out.println("""res12: Int = """ + $show(res$12));$skip(228); 
	
	// Tail-recursive
	def sumOfSumsTR(lists: List[List[Int]]) = {
		def helper(list: List[List[Int]], result: Int): Int = {
			if (list == Nil) result
			else helper(list.tail, result + add(list.head))
		}
		helper(lists, 0)
	};System.out.println("""sumOfSumsTR: (lists: List[List[Int]])Int""");$skip(51); val res$13 = 
	
	sumOfSumsTR(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res13: Int = """ + $show(res$13));$skip(73); val res$14 = 
	sumOfSumsTR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)));System.out.println("""res14: Int = """ + $show(res$14));$skip(111); 
	
	// Map-filter-reduce
	def sumOfSumsMFR(lists: List[List[Int]]): Int = {
		lists.map(add _).reduce(_ + _)
	};System.out.println("""sumOfSumsMFR: (lists: List[List[Int]])Int""");$skip(52); val res$15 = 
	
	sumOfSumsMFR(List(List(1, 2, 3), List(4, 5, 6)));System.out.println("""res15: Int = """ + $show(res$15));$skip(74); val res$16 = 
	sumOfSumsMFR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)));System.out.println("""res16: Int = """ + $show(res$16));$skip(311); 
	
	
	/********** #3 **********/
	
	

	/********** #6 **********/
	// Write a function that returns the number of elements in a list that satisfy a given predicate.
	// (The predicate is a parameter of type T=>Boolean.)
	
	// Iterative
	def countPassIterative[T](list: List[T], predicate: T => Boolean) = {
	
	};System.out.println("""countPassIterative: [T](list: List[T], predicate: T => Boolean)Unit""");$skip(167); 
	
	// Recursive
	
	// Tail-recurisve
	
	// Map-filter-reduce
	def countPassFilter[T](list: List[T], predicate: T => Boolean): Int = {
		list.filter(predicate).size
	};System.out.println("""countPassFilter: [T](list: List[T], predicate: T => Boolean)Int""");$skip(57); val res$17 = 
	countPassFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res17: Int = """ + $show(res$17));$skip(60); val res$18 = 
	countPassFilter(List("mom", "dad", "dog"), isPalindrome _);System.out.println("""res18: Int = """ + $show(res$18));$skip(320); 
	
	/********** #7 **********/

	// Iterative
	
	// Recursive
	
	// Tail-recurisve
	
	// Map-filter-reduce
	
	/********** #8 **********/

	// Iterative
	
	// Recursive
	
	// Tail-recurisve
	
	// Map-filter-reduce
	
	/********** #10 **********/

	def isSorted(vals: List[Int]) =
		if (vals == vals.sorted) true else false;System.out.println("""isSorted: (vals: List[Int])Boolean""");$skip(33); val res$19 = 
	
	isSorted(List(1, 2, 3, 4, 5));System.out.println("""res19: Boolean = """ + $show(res$19));$skip(32); val res$20 = 
	isSorted(List(7, 1, 3, 22, 5));System.out.println("""res20: Boolean = """ + $show(res$20))}
	
	/********** #13 **********/
}
