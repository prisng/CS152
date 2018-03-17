package dnd

class Knight(name: String) extends Character(name) {
  if (this.health <= 0) println("im dead yo") //throw new Exception(this.name + " is dead.")

  def attack(victim: Dragon) {
    if (victim.health > 0) {
      super.attack(victim)
      println(this.name + " is stabbing " + victim.name)
    }
  }
}