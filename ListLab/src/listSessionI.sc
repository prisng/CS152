object listSession {

	/***** REMEMBER TO REFORMAT CODE*****/
	/************************************/
	/************************************/
	/************************************/
	/************************************/
	
	// --- Tester functions --- //
	def isOdd(n: Int) = n % 2 != 0
	def cube(n: Int) = n * n * n
	def add(list: List[Int]): Int = {
		var sum = 0
		for (num <- list) sum = sum + num
		sum
	}
	def isEven(x: Int) = x % 2 == 0
	def isPalindrome(n: String) = n == n.reverse
  // ------------------------ //
  
  
	/********** #1 **********/ // Cubing and summing the odd numbers in a list
  
	// Iterative
	def cubeSumIterative(vals: List[Int]) = {
		var sum = 0
		for (value <- vals if value % 2 != 0) {
			sum = sum + value * value * value
		}
		sum
	}
	
	cubeSumIterative(List(1, 2, 3, 4, 5))
	cubeSumIterative(List(2, 4, 6, 8))
	cubeSumIterative(List(3, 3, 3))
	
	// Recursive
	def cubeSumRecursive(vals: List[Int]): Int = {
		if (vals == Nil) 0	// Nil = the empty list; base case
		else if (isOdd(vals.head))
			vals.head * vals.head * vals.head + cubeSumRecursive(vals.tail)
		else cubeSumRecursive(vals.tail)
	}
	
	cubeSumRecursive(List(1, 2, 3, 4, 5))
	cubeSumRecursive(List(2, 4, 6, 8))
	cubeSumRecursive(List(3, 3, 3))
	
	// Tail-recursive
	def cubeSumTR(vals: List[Int]) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (isOdd(vals(count)))
				helper(count - 1, result + vals(count) * vals(count) * vals(count))
			else helper(count - 1, result)
		}
		helper(vals.size - 1, 0)
	}
	
	cubeSumTR(List(1, 2, 3, 4, 5))
	cubeSumTR(List(2, 4, 6, 8))
	cubeSumTR(List(3, 3, 3))
	
	// Map-filter-reduce
	def cubeSumMFR(vals: List[Int]) = {
		// filter -> odd numbers
		// map -> cube them
		// reduce -> sum them
		vals.filter(isOdd).map(cube).reduce(_ + _)
	}
	

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
	}
	
	sumOfSumsIterative(List(List(1, 2, 3), List(4, 5, 6)))
	sumOfSumsIterative(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
	
	// Recursive
	def sumOfSumsRecursive(lists: List[List[Int]]): Int = {
		def sumOfList(nums: List[Int]): Int = {
			if (nums == Nil) 0
			else nums.head + sumOfList(nums.tail)
		}
			if (lists == Nil) 0
			else sumOfList(lists.head) + sumOfSumsRecursive(lists.tail)
	}
	
	sumOfSumsRecursive(List(List(1, 2, 3), List(4, 5, 6)))
	sumOfSumsRecursive(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
	
	// Tail-recursive
	def sumOfSumsTR(lists: List[List[Int]]) = {
		def helper(list: List[List[Int]], result: Int): Int = {
			if (list == Nil) result
			else helper(list.tail, result + add(list.head))
		}
		helper(lists, 0)
	}
	
	sumOfSumsTR(List(List(1, 2, 3), List(4, 5, 6)))
	sumOfSumsTR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
	
	// Map-filter-reduce
	def sumOfSumsMFR(lists: List[List[Int]]): Int = {
		lists.map(add _).reduce(_ + _)
	}
	
	sumOfSumsMFR(List(List(1, 2, 3), List(4, 5, 6)))
	sumOfSumsMFR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
	
	
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
	}
	
	countPassIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	countPassIterative(List("mom", "dad", "dog"), isPalindrome _)
	
	// Recursive
	def countPassRecursive[T](list: List[T], predicate: T => Boolean): Int = {
		if (list == Nil) 0
		else if (predicate(list.head) == true) 1 + countPassRecursive(list.tail, predicate)
		else countPassRecursive(list.tail, predicate)
	}
	
	countPassRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	countPassRecursive(List("mom", "dad", "dog"), isPalindrome _)
	
	// Tail-recurisve
	def countPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (predicate(list(count)) == true) helper(count - 1, result + 1)
			else helper(count - 1, result)
		}
		helper(list.size - 1, 0)
	}
	
	countPassTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	countPassTR(List("mom", "dad", "dog"), isPalindrome _)

	// Map-filter-reduce
	def countPassFilter[T](list: List[T], predicate: T => Boolean): Int = {
		list.filter(predicate).size
	}
	countPassFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	countPassFilter(List("mom", "dad", "dog"), isPalindrome _)
	
	/********** #7 **********/
	// Write a function that returns true if all elements in a list satisfy a given predicate.
	
	// Iterative
	def passIterative[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = true
		for (element <- list) {
			if (!predicate(element)) passed = false
		}
		passed
	}
	
	passIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	passIterative(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
	passIterative(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
	passIterative(List("mom", "dad", "poop", "lol"), isPalindrome _)
	
	// Recursive
	def passRecursive[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) true
		else if (!predicate(list.head)) false
		else passRecursive(list.tail, predicate)
	}
	
	passRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	passRecursive(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
	passRecursive(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
	passRecursive(List("mom", "dad", "poop", "lol"), isPalindrome _)

	// Tail-recursive
	def passTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) true		// empty list satisfies predicate
			else if (!predicate(list.head)) false
			else helper(list.tail, true)
		}
		helper(list, true)
	}
	
	passTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	passTR(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
	passTR(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
	passTR(List("mom", "dad", "poop", "lol"), isPalindrome _)

	// Map-filter-reduce
	def passFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If all of them are true, the size would be the same as original
		if (list.filter(predicate).size == list.size) true
		else false
	}
	
	passFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
	passFilter(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
	passFilter(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
	passFilter(List("mom", "dad", "poop", "lol"), isPalindrome _)
	
	/********** #8 **********/
	// Write a function that returns true if any element in a list satisfies a given predicate.
	// --> This means true if AT LEAST 1 element satisfies a predicate
	
	// Iterative
	def anyPassI[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = false
		for (element <- list) if (predicate(element) == true) passed = true
		passed
	}
	
	anyPassI(List(1, 3, 5, 7, 9, 4), isEven _)
	anyPassI(List(1, 3, 5, 7, 9, 11), isEven _)
	
	// Recursive
	def anyPassR[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) false
		else if (predicate(list.head) == true) true
		else anyPassR(list.tail, predicate)
	}
	
	anyPassR(List(1, 3, 5, 7, 9, 4), isEven _)
	anyPassR(List(1, 3, 5, 7, 9, 11), isEven _)
	
	// Tail-recurisve
	def anyPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) false	// empty list doesn't have any elements that satisfy predicate
			else if (predicate(list.head)) true
			else helper(list.tail, false)
		}
		helper(list, false)
	}
	
	anyPassTR(List(1, 3, 5, 7, 9, 4), isEven _)
	anyPassTR(List(1, 3, 5, 7, 9, 11), isEven _)
	
	// Map-filter-reduce
	def anyPassFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If at least 1 is true, return true
		if (list.filter(predicate).size >= 1) true
		else false
	}
	
	anyPassFilter(List(1, 3, 5, 7, 9, 4), isEven _)
	anyPassFilter(List(1, 3, 5, 7, 9, 11), isEven _)
	
	/********** #10 **********/

	def isSorted(vals: List[Int]) =
		if (vals == vals.sorted) true else false
	
	isSorted(List(1, 2, 3, 4, 5))
	isSorted(List(7, 1, 3, 22, 5))
	
	/********** #13 **********/
	
}