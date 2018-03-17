package dnd
import scala.util.Random

class Character (val name: String, var health: Int = 100) {
  val rand = new scala.util.Random(System.nanoTime)
  
  if (this.health <= 0) println("im dead yo") //throw new Exception(this.name + " is dead.")
  
  def isAlive = {
    if (this.health > 0) true else false
  }
  
  def attack(victim: Character) = {
    if (this.health > 0 && victim.health > 0) {
      val damage = 1 + rand.nextInt( (victim.health - 1) + 1 )
      println("damage done: " + damage)
  		  victim.health = victim.health - damage
    }
  }
  
}