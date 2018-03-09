object listSession {
//1, 2, 6, 7, & 8 -- 4 versions
// iterative, recursive, tail-recursive, map-filter-reduce
	
	// --- Tester functions --- //
	def isOdd(n: Int) = n % 2 != 0            //> isOdd: (n: Int)Boolean
	def cube(n: Int) = n * n * n              //> cube: (n: Int)Int
	def add(list: List[Int]): Int = {
		var sum = 0
		for (num <- list) sum = sum + num
		sum
	}                                         //> add: (list: List[Int])Int
	def isEven(x: Int) = x % 2 == 0           //> isEven: (x: Int)Boolean
	def isPalindrome(n: String) = n == n.reverse
                                                  //> isPalindrome: (n: String)Boolean
  // ------------------------ //
  
  
	/********** #1 **********/ // Cubing and summing the odd numbers in a list
  
	// Iterative
	def cubeSumIterative(vals: List[Int]) = {
		var sum = 0
		for (value <- vals if value % 2 != 0) {
			sum = sum + value * value * value
		}
		sum
	}                                         //> cubeSumIterative: (vals: List[Int])Int
	
	cubeSumIterative(List(1, 2, 3, 4, 5))     //> res0: Int = 153
	cubeSumIterative(List(2, 4, 6, 8))        //> res1: Int = 0
	cubeSumIterative(List(3, 3, 3))           //> res2: Int = 81
	
	// Recursive
	def cubeSumRecursive(vals: List[Int]): Int = {
		if (vals == Nil) 0	// Nil = the empty list; base case
		else if (isOdd(vals.head))
			vals.head * vals.head * vals.head + cubeSumRecursive(vals.tail)
		else cubeSumRecursive(vals.tail)
	}                                         //> cubeSumRecursive: (vals: List[Int])Int
	
	cubeSumRecursive(List(1, 2, 3, 4, 5))     //> res3: Int = 153
	cubeSumRecursive(List(2, 4, 6, 8))        //> res4: Int = 0
	cubeSumRecursive(List(3, 3, 3))           //> res5: Int = 81
	
	// Tail-recursive
	def cubeSumTR(vals: List[Int]) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (isOdd(vals(count)))
				helper(count - 1, result + vals(count) * vals(count) * vals(count))
			else helper(count - 1, result)
		}
		helper(vals.size - 1, 0)
	}                                         //> cubeSumTR: (vals: List[Int])Int
	
	cubeSumTR(List(1, 2, 3, 4, 5))            //> res6: Int = 153
	cubeSumTR(List(2, 4, 6, 8))               //> res7: Int = 0
	cubeSumTR(List(3, 3, 3))                  //> res8: Int = 81
	
	// Map-filter-reduce
	def cubeSumMFR(vals: List[Int]) = {
		// filter -> odd numbers
		// map -> cube them
		// reduce -> sum them
		vals.filter(isOdd).map(cube).reduce(_ + _)
	}                                         //> cubeSumMFR: (vals: List[Int])Int
	

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
	}                                         //> sumOfSumsIterative: (lists: List[List[Int]])Int
	
	sumOfSumsIterative(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res9: Int = 21
	sumOfSumsIterative(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
                                                  //> res10: Int = 136
	
	// Recursive
	def sumOfSumsRecursive(lists: List[List[Int]]): Int = {
		def sumOfList(nums: List[Int]): Int = {
			if (nums == Nil) 0
			else nums.head + sumOfList(nums.tail)
		}
			if (lists == Nil) 0
			else sumOfList(lists.head) + sumOfSumsRecursive(lists.tail)
	}                                         //> sumOfSumsRecursive: (lists: List[List[Int]])Int
	
	sumOfSumsRecursive(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res11: Int = 21
	sumOfSumsRecursive(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
                                                  //> res12: Int = 136
	
	// Tail-recursive
	def sumOfSumsTR(lists: List[List[Int]]) = {
		def helper(list: List[List[Int]], result: Int): Int = {
			if (list == Nil) result
			else helper(list.tail, result + add(list.head))
		}
		helper(lists, 0)
	}                                         //> sumOfSumsTR: (lists: List[List[Int]])Int
	
	sumOfSumsTR(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res13: Int = 21
	sumOfSumsTR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
                                                  //> res14: Int = 136
	
	// Map-filter-reduce
	def sumOfSumsMFR(lists: List[List[Int]]): Int = {
		lists.map(add _).reduce(_ + _)
	}                                         //> sumOfSumsMFR: (lists: List[List[Int]])Int
	
	sumOfSumsMFR(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res15: Int = 21
	sumOfSumsMFR(List(List(1, 2, 3), List(25, 25, 25, 25), List(5, 10, 15)))
                                                  //> res16: Int = 136
	
	
	/********** #3 **********/
	
	

	/********** #6 **********/
	// Write a function that returns the number of elements in a list that satisfy a given predicate.
	// (The predicate is a parameter of type T=>Boolean.)
	
	// Iterative
	def countPassIterative[T](list: List[T], predicate: T => Boolean) = {
	
	}                                         //> countPassIterative: [T](list: List[T], predicate: T => Boolean)Unit
	
	// Recursive
	
	// Tail-recurisve
	
	// Map-filter-reduce
	def countPassFilter[T](list: List[T], predicate: T => Boolean): Int = {
		list.filter(predicate).size
	}                                         //> countPassFilter: [T](list: List[T], predicate: T => Boolean)Int
	countPassFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res17: Int = 4
	countPassFilter(List("mom", "dad", "dog"), isPalindrome _)
                                                  //> res18: Int = 2
	
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
		if (vals == vals.sorted) true else false
                                                  //> isSorted: (vals: List[Int])Boolean
	
	isSorted(List(1, 2, 3, 4, 5))             //> res19: Boolean = true
	isSorted(List(7, 1, 3, 22, 5))            //> res20: Boolean = false
	
	/********** #13 **********/
}