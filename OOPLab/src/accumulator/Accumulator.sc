package accumulator

object Accumulator {
	var register: Int = 0
	var program = List[Instruction]()		// empty list of instructions

	def run() = {
		// for each instruction in list, execute the instruction
		for (inst <- program) {
			register = inst.execute(register)
		}
	}
	
	// register = instruction.execute(register)
}

trait Instruction {
	// Each instruction updates the register
	// Takes register as an input
	def execute(reg: Int): Int
	
}

class Add (val r: Int) extends Instruction {
	def execute(reg: Int) = {
		r + reg
	}
}

class Mul (val r: Int) extends Instruction {
	def execute(reg: Int) = {
		r * reg
	}
}

// Companion object
object Add {
    def apply(r: Int) = new Add(r)
}

// Companion object
object Mul {
    def apply(r: Int) = new Mul(r)
}

/*
object Main {
  def main(args: Array[String]) {
  		Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
		Accumulator.run
  }
}
*/


/*** Problem 1 ***/


// computing ((3 * 5) + 1) * 2
Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
Accumulator.run()
Accumulator.register
// computing (((10 * 2) + 3) * 5)
Accumulator.register = 0
Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
Accumulator.run()
Accumulator.register