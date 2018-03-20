object zip {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(299); 
  
  def zip[T, S](list1: List[T], list2: List[S]): List[(T, S)] = {
		if (list1 == Nil || list2 == Nil) Nil
  		else if (list1.length != list2.length) throw new Exception("Sequences must have same length to be zipped")
		else (list1.head, list2.head) :: zip(list1.tail, list2.tail)
  };System.out.println("""zip: [T, S](list1: List[T], list2: List[S])List[(T, S)]""");$skip(52); val res$0 = 
  
	zip(List(1, 2, 3), List("one", "two", "three"));System.out.println("""res0: List[(Int, String)] = """ + $show(res$0));$skip(22); val res$1 = 
	zip(List(1, 2), Nil);System.out.println("""res1: List[(Int, Nothing)] = """ + $show(res$1));$skip(95); val res$2 = 
	
  try {
		zip(List(1, 2, 3), List(4, 5))
  }
  catch {
		case e: Exception => println(e)
  };System.out.println("""res2: Any = """ + $show(res$2))}
	/*
	def unzip[T](list: List[T]) = {
		
	}
	*/
}
