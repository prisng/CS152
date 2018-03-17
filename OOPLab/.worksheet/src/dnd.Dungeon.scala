package dnd

object Dungeon {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
   val random = new scala.util.Random(System.nanoTime());System.out.println("""random  : scala.util.Random = """ + $show(random ));$skip(382); 
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
	}}
	
 }	 // end of singleton object Dungeon
