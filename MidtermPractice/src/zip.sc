object zip {
  
  def zip[T, S](list1: List[T], list2: List[S]): List[(T, S)] = {
		if (list1 == Nil || list2 == Nil) Nil
  		else if (list1.length != list2.length) throw new Exception("Sequences must have same length to be zipped")
		else (list1.head, list2.head) :: zip(list1.tail, list2.tail)
  }                                               //> zip: [T, S](list1: List[T], list2: List[S])List[(T, S)]
  
	zip(List(1, 2, 3), List("one", "two", "three"))
                                                  //> res0: List[(Int, String)] = List((1,one), (2,two), (3,three))
	zip(List(1, 2), Nil)                      //> res1: List[(Int, Nothing)] = List()
	
  try {
		zip(List(1, 2, 3), List(4, 5))
  }
  catch {
		case e: Exception => println(e)
  }                                               //> java.lang.Exception: Sequences must have same length to be zipped
                                                  //| res2: Any = ()
	/*
	def unzip[T](list: List[T]) = {
		
	}
	*/
}