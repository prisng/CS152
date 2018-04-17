package expression
import context._
import value._

/**
 * A conjunction takes the form: expression && expression && etc. (2 or more expression operands)
 * ----------------------------------------------------------------------------------------------
 * Note: A value is true if and only if all the expression operands are true.
 * 			If there is 1 false expression operand, it is false. (refer to logical AND truth table)
 * Uses lazy execution.
 */
case class Conjunction(operands: List[Expression]) extends SpecialForm {
  
  def execute(env: Environment): Value = {
    /*
    // Set the default value to be true
    var result = true
    
    // Check all the expression operands
    for (exp <- operands) {
      // Check if it's an instance of Boole first, and if there's 1 false, set result to false
      if (exp.isInstanceOf[Boole] && exp.execute(env) == Boole(false)) result = false
      else throw new TypeException("Input expressions must be Booles.")
    }
    */
    
    // Set the default value to be true
    var result = true
    var index = 0
    
    /*
    // Check if all expression operands are false
    while (result == true && index < operands.length) {
      // Check if it's an instance of Boole first, and if there's 1 false, set result to false
      if (operands(index).isInstanceOf[Boole] && operands(index).execute(env) == Boole(false)) result = false
      else throw new TypeException("Input expressions must be Booles.")
      index = index + 1
    }
    */
    
    // Check if all expression operands are false
    while (result == true && index < operands.length) {
      // Check if it's an instance of Boole first, and if there's 1 false, set result to false
      if (operands(index).execute(env) == Boole(false)) result = false
      //else throw new TypeException("Input expressions must be Booles.")
      index = index + 1
    }
    
    // Return a Boole value
    Boole(result)
  }
  
}