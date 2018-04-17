package context
import expression._
import value._

/*
 * Notes:
 * alu implements all low-level arithmetic, logic, and I/O functions
 * alu does lots of type checking
 * alu is a singleton
 */
object alu {
  // dispatcher
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add" => add(args)
      case "mul" => mul(args)
      case "sub" => sub(args)
      case "div" => div(args)
      case "less" => less(args) //binary
      case "more" => more(args) // binary
      case "equals" => equals(args) // note: equals(7, true) = false, not error
      case "unequals" => unequals(args) // binary, = not(equals(args))?
      case "not" => not(args) // unary
      // primitive I/O ops:
      case "write" => write(args)
      case "prompt" => prompt(args)
      case "read" => read(args)
      case _ => throw new UndefinedException(opcode)
    }
  }
  
    private def toInt(arg: Value): Option[Integer] =
      if (arg.isInstanceOf[Integer]) Some(arg.asInstanceOf[Integer]) else None
      
    private def toReal(arg: Value): Option[Real] =
      if (arg.isInstanceOf[Real]) Some(arg.asInstanceOf[Real]) 
      else if (arg.isInstanceOf[Integer]) Some(Integer.intToReal(arg.asInstanceOf[Integer]))
      else None
      
    private def toChars(arg: Value): Option[Chars] =
      if (arg.isInstanceOf[Chars]) Some(arg.asInstanceOf[Chars]) else None
      
    private def add(args: List[Value]) = {
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) args2.flatten.reduce(_+_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_+_)
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) args4.flatten.reduce(_+_)
          else {
            throw new TypeException("Inputs to + must be numbers or texts")
          }
        }
      }
    }
    
    private def sub(args: List[Value]) = {
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) args2.flatten.reduce(_-_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_-_)
        else throw new TypeException("Inputs to - must be numbers")
      }
    }

    private def mul(args: List[Value]) = {
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) args2.flatten.reduce(_*_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_*_)
        else throw new TypeException("Inputs to * must be numbers")
      }
    }

    private def div(args: List[Value]) = {
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) args2.flatten.reduce(_/_)
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) args3.flatten.reduce(_/_)
        else throw new TypeException("Inputs to / must be numbers")
      }
    }
    
  /**
   * Checks if a < b for comparable values
   */
  def less(args: List[Value]): Value = {
      if (args.length != 2) throw new TypeException("less expects two inputs")
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) Boole(args2(0) < args2(1))
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) Boole(args3(0) < args3(1))
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) Boole(args4(0) < args4(1))
          else throw new TypeException("Inputs to < must be numbers or texts")
        }
      }
   }  
  
  /**
   * Checks if a > b for comparable values
   */
  def more(args: List[Value]): Value = {
      if (args.length != 2) throw new TypeException("less expects two inputs")
      val args2 = args.map(toInt).filter(_ != None)
      if (args2.size == args.size) Boole(args2(0) > args2(1))
      else {
        val args3 = args.map(toReal).filter(_ != None)
        if (args3.size == args.size) Boole(args3(0) > args3(1))
        else {
          val args4 = args.map(toChars).filter(_ != None)
          if (args4.size == args.size) Boole(args4(0) > args4(1))
          else throw new TypeException("Inputs to > must be numbers or texts")
        }
      }
   }

  /**
   * Checks for equality of values in a list of values
   * Note: a == b == c == d is ok
   * This function would check: a == b && a == c && a == d
   */
  def equals(args: List[Value]): Value = {
    if (args.length < 2) throw new TypeException("equals needs at least 2 inputs")
    // Set default value to true
    var result = true
    var index = 0
    // Check each value against the first value
    while (result == true && index < args.length) {
      // If at least two values aren't equal, then the whole value is not equal
      if (args(0) != args(index)) {
        result = false
      }
      index = index + 1
    }
    Boole(result)
  }

  /**
   * Calls alu.not and alu.equals to check if two inputs are not equal
   * Returns true if they are not equal, and false if they are equal
   * (Binary function; expects only 2 inputs)
   */
  def unequals(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("need 2 inputs for unequals")
    // If both inputs are not equal, return a true Boole
    if (not(List(equals(args))) == Boole(true)) Boole(true) else Boole(false)
  }

  /**
   * Negates a Boole value
   * (Unary function; expects only 1 input)
   */
  def not(args: List[Value]): Value = {
    if (args.length != 1) throw new TypeException("need 1 input for not")
    // Type-checking the first value of Boole
    if (!args(0).isInstanceOf[Boole]) throw new TypeException("input to not must be Boole")
    // Return the first value negated
    !(args(0).asInstanceOf[Boole])
  }
  
  def write(vals: List[Value]): Value = {
    println(vals(0))
    Notification.DONE
  }
  
  def read(vals: List[Value]): Value = {
    val result = io.StdIn.readDouble()
    Real(result)
  }
  
  def prompt(vals: List[Value]): Value = {
    print("=> ")
    Notification.DONE
  }

  
  // etc.
}