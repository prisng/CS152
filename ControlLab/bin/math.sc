import scala.math._
import scala.util.Random

object math {

	// Random object
	val rand = new scala.util.Random(System.nanoTime)
                                                  //> rand  : scala.util.Random = scala.util.Random@22927a81
	
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
  }                                               //> solve: (coef: (Double, Double, Double))Option[(Double, Double)]
  
  // Testers for #1
  solve(2, -2, -4)                                //> res0: Option[(Double, Double)] = Some((2.0,-1.0))
  solve(1, 0, 1)                                  //> res1: Option[(Double, Double)] = None
  solve(1, 0, -1)                                 //> res2: Option[(Double, Double)] = Some((1.0,-1.0))
  
  
  /********** #2 **********/
  def dist(coord1: (Double, Double), coord2: (Double, Double)) = {
  		val (x1, y1) = coord1
  		val (x2, y2) = coord2
  		val distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))
  		distance
  }                                               //> dist: (coord1: (Double, Double), coord2: (Double, Double))Double
  
  // Testers for #2
  dist((1, 1), (0, 0))                            //> res3: Double = 1.4142135623730951
  dist((3, 0), (0, 0))                            //> res4: Double = 3.0
  
  
  /********** #3 **********/
  def dot(a: (Double, Double, Double), b: (Double, Double, Double)) = {
  		val (x1, y1, z1) = a
  		val (x2, y2, z2) = b
  		val dotProduct = x1 * x2 + y1 * y2 + z1 * z2
  		dotProduct
  }                                               //> dot: (a: (Double, Double, Double), b: (Double, Double, Double))Double

	// Testers for #3
	dot((2.0, 3, 4), (2, 2.0, 2))             //> res5: Double = 18.0
	dot((1, 2, 3), (1, 2, 3))                 //> res6: Double = 14.0


	/********** #6 **********/
	def isPrime(n: Integer) = {
		var prime = true;
		if (n > 2 && n % 2 == 0 || n == 1) prime = false
		var root = Math.sqrt(n.toInt).toInt
		for (i <- 3 to root by 2) {
			if (n % i == 0) prime = false
		}
		prime
	}                                         //> isPrime: (n: Integer)Boolean
	
	// Testers for #6
	isPrime(1)                                //> res7: Boolean = false
	isPrime(2)                                //> res8: Boolean = true
	isPrime(3)                                //> res9: Boolean = true
	isPrime(5)                                //> res10: Boolean = true
	isPrime(10)                               //> res11: Boolean = false
	isPrime(199)                              //> res12: Boolean = true
	isPrime(103)                              //> res13: Boolean = true
	isPrime(9)                                //> res14: Boolean = false
	
	
	/********** #7 **********/
	def phi(n: Integer) = {
		var num = 1
		for (k <- 2 to n) {
			if (gcd(n, k) == 1)
				num = num + 1
		}
		num
	}                                         //> phi: (n: Integer)Int
	
	def gcd(a: Integer, b: Integer): Integer = {
		if (b == 0) a
		else gcd(b, a % b)
	}                                         //> gcd: (a: Integer, b: Integer)Integer
	
	// Testers for #7
	phi(1)                                    //> res15: Int = 1
	phi(2)                                    //> res16: Int = 1
	phi(9)                                    //> res17: Int = 6
	phi(10)                                   //> res18: Int = 4
	
	
	/********** #8 **********/
	def rollDice() = {
		val dice = (1 + rand.nextInt((6 - 1) + 1), 1 + rand.nextInt((6 - 1) + 1))
		dice
	}                                         //> rollDice: ()(Int, Int)
	
	// Testers for #8
	rollDice()                                //> res19: (Int, Int) = (4,5)
	rollDice()                                //> res20: (Int, Int) = (6,4)
	rollDice()                                //> res21: (Int, Int) = (2,4)
	rollDice()                                //> res22: (Int, Int) = (4,1)
	rollDice()                                //> res23: (Int, Int) = (6,1)
	rollDice()                                //> res24: (Int, Int) = (3,5)
	rollDice()                                //> res25: (Int, Int) = (1,3)
	rollDice()                                //> res26: (Int, Int) = (1,2)
	
}