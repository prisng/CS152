package gladiator

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