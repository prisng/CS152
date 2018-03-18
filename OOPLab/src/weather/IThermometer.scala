package weather

/**
 * Gets mean temperature for a list of cities
 */
trait IThermometer {
   def getMeanTemperature(cities: List[String]): Double
}