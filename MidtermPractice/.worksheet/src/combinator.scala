object combinator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(236); 
  
  def pipe[T, S](f: T => S, g: T => S): T => S = {
		// defining r because it's the function you're returning
		def r(t: T): S = {
			try {
				f(t)
			}
			catch {
				case e: Exception => g(t)
			}
		}
		r _
  };System.out.println("""pipe: [T, S](f: T => S, g: T => S)T => S""");$skip(109); 
  
  // pipe takes in 2 anonymous functions
  val toInteger = pipe((s: String) => s.toInt, (s: String) => 0);System.out.println("""toInteger  : String => Int = """ + $show(toInteger ));$skip(42); val res$0 = 
  // should return 0
  toInteger("234s5");System.out.println("""res0: Int = """ + $show(res$0));$skip(21); val res$1 = 
  toInteger("12345");System.out.println("""res1: Int = """ + $show(res$1))}
}
