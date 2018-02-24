import scala.io._

object test extends App {

class InvalidIncomeException extends Exception {}

  def elbonianTax(income: Double) = {
 		if (income < 0) {
 			throw new InvalidIncomeException
 		}
 		income match {
 			case income if income < 20000 => income * 0.0
 			case income if income < 30000 => income * 0.05
 			case income if income < 40000 => income * 0.11
 			case income if income < 60000 => income * 0.23
 			case income if income < 100000 => income * 0.32
			case income if income >= 100000 => income * 0.5
			//case _ => income * 0.0
 		}
  }                                     //> elbonianTax: (income: Double)Unit
  
  		var cmmd: Double = 0.0
  		var input = true
  		val prompt = "=> "
  		println("Enter the income to compute its Elbonian tax rate: ")
  		while (input) {
  			try {
  				print(prompt)
  				cmmd = StdIn.readDouble
  				println(elbonianTax(cmmd))
  			} catch {
  				case e: InvalidIncomeException => println("Error: Invalid income input.")
  			} finally {
  				Console.flush()
  			}
  		}
  		println("bye")

}