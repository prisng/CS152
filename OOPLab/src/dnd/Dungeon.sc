package dnd

object Dungeon {
   val random = new scala.util.Random(System.nanoTime())
                                                  //> random  : scala.util.Random = scala.util.Random@6477463f
	try {
	   val puff = new Dragon("Puff")
	   val thor = new Knight("Thor")
	   
	   
	   while(puff.isAlive && thor.isAlive) {
	      thor.attack(puff)
	      puff.attack(thor)
	   }
	   
	   println("Thor's health: " + thor.health)
	   println("Puff's health: " + puff.health)
	   println(thor.isAlive)
	   println(puff.isAlive)

	}
	catch {
    case e: Exception => println(e)
	}                                         //> damage done: 51
                                                  //| Thor is stabbing Puff
                                                  //| damage done: 5
                                                  //| damage done: 3
                                                  //| Thor is stabbing Puff
                                                  //| damage done: 37
                                                  //| damage done: 46
                                                  //| Thor is stabbing Puff
                                                  //| Thor's health: 58
                                                  //| Puff's health: 0
                                                  //| true
                                                  //| false
	
 }	 // end of singleton object Dungeon