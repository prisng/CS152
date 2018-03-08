object listSession {
//1, 2, 6, 7, & 8 -- 4 versions
// iterative, recursive, tail-recursive, map-filter-reduce

	/********** #1 **********/ // Cubing and summing the odd numbers in a list
	// Helper functions
	def isOdd(n: Int) = if (n % 2 != 0) true else false
                                                  //> isOdd: (n: Int)Boolean
	def cube(n: Int) = n * n * n              //> cube: (n: Int)Int
	
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
	
	// Map-filter-reduce (Only filter and reduce in this case)
	def cubeSumMFR(vals: List[Int]) = {
		// filter -> odd numbers
		// map -> cube them
		// reduce -> sum them
		vals.filter(isOdd).map(cube).reduce(_ + _)
	}                                         //> cubeSumMFR: (vals: List[Int])Int
	cubeSumMFR(List(1, 2, 3, 4, 5))           //> res9: Int = 153
	
	def cubeSumFilter[T](predicate: T => Boolean, vals: List[T]): List[T] = {
		if (vals == Nil) Nil
    else if (predicate(vals.head)) vals.head::cubeSumFilter(predicate, vals.tail)
    else cubeSumFilter(predicate, vals.tail)
	}                                         //> cubeSumFilter: [T](predicate: T => Boolean, vals: List[T])List[T]
	
	def cubeSumReduce(vals: List[Int], initVal: Int, combiner: (Int, Int) => Int): Int = {
		if (vals == Nil) initVal
		else combiner(cube(vals.head), cubeSumReduce(vals.tail, initVal, combiner))
	}                                         //> cubeSumReduce: (vals: List[Int], initVal: Int, combiner: (Int, Int) => Int)
                                                  //| Int
                                                  
	// Filters the odd numbers from the list, then adds their cubes
	cubeSumReduce(cubeSumFilter(isOdd _, List(1, 2, 3, 4, 5)), 0, _ + _)
                                                  //> res10: Int = 153
	cubeSumReduce(cubeSumFilter(isOdd _, List(2, 4, 6, 8)), 0, _ + _)
                                                  //> res11: Int = 0
	cubeSumReduce(cubeSumFilter(isOdd _, List(3, 3, 3)), 0, _ + _)
                                                  //> res12: Int = 81

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
                                                  //> res13: Int = 21
	
	// Recursive
	def sumOfSumsRecursive(lists: List[List[Int]]): Int = {
		def sumOfList(nums: List[Int]): Int = {
			if (nums == Nil) 0
			else nums.head + sumOfList(nums.tail)
		}
			if (lists == Nil) 0
			else sumOfList(lists.head) + sumOfSumsRecursive(lists.tail)
	}                                         //> sumOfSumsRecursive: (lists: List[List[Int]])Int
	
	val test = List(List(1, 2, 3), List(4, 5, 6))
                                                  //> test  : List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))

	sumOfSumsRecursive(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res14: Int = 21
	// Tail-recursive
	def sumOfSumsTR(lists: List[List[Int]]) = {
		def helper(count: Int, result: Int): Int = {
			if (count == 0) result
			else helper(count - 1, result + lists.head.head + lists.tail.head.head)
		}
		helper(lists.flatten.size, 0)
	}                                         //> sumOfSumsTR: (lists: List[List[Int]])Int
	
	sumOfSumsTR(List(List(1, 2, 3), List(4, 5, 6)))
                                                  //> res15: Int = 30
	
	/*
	def cubeSumTR(vals: List[Int]) = {
		def helper(count: Int, result: Int): Int = {
			if (count < 0) result
			else if (isOdd(vals(count)))
				helper(count - 1, result + vals(count) * vals(count) * vals(count))
			else helper(count - 1, result)
		}
		helper(vals.size - 1, 0)
	}
	*/
	
	// Map-filter-reduce
	
	/********** #3 **********/

	/********** #6 **********/
	// Iterative
	
	// Recursive
	
	// Tail-recurisve
	
	// Map-filter-reduce
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
	
	isSorted(List(1, 2, 3, 4, 5))             //> res16: Boolean = true
	isSorted(List(7, 1, 3, 22, 5))            //> res17: Boolean = false
	
	/********** #13 **********/
}