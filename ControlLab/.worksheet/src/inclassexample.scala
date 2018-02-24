object inclassexample {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(67); 
  println("Welcome to the Scala worksheet");$skip(252); 
  
  // problem 1
  
  def tax(income: Double) =
  		income match {
  			case income if income < 100 => 0.1 * income
  			case income if income < 1000 => 0.2 * income
  			case income if income < 10000 => 0.3 * income
  			case _ => 0.1 * income
  		};System.out.println("""tax: (income: Double)Double""")}
	// end of tax
	
	//tax(99)
	//tax(101)
	//tax(100000000)
	
} // end of object inclassexample
