package gladiator

// Tester
object gladiatorTester extends App {
	val optimus = new CrusherMasher("Optimus Prime")
	
	// Singleton object
  object bee extends Gladiator("Bumble Bee") with Slasher with Masher {
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
  	}
  }	// end of singleton object bee
	
	try {
		for(i <- 0 to 5) {
      optimus.attack(bee)
      println("Bee's health: " + bee.h)
      bee.attack(optimus)
      println("Optimus' health: " + optimus.h)
		}
	}
	catch {
		case e: Exception => println(e)
	}
	
}