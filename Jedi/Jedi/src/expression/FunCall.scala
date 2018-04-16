package expression
import context._
import value._
import scala.collection.mutable.ListBuffer


/**
 * A function call consists of an operator (Identifier) and operands (a list of zero
 * or more expressions)
 */
class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
     var arguments = ListBuffer[Value]()
     for (i <- operands) {
       arguments += i.execute(env)
     }
     alu.execute(operator, arguments.toList)
  }
}