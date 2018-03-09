object listSessionII {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(318); 

	/***** REMEMBER TO REFORMAT CODE*****/
	/************************************/
	/************************************/
	/************************************/
	/************************************/
	
  	/********** #1 **********/
  	// Helper function
  	def add(x: Double, y: Double) = x + y;System.out.println("""add: (x: Double, y: Double)Double""");$skip(85); 
  	
	def avg(scores: List[Double]): Double = {
		scores.reduce(add) / scores.size
	};System.out.println("""avg: (scores: List[Double])Double""");$skip(25); val res$0 = 
	
	avg(List(89, 95, 75));System.out.println("""res0: Double = """ + $show(res$0));$skip(23); val res$1 = 
	avg(List(80, 80, 80));System.out.println("""res1: Double = """ + $show(res$1));$skip(83); 
	
	def avgAvg(scores: List[List[Double]]): List[Double] = {
		scores.map(avg _)
	};System.out.println("""avgAvg: (scores: List[List[Double]])List[Double]""");$skip(72); val res$2 = 
  
  avgAvg(List(List(93, 89, 90), List(75, 76, 68), List(88, 82, 78)));System.out.println("""res2: List[Double] = """ + $show(res$2));$skip(51); val res$3 = 
 	avgAvg(List(List(89, 95, 75), List(80, 80, 80)));System.out.println("""res3: List[Double] = """ + $show(res$3));$skip(515); 
	
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
 	};System.out.println("""passing: (scores: List[List[Double]])List[Int]""");$skip(92); val res$4 = 
 	
 	passing(List(List(90, 90, 90), List(60, 45, 75), List(80, 90, 100), List(60, 95, 90)));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(52); val res$5 = 
	passing(List(List(60, 45, 75), List(80, 90, 100)));System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(304); 
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
	};System.out.println("""sumSums: (scores: List[List[Double]])Double""");$skip(54); val res$6 = 
	
	sumSums(List(List(70, 80, 90), List(90, 95, 100)));System.out.println("""res6: Double = """ + $show(res$6));$skip(69); val res$7 = 
	sumSums(List(List(67, 83, 80), List(75, 82, 98), List(85, 82, 89)));System.out.println("""res7: Double = """ + $show(res$7));$skip(312); 
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
	};System.out.println("""spellCheck: (doc: List[String], dictionary: List[String])List[String]""");$skip(114); val res$8 = 
	
	// should return "eenie" and "miney"
	spellCheck(List("eenie", "meenie", "miney", "mo"), List("meenie", "mo"));System.out.println("""res8: List[String] = """ + $show(res$8));$skip(156); 

	/********** #3 **********/

	def spellCheckFilter(doc: List[String], dictionary: List[String]): List[String] = {
		doc.filter(!dictionary.contains(_))
	};System.out.println("""spellCheckFilter: (doc: List[String], dictionary: List[String])List[String]""");$skip(80); val res$9 = 
	spellCheckFilter(List("eenie", "meenie", "miney", "mo"), List("meenie", "mo"));System.out.println("""res9: List[String] = """ + $show(res$9));$skip(74); 
	
	/********** #4 **********/
	
	val list = List((3.0, 2.0), (-5.0, 0.0));System.out.println("""list  : List[(Double, Double)] = """ + $show(list ));$skip(147); 
	
	// tuple --> use mono._1 to get first double, mono._2 to get second double
	def evalMono(mono: (Double, Double), x: Double): Double = {
	0.0
	};System.out.println("""evalMono: (mono: (Double, Double), x: Double)Double""");$skip(29); val res$10 = 
	
	evalMono((3.0, 2.0), 5.0);System.out.println("""res10: Double = """ + $show(res$10));$skip(114); 
	
	//result of substituting x in mono

	def evalPoly(poly: List[(Double, Double)], x: Double): Double = {
	0.0
	};System.out.println("""evalPoly: (poly: List[(Double, Double)], x: Double)Double""")}
	// result of substituting x in poly
	
}
