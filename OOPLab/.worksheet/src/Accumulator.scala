//package accumulator

object Accumulator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
	var register: Int = 0;System.out.println("""register  : Int = """ + $show(register ));$skip(66); 
	var program = List[Instruction]();System.out.println("""program  : List[Instruction] = """ + $show(program ));$skip(143); 		// empty list of instructions

	def run() {
		// for each instruction in list, execute the instruction
		for (inst <- program) {
			register = inst.execute(register)
		}
	};System.out.println("""run: ()Unit""")}
	
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

object Main {
  def main(args: Array[String]) {
  		Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
		Accumulator.run()
  }
}

/*** Problem 1 ***/

/*
// computing ((3 * 5) + 1) * 2
Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
Accumulator.run()
Accumulator.register
// computing (((10 * 2) + 3) * 5)
Accumulator.register = 0
Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
Accumulator.run()
Accumulator.register
*/
