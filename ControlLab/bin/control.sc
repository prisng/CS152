import scala.io._
import scala.util.control.Breaks._
import scala.math._

class InvalidIncomeException extends Exception {}

object control {

	/********** #1 **********/
  def elbonianTax(income: Double) =
	  try {
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
	 		}
	 	} catch {
	 		case e: InvalidIncomeException => println("InvalidIncomeException")
	 	}                                 //> elbonianTax: (income: Double)AnyVal
  
  // Tester for #1
  elbonianTax(20.0)                               //> res0: AnyVal = 0.0
  elbonianTax(50000.0)                            //> res1: AnyVal = 11500.0
  elbonianTax(99999.0)                            //> res2: AnyVal = 31999.68
  elbonianTax(150000.0)                           //> res3: AnyVal = 75000.0
  elbonianTax(-1)                                 //> InvalidIncomeException
                                                  //| res4: AnyVal = ()
  
  /********** #2 **********/
  def drawRectangle(row: Integer, col: Integer) {
  		for (i <- 0 to row - 1) {
			print("\n")
			for (j <- 1 to col) {
  				print("*")
  			}
  		}
  }                                               //> drawRectangle: (row: Integer, col: Integer)Unit
  
  // Tester for #2
  drawRectangle(3, 4)                             //> 
                                                  //| ****
                                                  //| ****
                                                  //| ****
  drawRectangle(2, 5)                             //> 
                                                  //| *****
                                                  //| *****
  
  /********** #3 **********/
  def printSums(row: Integer, col: Integer) {
  		for (i <- 1 to row - 1) {
  			for (j <- 1 to col - 1) {
  				println(i + " + " + j + " = " + (i + j))
  			}
  		}
  }                                               //> printSums: (row: Integer, col: Integer)Unit
  
  // Tester for #3
  printSums(4, 3)                                 //> 1 + 1 = 2
                                                  //| 1 + 2 = 3
                                                  //| 2 + 1 = 3
                                                  //| 2 + 2 = 4
                                                  //| 3 + 1 = 4
                                                  //| 3 + 2 = 5
  
  /********** #4 **********/
  def mystery() {
  		breakable {
		for (i <- 0 to 100 if i % 3 != 0) {
				if (i == 10) break
				println("i = " + i)
			}
		}
		println("done")
 }                                                //> mystery: ()Unit

	// Tester for #4
  mystery()                                       //> i = 1
                                                  //| i = 2
                                                  //| i = 4
                                                  //| i = 5
                                                  //| i = 7
                                                  //| i = 8
                                                  //| done
  
  /********** #5 **********/
  
  def root(x: Double): Option[Double] = if (x < 0) None else Some(Math.sqrt(x))
                                                  //> root: (x: Double)Option[Double]
  def below10(x: Double): Option[Double] = if (x < 10) Some(x) else None
                                                  //> below10: (x: Double)Option[Double]
	def pureRoot(x: Option[Double]): Option[Double] =
		x match {
			case None => None
			case Some(y) => root(y)
		}                                 //> pureRoot: (x: Option[Double])Option[Double]
	
	def pureBelow10(x: Option[Double]): Option[Double] =
		x match {
			case None => None
			case Some(y) => below10(y)
		}                                 //> pureBelow10: (x: Option[Double])Option[Double]
	
	def below10root(x: Option[Double]): Option[Double] =
		pureRoot(pureBelow10(x))          //> below10root: (x: Option[Double])Option[Double]
	
	
	// Testers for #5
	root(49)                                  //> res5: Option[Double] = Some(7.0)
	pureRoot(Some(49))                        //> res6: Option[Double] = Some(7.0)
	pureRoot(Some(-49))                       //> res7: Option[Double] = None
	
	pureBelow10(Some(-11))                    //> res8: Option[Double] = Some(-11.0)
	pureBelow10(Some(9))                      //> res9: Option[Double] = Some(9.0)
	pureBelow10(Some(15))                     //> res10: Option[Double] = None
	
	below10root(Some(16))                     //> res11: Option[Double] = None
	below10root(Some(9))                      //> res12: Option[Double] = Some(3.0)
}