package expression
import context._
import value._

/**
 * When executed, a lambda expression returns a Closure value.
 */
case class Lambda(val params: List[Identifier], val body: Expression) extends SpecialForm {
  
  def execute(env: Environment): Value = {
    new Closure(params, body, env)
  }
  
}