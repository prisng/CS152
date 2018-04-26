package expression
import context._
import value._
import scala.collection.mutable.ListBuffer


/**
 * A function call consists of an operator (Identifier) and operands (a list of zero
 * or more expressions). The operator is either a pre-defined ALU function, or a Closure
 * produced by a Lambda expression. In the case of a Closure, the Closure's apply method
 * must be called.
 * ---------------------------------------------------------------------------------
 * Executes each of the expressions in the list of operands and puts them in a list of
 * values. Then calls the ALU's execute method for those arguments based on the input operator
 */
case class FunCall(operator: Identifier, operands: List[Expression]) extends Expression {
  
  def execute(env: Environment): Value = {
    // Checking for both ALU and user-defined functions
    val arguments = operands.map(_.execute(env))  // eager execution
    try {
      val maybeClosure = operator.execute(env)
      if (!maybeClosure.isInstanceOf[Closure]) {
        throw new TypeException("Not a closure")
      }
      else maybeClosure.asInstanceOf[Closure].apply(arguments)
    } catch {
      case e: UndefinedException => alu.execute(operator, arguments)
    } // end of try/catch
  }
  
}