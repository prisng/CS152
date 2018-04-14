package expression
import context._
import value._

/**
 * A declaration allows users to bind identifiers to values of expressions.
 * ------------------------------------------------------------------------
 * Example:	-> def pi = 3.14
 * 					ok
 * 					-> pi
 * 					3.14
 */
case class Declaration(id: Identifier, exp: Expression) extends SpecialForm {
  
  def execute(env: Environment): Value = {
    // Adds a new row (binding) to the environment, then returns OK
    env.put(id, exp.execute(env))
    Notification.OK
  }
  
}