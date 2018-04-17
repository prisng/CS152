package expression
import context._
import value._

/**
 * A disjunction takes the form: expression || expression || etc. (2 or more expression operands)
 * ----------------------------------------------------------------------------------------------
 * Note: A value is false if and only if all the expression operands are false.
 * 			If there is 1 true expression operand, it is true. (refer to logical OR truth table)
 * Uses lazy execution.
 */
case class Disjunction(operands: List[Expression]) extends SpecialForm {
  
    def execute(env: Environment): Value = {
    // Set the default value to be false
    var result = false
    var index = 0
    
    /*
    // Check if all expression operands are false
    while (result == false && index < operands.length) {
      // Check if it's an instance of Boole first, and if there's 1 true, set result to true
      if (operands(index).isInstanceOf[Boole] && operands(index).execute(env) == Boole(true)) result = true
      else throw new TypeException("Input expressions must be Booles.")
      index = index + 1
    }
    */
    
    // Check if all expression operands are false
    while (result == false && index < operands.length) {
      // Check if it's an instance of Boole first, and if there's 1 true, set result to true
      if (operands(index).execute(env) == Boole(true)) result = true
      index = index + 1
    }
    
    // Return a Boole value
    Boole(result)
    }
  
}