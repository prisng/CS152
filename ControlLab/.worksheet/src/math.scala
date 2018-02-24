import scala.math._
import scala.util.Random

object math {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(129); 

	// Random object
	val rand = new scala.util.Random(System.nanoTime);System.out.println("""rand  : scala.util.Random = """ + $show(rand ));$skip(365); 
	
	/********** #1 **********/
  def solve(coef: (Double, Double, Double)): Option[(Double, Double)] = {
  		val (a, b, c) = coef
   	val d = (b * b) - (4 * a * c)
   	d match {
   		case d if d > 0 =>
   			val root1 = ((-b + Math.sqrt(d)) / (2 * a))
   			val root2 = ((-b - Math.sqrt(d)) / (2 * a))
   			Some(root1, root2)
   		case d if d <= 0 => None
   }
  };System.out.println("""solve: (coef: (Double, Double, Double))Option[(Double, Double)]""");$skip(42); val res$0 = 
  
  // Testers for #1
  solve(2, -2, -4);System.out.println("""res0: Option[(Double, Double)] = """ + $show(res$0));$skip(17); val res$1 = 
  solve(1, 0, 1);System.out.println("""res1: Option[(Double, Double)] = """ + $show(res$1));$skip(18); val res$2 = 
  solve(1, 0, -1);System.out.println("""res2: Option[(Double, Double)] = """ + $show(res$2));$skip(249); 
  
  
  /********** #2 **********/
  def dist(coord1: (Double, Double), coord2: (Double, Double)) = {
  		val (x1, y1) = coord1
  		val (x2, y2) = coord2
  		val distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))
  		distance
  };System.out.println("""dist: (coord1: (Double, Double), coord2: (Double, Double))Double""");$skip(46); val res$3 = 
  
  // Testers for #2
  dist((1, 1), (0, 0));System.out.println("""res3: Double = """ + $show(res$3));$skip(23); val res$4 = 
  dist((3, 0), (0, 0));System.out.println("""res4: Double = """ + $show(res$4));$skip(225); 
  
  
  /********** #3 **********/
  def dot(a: (Double, Double, Double), b: (Double, Double, Double)) = {
  		val (x1, y1, z1) = a
  		val (x2, y2, z2) = b
  		val dotProduct = x1 * x2 + y1 * y2 + z1 * z2
  		dotProduct
  };System.out.println("""dot: (a: (Double, Double, Double), b: (Double, Double, Double))Double""");$skip(51); val res$5 = 

	// Testers for #3
	dot((2.0, 3, 4), (2, 2.0, 2));System.out.println("""res5: Double = """ + $show(res$5));$skip(27); val res$6 = 
	dot((1, 2, 3), (1, 2, 3));System.out.println("""res6: Double = """ + $show(res$6));$skip(246); 


	/********** #6 **********/
	def isPrime(n: Integer) = {
		var prime = true;
		if (n > 2 && n % 2 == 0 || n == 1) prime = false
		var root = Math.sqrt(n.toInt).toInt
		for (i <- 3 to root by 2) {
			if (n % i == 0) prime = false
		}
		prime
	};System.out.println("""isPrime: (n: Integer)Boolean""");$skip(33); val res$7 = 
	
	// Testers for #6
	isPrime(1);System.out.println("""res7: Boolean = """ + $show(res$7));$skip(12); val res$8 = 
	isPrime(2);System.out.println("""res8: Boolean = """ + $show(res$8));$skip(12); val res$9 = 
	isPrime(3);System.out.println("""res9: Boolean = """ + $show(res$9));$skip(12); val res$10 = 
	isPrime(5);System.out.println("""res10: Boolean = """ + $show(res$10));$skip(13); val res$11 = 
	isPrime(10);System.out.println("""res11: Boolean = """ + $show(res$11));$skip(14); val res$12 = 
	isPrime(199);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(14); val res$13 = 
	isPrime(103);System.out.println("""res13: Boolean = """ + $show(res$13));$skip(12); val res$14 = 
	isPrime(9);System.out.println("""res14: Boolean = """ + $show(res$14));$skip(147); 
	
	
	/********** #7 **********/
	def phi(n: Integer) = {
		var num = 1
		for (k <- 2 to n) {
			if (gcd(n, k) == 1)
				num = num + 1
		}
		num
	};System.out.println("""phi: (n: Integer)Int""");$skip(88); 
	
	def gcd(a: Integer, b: Integer): Integer = {
		if (b == 0) a
		else gcd(b, a % b)
	};System.out.println("""gcd: (a: Integer, b: Integer)Integer""");$skip(29); val res$15 = 
	
	// Testers for #7
	phi(1);System.out.println("""res15: Int = """ + $show(res$15));$skip(8); val res$16 = 
	phi(2);System.out.println("""res16: Int = """ + $show(res$16));$skip(8); val res$17 = 
	phi(9);System.out.println("""res17: Int = """ + $show(res$17));$skip(9); val res$18 = 
	phi(10);System.out.println("""res18: Int = """ + $show(res$18));$skip(138); 
	
	
	/********** #8 **********/
	def rollDice() = {
		val dice = (1 + rand.nextInt((6 - 1) + 1), 1 + rand.nextInt((6 - 1) + 1))
		dice
	};System.out.println("""rollDice: ()(Int, Int)""");$skip(33); val res$19 = 
	
	// Testers for #8
	rollDice();System.out.println("""res19: (Int, Int) = """ + $show(res$19));$skip(12); val res$20 = 
	rollDice();System.out.println("""res20: (Int, Int) = """ + $show(res$20));$skip(12); val res$21 = 
	rollDice();System.out.println("""res21: (Int, Int) = """ + $show(res$21));$skip(12); val res$22 = 
	rollDice();System.out.println("""res22: (Int, Int) = """ + $show(res$22));$skip(12); val res$23 = 
	rollDice();System.out.println("""res23: (Int, Int) = """ + $show(res$23));$skip(12); val res$24 = 
	rollDice();System.out.println("""res24: (Int, Int) = """ + $show(res$24));$skip(12); val res$25 = 
	rollDice();System.out.println("""res25: (Int, Int) = """ + $show(res$25));$skip(12); val res$26 = 
	rollDice();System.out.println("""res26: (Int, Int) = """ + $show(res$26))}
	
}
