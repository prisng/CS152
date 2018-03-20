object recursion {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 

	// Helper functions
	def isPalindrome(n: String) = n == n.reverse;System.out.println("""isPalindrome: (n: String)Boolean""");$skip(44); 
	def wordLength(word: String) = word.length;System.out.println("""wordLength: (word: String)Int""");$skip(47); 
	def max(x: Int, y: Int) = if (x > y) x else y;System.out.println("""max: (x: Int, y: Int)Int""");$skip(222); 
	
	/*** Iterative ***/
	def maxPalI(words: List[String]): Int = {
		var maxPal = 0
		for (word <- words) {
			if (isPalindrome(word)) {
				if (word.length > maxPal) {
					maxPal = word.length
				}
			}
		}
		maxPal
  };System.out.println("""maxPalI: (words: List[String])Int""");$skip(56); val res$0 = 
  
  maxPalI(List("mom", "rotator", "cowbells", "dad"));System.out.println("""res0: Int = """ + $show(res$0));$skip(54); val res$1 = 
	maxPalI(List("lol", "lmao", "rip", "madam", "poop"));System.out.println("""res1: Int = """ + $show(res$1));$skip(204); 
	
	/*** Recursive ***/
	def maxPalR(words: List[String]): Int = {
		if (words == Nil) 0
		else if (isPalindrome(words.head)) math.max(words.head.length, maxPalR(words.tail))
		else maxPalR(words.tail)
	};System.out.println("""maxPalR: (words: List[String])Int""");$skip(54); val res$2 = 
	
	maxPalR(List("mom", "rotator", "cowbells", "dad"));System.out.println("""res2: Int = """ + $show(res$2));$skip(54); val res$3 = 
	maxPalR(List("lol", "lmao", "rip", "madam", "poop"));System.out.println("""res3: Int = """ + $show(res$3));$skip(304); 
	
	/*** Tail-Recursive ***/
	def maxPalTR(words: List[String]) = {
		def helper(words: List[String], result: Int): Int = {
			if (words == Nil) result
			else if (isPalindrome(words.head)) helper(words.tail, math.max(result, words.head.size))
			else helper(words.tail, result)
		}
		helper(words, 0)
	};System.out.println("""maxPalTR: (words: List[String])Int""");$skip(55); val res$4 = 
	
	maxPalTR(List("mom", "rotator", "cowbells", "dad"));System.out.println("""res4: Int = """ + $show(res$4));$skip(55); val res$5 = 
	maxPalTR(List("lol", "lmao", "rip", "madam", "poop"));System.out.println("""res5: Int = """ + $show(res$5));$skip(382); 
	
	/*** Map, Filter, Reduce ***/
	def maxPalMFR(words: List[String]) = {
		// Filter the words that are palindromes
		// Map them to their lengths
		// Reduce the list of words to the word with the max length
		val lengths = words.filter(isPalindrome _).map(wordLength _)
		if (lengths == Nil) 0					// make sure whatever you're reducing isn't empty
		else lengths.reduce(max _)
	};System.out.println("""maxPalMFR: (words: List[String])Int""");$skip(55); val res$6 = 

	maxPalMFR(List("mom", "rotator", "cowbells", "dad"));System.out.println("""res6: Int = """ + $show(res$6));$skip(56); val res$7 = 
	maxPalMFR(List("lol", "lmao", "rip", "madam", "poop"));System.out.println("""res7: Int = """ + $show(res$7))}
	
}
