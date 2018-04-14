package context
import scala.util.parsing.combinator._
import expression.Identifier

class JediException(val gripe: String = "Jedi error ") extends Exception(gripe) {
  
}