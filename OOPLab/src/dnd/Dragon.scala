package dnd

class Dragon(name: String) extends Character(name) {
  def attack(victim: Knight) {
    if (victim.health > 0) {
      super.attack(victim)
      //println(this.name + " is flaming " + victim.name)
    }
  }
}