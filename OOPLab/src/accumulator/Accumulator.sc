package accumulator

object Accumulator {
	object Accum {
		var register: Int = 0
		var program = List[Instruction]()		// empty list of instructions
	
		def run() = {
			// For each instruction in the program, execute the instruction
			for (inst <- program) {
				register = inst.execute(register)
			}
		}
	}
	
	trait Instruction {
		// Each instruction updates the register
		def execute(reg: Int): Int
	}
	
	class Add (val r: Int) extends Instruction {
		def execute(reg: Int) = {
			r + reg
		}
	}
	
	// Companion object for Add
	object Add {
	    def apply(r: Int) = new Add(r)
	}
	
	class Mul (val r: Int) extends Instruction {
		def execute(reg: Int) = {
			r * reg
		}
	}
	
	// Companion object for Mul
	object Mul {
	    def apply(r: Int) = new Mul(r)
	}
	
	/*** Problem 1 ***/
	
	// computing ((3 * 5) + 1) * 2
	Accum.program = List(Add(3), Mul(5), Add(1), Mul(2))
	Accum.run()
	Accum.register                                    //> res0: Int = 32
	// computing (((10 * 2) + 3) * 5)
	Accum.register = 0
	Accum.program = List(Add(10), Mul(2), Add(3), Mul(5))
	Accum.run()
	Accum.register                                    //> res1: Int = 115
}