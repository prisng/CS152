package gladiator

trait Crusher {
  def crush(opponent: Gladiator) = {
    println("Crush, crush, crushing " + opponent.name)
    opponent.damage(10)
  }
}