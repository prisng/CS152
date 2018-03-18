package gladiator

trait Slasher {
  def slash(opponent: Gladiator) = {
    println("Slash, slash, slashing " + opponent.name)
    opponent.damage(10)
  }
}