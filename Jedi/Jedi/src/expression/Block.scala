package expression
import value._
import context._

/**
 * A block is a special form that encapsulates a list of semicolon-separated expressions.
 * Executing a block executes each expression in the block, and returns the value of the
 * last expression in the list.
 */
case class Block(val expressions: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    // Create a temporary environment that extends the global environment
    val tempEnv = new Environment(env)
    
    // Execute each expression in the list
    for (exp <- expressions) {
      exp.execute(tempEnv)
    }
    
    // Return the value of the last expression in the list
    expressions.last.execute(tempEnv)
  }
}