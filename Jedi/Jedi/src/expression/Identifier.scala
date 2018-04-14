package expression
import context._
import value._

/**
 * An identifier is the name of a value. Identifiers are executed by looking it up
 * in the environment.
 */
case class Identifier(val name: String) extends Expression {
   override def toString = name
   
   def execute(env: Environment): Value = {
     val value = env.get(this)
     value match {
       case Some(x) => x
       case None => throw new UndefinedException("Undefined Identifier: " + this)
     }
   }
   
}