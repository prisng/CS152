package expression
import context._
import value._

/**
 * A function call consists of an operator (Identifier) and operands (a list of zero
 * or more expressions)
 */
class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    //val v = env.get(this)
    //v
  } 
}