object recursion {

	// Helper functions
	def isPalindrome(n: String) = n == n.reverse
                                                  //> isPalindrome: (n: String)Boolean
	def wordLength(word: String) = word.length//> wordLength: (word: String)Int
	def max(x: Int, y: Int) = if (x > y) x else y
                                                  //> max: (x: Int, y: Int)Int
	
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
  }                                               //> maxPalI: (words: List[String])Int
  
  maxPalI(List("mom", "rotator", "cowbells", "dad"))
                                                  //> res0: Int = 7
	maxPalI(List("lol", "lmao", "rip", "madam", "poop"))
                                                  //> res1: Int = 5
	
	/*** Recursive ***/
	def maxPalR(words: List[String]): Int = {
		if (words == Nil) 0
		else if (isPalindrome(words.head)) math.max(words.head.length, maxPalR(words.tail))
		else maxPalR(words.tail)
	}                                         //> maxPalR: (words: List[String])Int
	
	maxPalR(List("mom", "rotator", "cowbells", "dad"))
                                                  //> res2: Int = 7
	maxPalR(List("lol", "lmao", "rip", "madam", "poop"))
                                                  //> res3: Int = 5
	
	/*** Tail-Recursive ***/
	def maxPalTR(words: List[String]) = {
		def helper(words: List[String], result: Int): Int = {
			if (words == Nil) result
			else if (isPalindrome(words.head)) helper(words.tail, math.max(result, words.head.size))
			else helper(words.tail, result)
		}
		helper(words, 0)
	}                                         //> maxPalTR: (words: List[String])Int
	
	maxPalTR(List("mom", "rotator", "cowbells", "dad"))
                                                  //> res4: Int = 7
	maxPalTR(List("lol", "lmao", "rip", "madam", "poop"))
                                                  //> res5: Int = 5
	
	/*** Map, Filter, Reduce ***/
	def maxPalMFR(words: List[String]) = {
		// Filter the words that are palindromes
		// Map them to their lengths
		// Reduce the list of words to the word with the max length
		val lengths = words.filter(isPalindrome _).map(wordLength _)
		if (lengths == Nil) 0					// make sure whatever you're reducing isn't empty
		else lengths.reduce(max _)
	}                                         //> maxPalMFR: (words: List[String])Int

	maxPalMFR(List("mom", "rotator", "cowbells", "dad"))
                                                  //> res6: Int = 7
	maxPalMFR(List("lol", "lmao", "rip", "madam", "poop"))
                                                  //> res7: Int = 5
	
}