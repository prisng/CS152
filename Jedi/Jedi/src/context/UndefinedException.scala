package context
import expression.Identifier

class UndefinedException(name: String) extends JediException("Undefined identifier: " + name) {
  
}