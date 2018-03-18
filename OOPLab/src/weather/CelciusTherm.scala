package weather
import scala.util.Random

/**
 * Represents a thermometer in Celcius
 */
class CelciusTherm {
  
  /**
   * Given a city, computes a random temperature in Celcius for it
   */
  def computeTemp(city: String) = {
	  val rand = new scala.util.Random(System.nanoTime)
	  // Generates a random Celcius temperature between 5 and 30
    5 + rand.nextInt((30 - 5) + 1)
  }
}