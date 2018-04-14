package expression
import context._
import value._

/**
 * A conditional takes the form: if (condition) consequent else alternative
 * ------------------------------------------------------------------------
 * Uses conditional execution.
 * If (condition is true) execute the consequent and ignore the alternative
 * else (condition is false) execute the alternative
 * (if null, return Notification.UNSPECIFIED and ignore the consequent)
 */
case class Conditional(cond: Expression, conseq: Expression, alt: Expression) extends SpecialForm {
  
  def execute(env: Environment): Value = {
    // Get the value of the "if" condition
    val ifExpression = cond.execute(env)
    
    // If the if condition is not a Boole, throw a type exception
    if (!ifExpression.isInstanceOf[Boole]) {
      throw new TypeException("If conditional statement must start with a type Boole.")
    }
    
    // If the condition is true, execute the consequent
    if (ifExpression == true) conseq.execute(env)
    // else if the condition is false, execute the alternative (unless it's null)
    else {
      if (alt != null) alt.execute(env)
      else Notification.UNSPECIFIED
    }
  }
  
}