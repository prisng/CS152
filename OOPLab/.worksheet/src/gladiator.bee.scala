package gladiator

  // Singleton object
object bee extends Gladiator;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(110); ("Bumble Bee") with Slasher with Masher {;System.out.println("""<init> : ()gladiator.bee.type""");$skip(282); 
	override def attack(opponent: Gladiator) = {
	  	super.attack(opponent)
  		if (bee.h > 0) {
	  		slash(opponent)
	  		mash(opponent)
	    println(bee.name + " has attacked " + opponent.name + "!")
    }
    else {
    		println(bee.name + " is dead and cannot attack.")
    	}
	};System.out.println("""attack: (opponent: gladiator.Gladiator)Unit""")}
}	// end of singleton object bee
