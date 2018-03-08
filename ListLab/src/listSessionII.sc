object listSessionII {

  	/********** #1 **********/
  	// Helper function
  	def add(x: Double, y: Double) = x + y     //> add: (x: Double, y: Double)Double
  	
	def avg(scores: List[Double]): Double = {
		scores.reduce(add) / scores.size
	}                                         //> avg: (scores: List[Double])Double
	
	avg(List(89, 95, 75))                     //> res0: Double = 86.33333333333333
	avg(List(80, 80, 80))                     //> res1: Double = 80.0
	
	def avgAvg(scores: List[List[Double]]): List[Double] = {
		scores.map(avg _)
	}                                         //> avgAvg: (scores: List[List[Double]])List[Double]
  
  avgAvg(List(List(93, 89, 90), List(75, 76, 68), List(88, 82, 78)))
                                                  //> res2: List[Double] = List(90.66666666666667, 73.0, 82.66666666666667)
 	avgAvg(List(List(89, 95, 75), List(80, 80, 80)))
                                                  //> res3: List[Double] = List(86.33333333333333, 80.0)
	
	// map the avgs. check if avg is above 70. then filter
	// avgAvg(scores).filter(x => x >= 70); return type List[Double]
	// doesn't work because it just returns the list of passing exam scores, not the indices

 	def passing(scores: List[List[Double]]): List[Int] = {
 		def helper(scores: List[List[Double]], index: Int): List[Int] = {
 			if (scores == Nil) Nil
 			else if (avg(scores.head) >= 70) index :: helper(scores.tail, index + 1)
 			else helper(scores.tail, index + 1)
 		}
 		helper(scores, 0)
 	}                                         //> passing: (scores: List[List[Double]])List[Int]
 	
 	passing(List(List(90, 90, 90), List(60, 45, 75), List(80, 90, 100), List(60, 95, 90)))
                                                  //> res4: List[Int] = List(0, 2, 3)
	passing(List(List(60, 45, 75), List(80, 90, 100)))
                                                  //> res5: List[Int] = List(1)
  //list of positions in the list with avg >= 70

	def sumSums(scores: List[List[Double]]): Double = {
	/* iterative
		var sum = 0.0
		for (score <- scores) {
			sum = sum + score.reduce(add)
		}
		sum
		*/
		// recursive
		if (scores == Nil) 0.0
		else scores.head.reduce(add) + sumSums(scores.tail)
	}                                         //> sumSums: (scores: List[List[Double]])Double
	
	sumSums(List(List(70, 80, 90), List(90, 95, 100)))
                                                  //> res6: Double = 525.0
	sumSums(List(List(67, 83, 80), List(75, 82, 98), List(85, 82, 89)))
                                                  //> res7: Double = 741.0
	/********** #2 **********/
	
	//all words in doc not in dictionary
	def spellCheck(doc: List[String], dictionary: List[String]): List[String] = {
		var words = List[String]()
		if (doc == dictionary) words
		for (word <- doc) {
			if (!dictionary.contains(word)) {
				words = words :+ word
			}
		}
		words
	}                                         //> spellCheck: (doc: List[String], dictionary: List[String])List[String]
	
	// should return "eenie" and "miney"
	spellCheck(List("eenie", "meenie", "miney", "mo"), List("meenie", "mo"))
                                                  //> res8: List[String] = List(eenie, miney)

	/********** #3 **********/

	def spellCheckFilter(doc: List[String], dictionary: List[String]): List[String] = {
		doc.filter(!dictionary.contains(_))
	}                                         //> spellCheckFilter: (doc: List[String], dictionary: List[String])List[String]
                                                  //| 
	spellCheckFilter(List("eenie", "meenie", "miney", "mo"), List("meenie", "mo"))
                                                  //> res9: List[String] = List(eenie, miney)
	
	/********** #4 **********/
}