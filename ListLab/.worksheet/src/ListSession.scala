object listSession {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(287); 

	/***** REMEMBER TO REFORMAT CODE*****/
	/************************************/
	/************************************/
	/************************************/
	/************************************/
	
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
	sumOfSumsMFR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)));System.out.println("""res16: Int = """ + $show(res$16));$skip(475); 
	
	
	/********** #3 **********/
	// ex. depth(List(List(List 1, 2, List(3)))) = 4
	
	

	/********** #6 **********/
	// Write a function that returns the number of elements in a list that satisfy a given predicate.
	// (The predicate is a parameter of type T=>Boolean.)
	
	// Iterative
	def countPassIterative[T](list: List[T], predicate: T => Boolean): Int = {
		var passed = 0
		for (element <- list) {
			if (predicate(element) == true) passed = passed + 1
		}
		passed
	};System.out.println("""countPassIterative: [T](list: List[T], predicate: T => Boolean)Int""");$skip(62); val res$17 = 
	
	countPassIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res17: Int = """ + $show(res$17));$skip(63); val res$18 = 
	countPassIterative(List("mom", "dad", "dog"), isPalindrome _);System.out.println("""res18: Int = """ + $show(res$18));$skip(250); 
	
	// Recursive
	def countPassRecursive[T](list: List[T], predicate: T => Boolean): Int = {
		if (list == Nil) 0
		else if (predicate(list.head) == true) 1 + countPassRecursive(list.tail, predicate)
		else countPassRecursive(list.tail, predicate)
	};System.out.println("""countPassRecursive: [T](list: List[T], predicate: T => Boolean)Int""");$skip(62); val res$19 = 
	
	countPassRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res19: Int = """ + $show(res$19));$skip(63); val res$20 = 
	countPassRecursive(List("mom", "dad", "dog"), isPalindrome _);System.out.println("""res20: Int = """ + $show(res$20));$skip(299); 
	
	// Tail-recurisve
	def countPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (predicate(list(count)) == true) helper(count - 1, result + 1)
			else helper(count - 1, result)
		}
		helper(list.size - 1, 0)
	};System.out.println("""countPassTR: [T](list: List[T], predicate: T => Boolean)Int""");$skip(55); val res$21 = 
	
	countPassTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res21: Int = """ + $show(res$21));$skip(56); val res$22 = 
	countPassTR(List("mom", "dad", "dog"), isPalindrome _);System.out.println("""res22: Int = """ + $show(res$22));$skip(129); 

	// Map-filter-reduce
	def countPassFilter[T](list: List[T], predicate: T => Boolean): Int = {
		list.filter(predicate).size
	};System.out.println("""countPassFilter: [T](list: List[T], predicate: T => Boolean)Int""");$skip(57); val res$23 = 
	countPassFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res23: Int = """ + $show(res$23));$skip(60); val res$24 = 
	countPassFilter(List("mom", "dad", "dog"), isPalindrome _);System.out.println("""res24: Int = """ + $show(res$24));$skip(318); 
	
	/********** #7 **********/
	// Write a function that returns true if all elements in a list satisfy a given predicate.
	
	// Iterative
	def passIterative[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = true
		for (element <- list) {
			if (!predicate(element)) passed = false
		}
		passed
	};System.out.println("""passIterative: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(57); val res$25 = 
	
	passIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res25: Boolean = """ + $show(res$25));$skip(59); val res$26 = 
	passIterative(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _);System.out.println("""res26: Boolean = """ + $show(res$26));$skip(92); val res$27 = 
	passIterative(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _);System.out.println("""res27: Boolean = """ + $show(res$27));$skip(66); val res$28 = 
	passIterative(List("mom", "dad", "poop", "lol"), isPalindrome _);System.out.println("""res28: Boolean = """ + $show(res$28));$skip(201); 
	
	// Recursive
	def passRecursive[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) true
		else if (!predicate(list.head)) false
		else passRecursive(list.tail, predicate)
	};System.out.println("""passRecursive: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(57); val res$29 = 
	
	passRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res29: Boolean = """ + $show(res$29));$skip(59); val res$30 = 
	passRecursive(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _);System.out.println("""res30: Boolean = """ + $show(res$30));$skip(92); val res$31 = 
	passRecursive(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _);System.out.println("""res31: Boolean = """ + $show(res$31));$skip(66); val res$32 = 
	passRecursive(List("mom", "dad", "poop", "lol"), isPalindrome _);System.out.println("""res32: Boolean = """ + $show(res$32));$skip(298); 

	// Tail-recursive
	def passTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) true		// empty list satisfies predicate
			else if (!predicate(list.head)) false
			else helper(list.tail, true)
		}
		helper(list, true)
	};System.out.println("""passTR: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(50); val res$33 = 
	
	passTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res33: Boolean = """ + $show(res$33));$skip(52); val res$34 = 
	passTR(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _);System.out.println("""res34: Boolean = """ + $show(res$34));$skip(85); val res$35 = 
	passTR(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _);System.out.println("""res35: Boolean = """ + $show(res$35));$skip(59); val res$36 = 
	passTR(List("mom", "dad", "poop", "lol"), isPalindrome _);System.out.println("""res36: Boolean = """ + $show(res$36));$skip(245); 

	// Map-filter-reduce
	def passFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If all of them are true, the size would be the same as original
		if (list.filter(predicate).size == list.size) true
		else false
	};System.out.println("""passFilter: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(54); val res$37 = 
	
	passFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _);System.out.println("""res37: Boolean = """ + $show(res$37));$skip(56); val res$38 = 
	passFilter(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _);System.out.println("""res38: Boolean = """ + $show(res$38));$skip(89); val res$39 = 
	passFilter(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _);System.out.println("""res39: Boolean = """ + $show(res$39));$skip(63); val res$40 = 
	passFilter(List("mom", "dad", "poop", "lol"), isPalindrome _);System.out.println("""res40: Boolean = """ + $show(res$40));$skip(380); 
	
	/********** #8 **********/
	// Write a function that returns true if any element in a list satisfies a given predicate.
	// --> This means true if AT LEAST 1 element satisfies a predicate
	
	// Iterative
	def anyPassI[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = false
		for (element <- list) if (predicate(element) == true) passed = true
		passed
	};System.out.println("""anyPassI: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(46); val res$41 = 
	
	anyPassI(List(1, 3, 5, 7, 9, 4), isEven _);System.out.println("""res41: Boolean = """ + $show(res$41));$skip(45); val res$42 = 
	anyPassI(List(1, 3, 5, 7, 9, 11), isEven _);System.out.println("""res42: Boolean = """ + $show(res$42));$skip(198); 
	
	// Recursive
	def anyPassR[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) false
		else if (predicate(list.head) == true) true
		else anyPassR(list.tail, predicate)
	};System.out.println("""anyPassR: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(46); val res$43 = 
	
	anyPassR(List(1, 3, 5, 7, 9, 4), isEven _);System.out.println("""res43: Boolean = """ + $show(res$43));$skip(45); val res$44 = 
	anyPassR(List(1, 3, 5, 7, 9, 11), isEven _);System.out.println("""res44: Boolean = """ + $show(res$44));$skip(331); 
	
	// Tail-recurisve
	def anyPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) false	// empty list doesn't have any elements that satisfy predicate
			else if (predicate(list.head)) true
			else helper(list.tail, false)
		}
		helper(list, false)
	};System.out.println("""anyPassTR: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(47); val res$45 = 
	
	anyPassTR(List(1, 3, 5, 7, 9, 4), isEven _);System.out.println("""res45: Boolean = """ + $show(res$45));$skip(46); val res$46 = 
	anyPassTR(List(1, 3, 5, 7, 9, 11), isEven _);System.out.println("""res46: Boolean = """ + $show(res$46));$skip(212); 
	
	// Map-filter-reduce
	def anyPassFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If at least 1 is true, return true
		if (list.filter(predicate).size >= 1) true
		else false
	};System.out.println("""anyPassFilter: [T](list: List[T], predicate: T => Boolean)Boolean""");$skip(51); val res$47 = 
	
	anyPassFilter(List(1, 3, 5, 7, 9, 4), isEven _);System.out.println("""res47: Boolean = """ + $show(res$47));$skip(50); val res$48 = 
	anyPassFilter(List(1, 3, 5, 7, 9, 11), isEven _);System.out.println("""res48: Boolean = """ + $show(res$48));$skip(108); 
	
	/********** #10 **********/

	def isSorted(vals: List[Int]) =
		if (vals == vals.sorted) true else false;System.out.println("""isSorted: (vals: List[Int])Boolean""");$skip(33); val res$49 = 
	
	isSorted(List(1, 2, 3, 4, 5));System.out.println("""res49: Boolean = """ + $show(res$49));$skip(32); val res$50 = 
	isSorted(List(7, 1, 3, 22, 5));System.out.println("""res50: Boolean = """ + $show(res$50))}
	
	/********** #13 **********/
	
}
