package simple_accumulator

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

// Companion object
object Add {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(309); 
    def apply(r: Int) = new Add(r);System.out.println("""apply: (r: Int)simple_accumulator.Add""")}
}

class Mul (val r: Int) extends Instruction {
	def execute(reg: Int) = {
		r * reg
	}
}
// Companion object
object Mul {
    def apply(r: Int) = new Mul(r)
}



object Accumulator {
	var register: Int = 0
	var program = List[Instruction]()		// empty list of instructions

	def run() = {
		// for each instruction in list, execute the instruction
		for (inst <- program) {
			register = inst.execute(register)
		}
	}
	
	Accumulator.register
}
