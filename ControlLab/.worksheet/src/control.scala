import scala.io._
import scala.util.control.Breaks._
import scala.math._

class InvalidIncomeException extends Exception {}

object control {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(708); 

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
	 	};System.out.println("""elbonianTax: (income: Double)AnyVal""");$skip(42); val res$0 = 
  
  // Tester for #1
  elbonianTax(20.0);System.out.println("""res0: AnyVal = """ + $show(res$0));$skip(23); val res$1 = 
  elbonianTax(50000.0);System.out.println("""res1: AnyVal = """ + $show(res$1));$skip(23); val res$2 = 
  elbonianTax(99999.0);System.out.println("""res2: AnyVal = """ + $show(res$2));$skip(24); val res$3 = 
  elbonianTax(150000.0);System.out.println("""res3: AnyVal = """ + $show(res$3));$skip(18); val res$4 = 
  elbonianTax(-1);System.out.println("""res4: AnyVal = """ + $show(res$4));$skip(186); 
  
  /********** #2 **********/
  def drawRectangle(row: Integer, col: Integer) {
  		for (i <- 0 to row - 1) {
			print("\n")
			for (j <- 1 to col) {
  				print("*")
  			}
  		}
  };System.out.println("""drawRectangle: (row: Integer, col: Integer)Unit""");$skip(44); 
  
  // Tester for #2
  drawRectangle(3, 4);$skip(22); 
  drawRectangle(2, 5);$skip(203); 
  
  /********** #3 **********/
  def printSums(row: Integer, col: Integer) {
  		for (i <- 1 to row - 1) {
  			for (j <- 1 to col - 1) {
  				println(i + " + " + j + " = " + (i + j))
  			}
  		}
  };System.out.println("""printSums: (row: Integer, col: Integer)Unit""");$skip(40); 
  
  // Tester for #3
  printSums(4, 3);$skip(181); 
  
  /********** #4 **********/
  def mystery() {
  		breakable {
		for (i <- 0 to 100 if i % 3 != 0) {
				if (i == 10) break
				println("i = " + i)
			}
		}
		println("done")
 };System.out.println("""mystery: ()Unit""");$skip(31); 

	// Tester for #4
  mystery();$skip(115); 
  
  /********** #5 **********/
  
  def root(x: Double): Option[Double] = if (x < 0) None else Some(Math.sqrt(x));System.out.println("""root: (x: Double)Option[Double]""");$skip(73); 
  def below10(x: Double): Option[Double] = if (x < 10) Some(x) else None;System.out.println("""below10: (x: Double)Option[Double]""");$skip(115); 
	def pureRoot(x: Option[Double]): Option[Double] =
		x match {
			case None => None
			case Some(y) => root(y)
		};System.out.println("""pureRoot: (x: Option[Double])Option[Double]""");$skip(123); 
	
	def pureBelow10(x: Option[Double]): Option[Double] =
		x match {
			case None => None
			case Some(y) => below10(y)
		};System.out.println("""pureBelow10: (x: Option[Double])Option[Double]""");$skip(83); 
	
	def below10root(x: Option[Double]): Option[Double] =
		pureRoot(pureBelow10(x));System.out.println("""below10root: (x: Option[Double])Option[Double]""");$skip(33); val res$5 = 
	
	
	// Testers for #5
	root(49);System.out.println("""res5: Option[Double] = """ + $show(res$5));$skip(20); val res$6 = 
	pureRoot(Some(49));System.out.println("""res6: Option[Double] = """ + $show(res$6));$skip(21); val res$7 = 
	pureRoot(Some(-49));System.out.println("""res7: Option[Double] = """ + $show(res$7));$skip(26); val res$8 = 
	
	pureBelow10(Some(-11));System.out.println("""res8: Option[Double] = """ + $show(res$8));$skip(22); val res$9 = 
	pureBelow10(Some(9));System.out.println("""res9: Option[Double] = """ + $show(res$9));$skip(23); val res$10 = 
	pureBelow10(Some(15));System.out.println("""res10: Option[Double] = """ + $show(res$10));$skip(25); val res$11 = 
	
	below10root(Some(16));System.out.println("""res11: Option[Double] = """ + $show(res$11));$skip(22); val res$12 = 
	below10root(Some(9));System.out.println("""res12: Option[Double] = """ + $show(res$12))}
}
