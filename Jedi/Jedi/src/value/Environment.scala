package value
import expression._
import scala.collection.mutable
import scala.collection.mutable.HashMap

class Environment extends collection.mutable.HashMap[Identifier, Value] with Value {
  
}