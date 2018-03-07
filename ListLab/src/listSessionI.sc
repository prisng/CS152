object listSession {
//1, 2, 6, 7, & 8 -- 4 versions
// iterative, recursive, tail-recursive, map-filter-reduce

	/********** #1 **********/ // Cubing and summing the odd numbers in a list
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
	
	val x = List(1, 2, 3, 4, 5)               //> x  : List[Int] = List(1, 2, 3, 4, 5)
	x.size                                    //> res9: Int = 5
	x(3)                                      //> res10: Int = 4
	x(4)                                      //> res11: Int = 5
	
	// filter list for odd numbers
	// then reduce by adding them
	
	// Map-filter-reduce
	def cubeSumFilter[T](predicate: T => Boolean, vals: List[T]): List[T] = {
		if (vals == Nil) Nil
    else if (predicate(vals.head)) vals.head::cubeSumFilter(predicate, vals.tail)
    else cubeSumFilter(predicate, vals.tail)
	}                                         //> cubeSumFilter: [T](predicate: T => Boolean, vals: List[T])List[T]
	
	def cubeSumReduce(vals: List[Int], initVal: Int, combiner: (Int, Int) => Int): Int = {
		if (vals == Nil) initVal
		else combiner(vals.head * vals.head * vals.head, cubeSumReduce(vals.tail, initVal, combiner))
	}                                         //> cubeSumReduce: (vals: List[Int], initVal: Int, combiner: (Int, Int) => Int)
                                                  //| Int
                                                  
	// Filters the odd numbers from the list, then adds their cubes
	cubeSumReduce(cubeSumFilter(isOdd _, List(1, 2, 3, 4, 5)), 0, _ + _)
                                                  //> res12: Int = 153
	cubeSumReduce(cubeSumFilter(isOdd _, List(2, 4, 6, 8)), 0, _ + _)
                                                  //> res13: Int = 0
	cubeSumReduce(cubeSumFilter(isOdd _, List(3, 3, 3)), 0, _ + _)
                                                  //> res14: Int = 81

	/********** #2 **********/
	
	/********** #3 **********/

	/********** #6 **********/
	
	/********** #7 **********/

	/********** #8 **********/
	
	/********** #10 **********/

	/********** #13 **********/
}