package gladiator

class Gladiator (val name: String) {
  		private var health: Int = 100  // can do protected instead and don't have to make getter/setters
  		
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