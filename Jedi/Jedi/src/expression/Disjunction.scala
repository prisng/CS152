package expression
import context._
import value._

/**
 * A disjunction takes the form: expression || expression || etc. (2 or more expression operands)
 * ----------------------------------------------------------------------------------------------
 * Note: A value is false if and only if all the expression operands are false.
 * 			If there is 1 true expression operand, it is true. (refer to logical OR truth table)
 */
case class Disjunction(operands: List[Expression]) extends SpecialForm {
  
    def execute(env: Environment): Value = {
    // Set the default value to be true
    var result = false
    
    // Check all the expression operands
    for (exp <- operands) {
      // Check if it's an instance of Boole first, and if there's 1 false, set result to false
      if (exp.isInstanceOf[Boole] && exp.execute(env) == Boole(true)) result = true
      else throw new TypeException("Input expressions must be Booles.")
    }
    
    // Return a Boole value
    Boole(result)
    }
  
}