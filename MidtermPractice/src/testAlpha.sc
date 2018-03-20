object testAlpha {

	trait Value
	
	trait Expression {
	  def execute: Value
	}

	trait Literal extends Value with Expression {
	   def execute = this
	}
	
	class Number (val value: Double) extends Literal {
	   override def toString = value.toString
	}
	object Number {
	   def apply(value: Double) = new Number(value)
	}
	
	class Boole (val value: Boolean) extends Literal {
	   override def toString = value.toString
	}
	
	object Boole {
	   def apply(value: Boolean) = new Boole(value)
	}
  
  class Sum(val operand1: Expression, val operand2: Expression) extends Expression {
   def execute =  {
     val arg1 = operand1.execute
     val arg2 = operand2.execute
     if (!arg1.isInstanceOf[Number] || !arg2.isInstanceOf[Number]) {
       throw new Exception("sum inputs must be numbers")
     }
     val num1 = arg1.asInstanceOf[Number]
     val num2 = arg2.asInstanceOf[Number]
     new Number(num1.value + num2.value)
   }
	}

	object Sum {
	   def apply(operand1: Expression, operand2: Expression) = new Sum(operand1, operand2)
	}
	
	class And(val operand1: Expression, val operand2: Expression) extends Expression {
		def execute = {
			val arg1 = operand1.execute
			val arg2 = operand2.execute
			if (!arg1.isInstanceOf[Boole] || !arg2.isInstanceOf[Boole]) {
				throw new Exception("AND inputs must be Booles")
			}
			val num1 = arg1.asInstanceOf[Boole]
			val num2 = arg2.asInstanceOf[Boole]
			new Boole(num1.value && num2.value)
		}
	}
	
	object And {
		def apply(operand1: Expression, operand2: Expression) = new And(operand1, operand2)
	}
	
	
	// Testing
	
		var exp: Expression = Sum(Number(42), Sum(Number(3.14), Number(2.71)))
                                                  //> exp  : testAlpha.Expression = testAlpha$Sum@bebdb06
		println("value = " + exp.execute) //> value = 47.85
		exp = Sum(Number(2), Sum(Number(3), Number(5)))
		println("value = " + exp.execute) //> value = 10.0
		exp = And(Boole(true), And(Boole(false), Boole(true)))
		println("value = " + exp.execute) //> value = false
	
}