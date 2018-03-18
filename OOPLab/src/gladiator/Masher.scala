package gladiator

trait Masher {
  def mash(opponent: Gladiator) = {
    println("Mash, mash, mashing " + opponent.name)
    opponent.damage(10)
  }
}