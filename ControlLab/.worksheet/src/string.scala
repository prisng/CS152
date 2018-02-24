import scala.util.control.Breaks._
import scala.util.Random

object string {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(150); 
 	
 	// Random object
 	val rand = new scala.util.Random(System.nanoTime);System.out.println("""rand  : scala.util.Random = """ + $show(rand ));$skip(352); 

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
  	};System.out.println("""isPal: (input: String)Boolean""");$skip(45); val res$0 = 
  	
  	// Testers for #1
  	isPal("rotator");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(16); val res$1 = 
  	isPal("cat");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(20); val res$2 = 
  	isPal("Rotator");System.out.println("""res2: Boolean = """ + $show(res$2));$skip(23); val res$3 = 
  	isPal("   rotator");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(18); val res$4 = 
	isPal("$5%^%5$");System.out.println("""res4: Boolean = """ + $show(res$4));$skip(172); 
  	
  	
  	/********** #2 **********/
  	def isPal2(input: String) = {
  		val filteredInput = input.replaceAll("[^a-zA-Z ]", "").toLowerCase
  		isPal(filteredInput)
  	};System.out.println("""isPal2: (input: String)Boolean""");$skip(63); val res$5 = 

	// Testers for #2
	isPal2("A man, a plan, a canal, Panama!");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(27); val res$6 = 
	isPal2(" RO  ta Tor    ");System.out.println("""res6: Boolean = """ + $show(res$6));$skip(307); 
	
	
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
	};System.out.println("""mkWord: (length: Integer)String""");$skip(31); val res$7 = 
	
	// Testers for #4
	mkWord();System.out.println("""res7: String = """ + $show(res$7));$skip(12); val res$8 = 
	mkWord(10);System.out.println("""res8: String = """ + $show(res$8));$skip(12); val res$9 = 
	mkWord(20);System.out.println("""res9: String = """ + $show(res$9));$skip(360); 
	

	/********** #5 **********/
	// Note:	Since default sentence length was not specified, I chose it to be 10.
	//				I also made the range of words in the sentence between 1 and 10.
	def mkSentence(length: Integer = 10) = {
		var string = ""
		for (i <- 0 to length) {
			string = string.capitalize + mkWord(rand.nextInt(10)) + " "
		}
		string.trim + "."
	};System.out.println("""mkSentence: (length: Integer)String""");$skip(35); val res$10 = 
	
	// Testers for #5
	mkSentence();System.out.println("""res10: String = """ + $show(res$10));$skip(15); val res$11 = 
	mkSentence(5);System.out.println("""res11: String = """ + $show(res$11));$skip(331); 
                                                  
	
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
	};System.out.println("""eval: (input: String)AnyVal""");$skip(38); val res$12 = 
	
	// Testers for #8
	eval("3.14+42");System.out.println("""res12: AnyVal = """ + $show(res$12));$skip(28); val res$13 = 
	eval("  -26  +  -49.99  ");System.out.println("""res13: AnyVal = """ + $show(res$13));$skip(17); val res$14 = 
	eval("21 * 43");System.out.println("""res14: AnyVal = """ + $show(res$14));$skip(17); val res$15 = 
	eval("abc + 3");System.out.println("""res15: AnyVal = """ + $show(res$15));$skip(367); 
	
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
	};System.out.println("""prodEval: (input: String)AnyVal""");$skip(40); val res$16 = 
	
	// Testers for #9
	prodEval("5 * 5");System.out.println("""res16: AnyVal = """ + $show(res$16));$skip(21); val res$17 = 
	prodEval("10 * 10");System.out.println("""res17: AnyVal = """ + $show(res$17));$skip(19); val res$18 = 
	prodEval("5 + 5");System.out.println("""res18: AnyVal = """ + $show(res$18));$skip(25); val res$19 = 
	prodEval("1.2222 * 12");System.out.println("""res19: AnyVal = """ + $show(res$19));$skip(23); val res$20 = 
	prodEval("122 / 121");System.out.println("""res20: AnyVal = """ + $show(res$20));$skip(21); val res$21 = 
	prodEval("abc + 3");System.out.println("""res21: AnyVal = """ + $show(res$21))}

}
