import scala.util.control.Breaks._
import scala.util.Random

object string {
 	
 	// Random object
 	val rand = new scala.util.Random(System.nanoTime)
                                                  //> rand  : scala.util.Random = scala.util.Random@6477463f

	/********** #1 **********/
  def isPal(input: String) = {
  		val filteredInput = input.replaceAll(" ", "")	// ignore white space
  		val length = filteredInput.length
  		var palindrome = true;
  		for (i <- 0 to (length / 2)) {
  			if (filteredInput(i) != filteredInput(length - i - 1)) {
  				palindrome = false
  			}
  		}
  		palindrome
  	}                                         //> isPal: (input: String)Boolean
  	
  	// Testers for #1
  	isPal("rotator")                          //> res0: Boolean = true
  	isPal("cat")                              //> res1: Boolean = false
  	isPal("Rotator")                          //> res2: Boolean = false
  	isPal("   rotator")                       //> res3: Boolean = true
	isPal("$5%^%5$")                          //> res4: Boolean = true
  	
  	
  	/********** #2 **********/
  	def isPal2(input: String) = {
  		val filteredInput = input.replaceAll("[^a-zA-Z ]", "").toLowerCase
  		isPal(filteredInput)
  	}                                         //> isPal2: (input: String)Boolean

	// Testers for #2
	isPal2("A man, a plan, a canal, Panama!") //> res5: Boolean = true
	isPal2(" RO  ta Tor    ")                 //> res6: Boolean = true
	
	
	/********** #4 **********/
	def mkWord(length: Integer = 5) = {
		val a = 97		// 0x61 hex -> decimal value of 'a'
		val z = 122	// 0x7A hex -> decimal vaue of 'z'
		var string = ""
		for (i <- 0 to length) {
			val word = (a + rand.nextInt((z -a) + 1)).toChar
			string = string + word
		}
		string
	}                                         //> mkWord: (length: Integer)String
	
	// Testers for #4
	mkWord()                                  //> res7: String = erqbrb
	mkWord(10)                                //> res8: String = ajijmkydbnn
	mkWord(20)                                //> res9: String = mndqgaddvapxqjkqsqqtc
	

	/********** #5 **********/
	// Note:	Since default sentence length was not specified, I chose it to be 10.
	//				I also made the range of words in the sentence between 1 and 10.
	def mkSentence(length: Integer = 10) = {
		var string = ""
		for (i <- 0 to length) {
			string = string.capitalize + mkWord(rand.nextInt(10)) + " "
		}
		string.trim + "."
	}                                         //> mkSentence: (length: Integer)String
	
	// Testers for #5
	mkSentence()                              //> res10: String = Osqj bbadxr spsg uyrgnaw u xxeqacgbe zmuxpbtdzi gtuacto wol
                                                  //| nzjtkw fwzex yxupgb.
	mkSentence(5)                             //> res11: String = Dm hga btcd nzvsoxs vzfwmnb cimob.
                                                  
	
	/********** #8 **********/
	def eval(input: String) = {
		try {
			val add = input.split("\\+")
			for (i <- 0 to add.length - 1) {
				add(i).split("\\s+")
			}
			add(0).toDouble + add(1).toDouble
		} catch {
			case e: NumberFormatException => println("Input error")
		}
	}                                         //> eval: (input: String)AnyVal
	
	// Testers for #8
	eval("3.14+42")                           //> res12: AnyVal = 45.14
	eval("  -26  +  -49.99  ")                //> res13: AnyVal = -75.99000000000001
	eval("21 * 43")                           //> Input error
                                                  //| res14: AnyVal = ()
	eval("abc + 3")                           //> Input error
                                                  //| res15: AnyVal = ()
	
	/********** #9 **********/
	def prodEval(input: String) = {
		try {
			val compute = input.split("\\s+")
			if (compute(1) == "+") compute(0).toDouble + compute(2).toDouble
			else if (compute(1) == "*") compute(0).toDouble * compute(2).toDouble
			else throw new NumberFormatException
		} catch {
			case e: NumberFormatException => println("Input error")
		}
	}                                         //> prodEval: (input: String)AnyVal
	
	// Testers for #9
	prodEval("5 * 5")                         //> res16: AnyVal = 25.0
	prodEval("10 * 10")                       //> res17: AnyVal = 100.0
	prodEval("5 + 5")                         //> res18: AnyVal = 10.0
	prodEval("1.2222 * 12")                   //> res19: AnyVal = 14.6664
	prodEval("122 / 121")                     //> Input error
                                                  //| res20: AnyVal = ()
	prodEval("abc + 3")                       //> Input error
                                                  //| res21: AnyVal = ()

}