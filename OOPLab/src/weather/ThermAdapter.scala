package weather

/**
 * Adapter for Celcius -> Fahrenheit
 */
class ThermAdapter extends CelciusTherm with IThermometer {
  
  /**
   * Gets mean temperature of a list of cities in Fahrenheit
   */
  def getMeanTemperature(cities: List[String]): Double = {
    // 1-liner
    //var avgTemp = cities.map(computeTemp(_)).reduce(_ + _) / cities.size
    
    var temps = cities.map(computeTemp(_))
    println("Temperatures in each city: " + temps)
    
    var avgTemp = temps.reduce(_ + _) / cities.size
    println("Averange temperature (Celcius): " + avgTemp)

    // Celcius to Fahrenheit
    var fahrenheit = avgTemp * 9 / 5 + 32
    println("Average temperature (Fahrenheit): " + fahrenheit)
    fahrenheit
  }
  
}