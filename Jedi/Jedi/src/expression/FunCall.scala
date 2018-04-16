package expression
import context._
import value._
import scala.collection.mutable.ListBuffer


/**
 * A function call consists of an operator (Identifier) and operands (a list of zero
 * or more expressions)
 * ---------------------------------------------------------------------------------
 * Executes each of the expressions in the list of operands and puts them in a list of
 * values. Then calls the ALU's execute method for those arguments based on the input operator
 */
case class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    var arguments = List[Value]()
    for (i <- operands) {
      arguments = arguments :+ i.execute(env)
    }
    alu.execute(operator, arguments) 
  }
}