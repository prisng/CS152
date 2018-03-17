package weather

/**
 * Tester for weather
 * Given a list of cities, and random temperatures in Celcius, averages temps and converts
 * the average to Fahrenheit
 */
object WeatherStation extends App {
  val thermometer: IThermometer = new ThermAdapter
  val cities = List("San Jose", "Los Angeles", "San Diego", "San Francisco")
  println(cities)
  val avgTemp = thermometer.getMeanTemperature(cities)
}