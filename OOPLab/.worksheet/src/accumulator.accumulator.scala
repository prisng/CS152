package accumulator

object Accumulator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
	var register: Int = 0;System.out.println("""register  : Int = """ + $show(register ));$skip(66); 
	var program = List[Instruction]();System.out.println("""program  : List[accumulator.Instruction] = """ + $show(program ));$skip(152); 		// empty list of instructions

	def run() = {
		// For each instruction in the program, execute the instruction
		for (inst <- program) {
			register = inst.execute(register)
		}
	};System.out.println("""run: ()Unit""")}
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
/** Note: This runs properly on other Scala IDEs, but does not compile in Eclipse **/

// computing ((3 * 5) + 1) * 2
Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
Accumulator.run()
Accumulator.register
// computing (((10 * 2) + 3) * 5)
Accumulator.register = 0
Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
Accumulator.run()
Accumulator.register
