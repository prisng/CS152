package gladiator

object gladiator {
	
	class Gladiator (val name: String) {
  		private var health: Int = 100
  		
  		if (health <= 0) throw new Exception(this.name + " has been defeated!")
  
	  /**
	   * Accessor for health
	   */
	  def h: Int = this.health
  
	  /**
	   * Mutator for health
	   */
		def h_=(h: Int): Unit = health = h

	  /**
	   * Print the health of this Gladiator
	   */
	  	def printHealth() = {
	    println(this.health)
	  }

	  /**
	   * Damage done on this Gladiator
	   */
	  def damage(amount: Int) = {
	    health = health - amount
	    if (health <= 0) println(this.name + " has been defeated.")
	  }

	  /**
	   * This Gladiator's default attack (-5 health on the opponent)
	   */
	  def attack(opponent: Gladiator) = {
	  		if (this.health <= 0) throw new Exception(this.name + " is dead and cannot attack.") //println(this.name + " is dead and cannot attack.")
	  		else if (opponent.health <= 0) throw new Exception(opponent.name + " is already dead. You cannot attack.") //println(opponent.name + " is already dead. You cannot attack.")
	  		else {
	  			opponent.damage(5)
	  			println(this.name + " has attacked " + opponent.name + "!")
	  		}
	  }

	} // end of class Gladiator
	
	class CrusherMasher(name: String) extends Gladiator(name) with Crusher with Masher {
  		private var health: Int = 100

	  override def attack(opponent: Gladiator) = {
	  		super.attack(opponent)
	  		if (this.h <= 0) println(this.name + " is dead and cannot attack.")
	  		else if (opponent.h <= 0) println(opponent.name + " is already dead. You cannot attack.")
	  		else {
	  			crush(opponent)
	  			mash(opponent)
	  		}
	  }
	  
	}	// end of class CrusherMasher

	trait Masher {
	  def mash(opponent: Gladiator) = {
	    println("Mash, mash, mashing " + opponent.name)
	    opponent.damage(10)
	  }
	}
	
	trait Crusher {
	  def crush(opponent: Gladiator) = {
	    println("Crush, crush, crushing " + opponent.name)
	    opponent.damage(10)
	  }
	}
	
	trait Slasher {
	  def slash(opponent: Gladiator) = {
	    println("Slash, slash, slashing " + opponent.name)
	    opponent.damage(10)
	  }
	}
	
	val maximus = new CrusherMasher("Optimus Prime")
                                                  //> maximus  : gladiator.gladiator.CrusherMasher = gladiator.gladiator$CrusherM
                                                  //| asher@2328c243
	
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
	
	
	

/******************** TESTING ********************/

	try {
		maximus.printHealth()
		bee.printHealth()
		/*
		for(i <- 0 to 5) {
	     maximus.attack(bee)
	     bee.attack(maximus)
		}
	  */
	  println("Attack 1: ")
	  maximus.attack(bee)
		bee.printHealth()
	  println("Attack 2:")
		maximus.attack(bee)
		bee.printHealth()
	  println("Attack 3: ")
		maximus.attack(bee)
		bee.printHealth()
	  println("Attack 4: ")
		maximus.attack(bee)
		bee.printHealth()
		
		println("Exceptions here")
		//maximus.attack(bee)	 // exception
		//bee.attack(maximus) // exception
	  	maximus.printHealth()
		bee.printHealth()
	}
	catch {
		case e: Exception => println(e)
	}                                         //> 100
                                                  //| 100
                                                  //| Attack 1: 
                                                  //| Optimus Prime has attacked Bumble Bee!
                                                  //| Crush, crush, crushing Bumble Bee
                                                  //| Mash, mash, mashing Bumble Bee
                                                  //| 75
                                                  //| Attack 2:
                                                  //| Optimus Prime has attacked Bumble Bee!
                                                  //| Crush, crush, crushing Bumble Bee
                                                  //| Mash, mash, mashing Bumble Bee
                                                  //| 50
                                                  //| Attack 3: 
                                                  //| Optimus Prime has attacked Bumble Bee!
                                                  //| Crush, crush, crushing Bumble Bee
                                                  //| Mash, mash, mashing Bumble Bee
                                                  //| 25
                                                  //| Attack 4: 
                                                  //| Optimus Prime has attacked Bumble Bee!
                                                  //| Crush, crush, crushing Bumble Bee
                                                  //| Mash, mash, mashing Bumble Bee
                                                  //| Bumble Bee has been defeated.
                                                  //| 0
                                                  //| Exceptions here
                                                  //| 100
                                                  //| 0
	
}