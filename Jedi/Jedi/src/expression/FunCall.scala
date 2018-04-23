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
    /* Jedi 1.0 code
    var arguments = List[Value]()
    // Execute each operand expression and put it in the list of arguments to pass to the ALU
    for (i <- operands) {
      arguments = arguments :+ i.execute(env)
    }
    alu.execute(operator, arguments)
    */
    val arguments = operands.map(_.execute(env))  // eager execution
    if (env.contains(operator)) {
      val maybeClosure = operator.execute(env)
      if (!maybeClosure.isInstanceOf(Closure)) throw new TypeException("hi")
      else maybeClosure(args).asInstanceOf(Closure)
    }
    else {
      alu.execute(operator, arguments)
    }
    
    /*
     * problem: this is just the ordinary hash map contains. Need to override contains,
     * like you override apply, to search all of the hash maps in the environment
     */
  }
  
}