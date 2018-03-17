package weather

trait IThermometer {
   def getMeanTemperature(cities: List[String]): Double
}