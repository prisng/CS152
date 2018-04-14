package expression
import context._
import value._

trait Literal extends Value with Expression {
  def execute(env: Environment): Value = this
}