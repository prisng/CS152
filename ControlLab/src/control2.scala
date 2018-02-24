

object control2 extends App {

  // problem 1
  
  def tax(income: Double) =
  		income match {
  			case income if income < 100 => 0.1 * income
  			case income if income < 1000 => 0.2 * income
  			case income if income < 10000 => 0.3 * income
  			case _ => 0.1 * income
  		}                                 //> tax: (income: Double)Double
	// end of tax
	
	println(tax(99))                                   //> res0: Double = 9.9
	println(tax(101))                                 //> res1: Double = 20.200000000000003
	println(tax(100000000))                            //> res2: Double = 1.0E7
	
	/* Output
	 * 9.9
	 * 20.200000000000003
	 * 1.0E7
	 */
} // end of object inclassexample