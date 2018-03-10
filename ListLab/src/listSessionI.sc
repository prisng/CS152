object listSession {

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
  
  
	/********** #1 **********/
	/** Cubing and summing the odd numbers in a list **/
  
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
		// filter -> odd numbers, map -> cube them, reduce -> sum them
		vals.filter(isOdd).map(cube).reduce(_ + _)
	}                                         //> cubeSumMFR: (vals: List[Int])Int
	

	/********** #2 **********/
	/** Sum of numbers in a list of lists of numbers **/

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
	/** Write a function that returns the depth of a list of nested lists:
			ex. depth(List(List(List 1, 2, List(3)))) = 4 **/
			
	// Cases: Empty list, list, not a list
	def depth(v: Any): Int = {
		v match {
			case Nil => 0
			case h::t => math.max(depth(h) + 1, depth(t))
			case _ => 0
		}
	}                                         //> depth: (v: Any)Int
  		
	depth(List(List(List(1, 2, List(3)))))    //> res17: Int = 4

	/********** #6 **********/
	/** Write a function that returns the number of elements in a list
			that satisfy a given predicate. **/

	// Iterative
	def countPassIterative[T](list: List[T], predicate: T => Boolean): Int = {
		var passed = 0
		for (element <- list) {
			if (predicate(element) == true) passed = passed + 1
		}
		passed
	}                                         //> countPassIterative: [T](list: List[T], predicate: T => Boolean)Int
	
	countPassIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res18: Int = 4
	countPassIterative(List("mom", "dad", "dog"), isPalindrome _)
                                                  //> res19: Int = 2
	
	// Recursive
	def countPassRecursive[T](list: List[T], predicate: T => Boolean): Int = {
		if (list == Nil) 0
		else if (predicate(list.head) == true) 1 + countPassRecursive(list.tail, predicate)
		else countPassRecursive(list.tail, predicate)
	}                                         //> countPassRecursive: [T](list: List[T], predicate: T => Boolean)Int
	
	countPassRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res20: Int = 4
	countPassRecursive(List("mom", "dad", "dog"), isPalindrome _)
                                                  //> res21: Int = 2
	
	// Tail-recurisve
	def countPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (predicate(list(count)) == true) helper(count - 1, result + 1)
			else helper(count - 1, result)
		}
		helper(list.size - 1, 0)
	}                                         //> countPassTR: [T](list: List[T], predicate: T => Boolean)Int
	
	countPassTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res22: Int = 4
	countPassTR(List("mom", "dad", "dog"), isPalindrome _)
                                                  //> res23: Int = 2

	// Map-filter-reduce
	def countPassFilter[T](list: List[T], predicate: T => Boolean): Int = {
		list.filter(predicate).size
	}                                         //> countPassFilter: [T](list: List[T], predicate: T => Boolean)Int
	countPassFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res24: Int = 4
	countPassFilter(List("mom", "dad", "dog"), isPalindrome _)
                                                  //> res25: Int = 2
	
	/********** #7 **********/
	/** Write a function that returns true if ALL elements in a list satisfy a given predicate. **/
	
	// Iterative
	def passIterative[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = true
		for (element <- list) {
			if (!predicate(element)) passed = false
		}
		passed
	}                                         //> passIterative: [T](list: List[T], predicate: T => Boolean)Boolean
	
	passIterative(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res26: Boolean = false
	passIterative(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
                                                  //> res27: Boolean = true
	passIterative(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
                                                  //> res28: Boolean = false
	passIterative(List("mom", "dad", "poop", "lol"), isPalindrome _)
                                                  //> res29: Boolean = true
	
	// Recursive
	def passRecursive[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) true
		else if (!predicate(list.head)) false
		else passRecursive(list.tail, predicate)
	}                                         //> passRecursive: [T](list: List[T], predicate: T => Boolean)Boolean
	
	passRecursive(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res30: Boolean = false
	passRecursive(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
                                                  //> res31: Boolean = true
	passRecursive(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
                                                  //> res32: Boolean = false
	passRecursive(List("mom", "dad", "poop", "lol"), isPalindrome _)
                                                  //> res33: Boolean = true

	// Tail-recursive
	def passTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) true		// empty list satisfies predicate
			else if (!predicate(list.head)) false
			else helper(list.tail, true)
		}
		helper(list, true)
	}                                         //> passTR: [T](list: List[T], predicate: T => Boolean)Boolean
	
	passTR(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res34: Boolean = false
	passTR(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
                                                  //> res35: Boolean = true
	passTR(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
                                                  //> res36: Boolean = false
	passTR(List("mom", "dad", "poop", "lol"), isPalindrome _)
                                                  //> res37: Boolean = true

	// Map-filter-reduce
	def passFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If all of them are true, the size would be the same as original
		if (list.filter(predicate).size == list.size) true
		else false
	}                                         //> passFilter: [T](list: List[T], predicate: T => Boolean)Boolean
	
	passFilter(List(1, 2, 3, 4, 5, 6, 7, 8), isEven _)
                                                  //> res38: Boolean = false
	passFilter(List(2, 4, 6, 8, 10, 12, 14, 16), isEven _)
                                                  //> res39: Boolean = true
	passFilter(List("mom", "dad", "dog", "hello i'm not a palindrome lol"), isPalindrome _)
                                                  //> res40: Boolean = false
	passFilter(List("mom", "dad", "poop", "lol"), isPalindrome _)
                                                  //> res41: Boolean = true
	
	/********** #8 **********/
	/** Write a function that returns true if any element in a list satisfies a given predicate.
			--> This means true if AT LEAST 1 element satisfies a predicate **/
	
	// Iterative
	def anyPassI[T](list: List[T], predicate: T => Boolean): Boolean = {
		var passed = false
		for (element <- list) if (predicate(element) == true) passed = true
		passed
	}                                         //> anyPassI: [T](list: List[T], predicate: T => Boolean)Boolean
	
	anyPassI(List(1, 3, 5, 7, 9, 4), isEven _)//> res42: Boolean = true
	anyPassI(List(1, 3, 5, 7, 9, 11), isEven _)
                                                  //> res43: Boolean = false
	
	// Recursive
	def anyPassR[T](list: List[T], predicate: T => Boolean): Boolean = {
		if (list == Nil) false
		else if (predicate(list.head) == true) true
		else anyPassR(list.tail, predicate)
	}                                         //> anyPassR: [T](list: List[T], predicate: T => Boolean)Boolean
	
	anyPassR(List(1, 3, 5, 7, 9, 4), isEven _)//> res44: Boolean = true
	anyPassR(List(1, 3, 5, 7, 9, 11), isEven _)
                                                  //> res45: Boolean = false
	
	// Tail-recurisve
	def anyPassTR[T](list: List[T], predicate: T => Boolean) = {
		def helper(list: List[T], result: Boolean): Boolean = {
			if (list == Nil) false	// empty list doesn't have any elements that satisfy predicate
			else if (predicate(list.head)) true
			else helper(list.tail, false)
		}
		helper(list, false)
	}                                         //> anyPassTR: [T](list: List[T], predicate: T => Boolean)Boolean
	
	anyPassTR(List(1, 3, 5, 7, 9, 4), isEven _)
                                                  //> res46: Boolean = true
	anyPassTR(List(1, 3, 5, 7, 9, 11), isEven _)
                                                  //> res47: Boolean = false
	
	// Map-filter-reduce
	def anyPassFilter[T](list: List[T], predicate: T => Boolean) = {
	// Filter the true ones. If at least 1 is true, return true
		if (list.filter(predicate).size >= 1) true
		else false
	}                                         //> anyPassFilter: [T](list: List[T], predicate: T => Boolean)Boolean
	
	anyPassFilter(List(1, 3, 5, 7, 9, 4), isEven _)
                                                  //> res48: Boolean = true
	anyPassFilter(List(1, 3, 5, 7, 9, 11), isEven _)
                                                  //> res49: Boolean = false
	
	/********** #10 **********/
	/** Write a function that returns true if a given list of
			integers is sorted (in ascending order). **/
			
	def isSorted(vals: List[Int]) =
		if (vals == vals.sorted) true else false
                                                  //> isSorted: (vals: List[Int])Boolean
	
	isSorted(List(1, 2, 3, 4, 5))             //> res50: Boolean = true
	isSorted(List(7, 1, 3, 22, 5))            //> res51: Boolean = false
	
	/********** #13 **********/
	/** Streams
	A) An infinitely long stream of 1's
	B) The stream of all non-negative integers
	C) The stream of all non-negative even integers
	D) The stream of all squares of integers
	**/
	
	// A) Infinitely long stream of 1's
	def makeOnes(n: Int): Stream[Int] = 1 #:: makeOnes(1)
                                                  //> makeOnes: (n: Int)Stream[Int]
	
	// Testing the first 10 elements
	makeOnes(0).take(10).foreach(println _)   //> 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
                                                  //| 1
	
	// B) Stream of all non-negative integers
	def nonNeg(n: Int): Stream[Int] = n #:: nonNeg(n + 1)
                                                  //> nonNeg: (n: Int)Stream[Int]
	
	// Testing the first 10 elements
	nonNeg(0).take(10).foreach(println _)     //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
	
	// C) Stream of all non-negative even integers
	def evenNonNeg(n: Int): Stream[Int] = n #:: evenNonNeg(n + 2)
                                                  //> evenNonNeg: (n: Int)Stream[Int]
	
	// Testing the first 10 elements
	evenNonNeg(0).take(10).foreach(println _) //> 0
                                                  //| 2
                                                  //| 4
                                                  //| 6
                                                  //| 8
                                                  //| 10
                                                  //| 12
                                                  //| 14
                                                  //| 16
                                                  //| 18
	
	// D) Stream of all squares of integers
	def squareNums(n: Int): Stream[Int] = math.pow(n, 2).toInt #:: squareNums(n + 1)
                                                  //> squareNums: (n: Int)Stream[Int]
	
	// Testing the first 10 elements
	squareNums(0).take(10).foreach(println _) //> 0
                                                  //| 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  //| 25
                                                  //| 36
                                                  //| 49
                                                  //| 64
                                                  //| 81
}