package value
import expression._
import context._

/**
 * A closure is a function that remembers its defining environment.
 */
class Closure(val params: List[Identifier], val body: Expression, val defEnv: Environment) extends Value {
  
  def apply(args: List[Value]) = {
    // The temporary environment extends the defining environment (static-scope rule)
    val tempEnv = new Environment(defEnv)
    
    if (args.length != params.length) throw new TypeException("The number of args and params do not match.")

    tempEnv.bulkPut(params, args)
    body.execute(tempEnv)
  }
  
}