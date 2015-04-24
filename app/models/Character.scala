package models

case class CharacterClass(id: Int, spec: Option[Int])

case class Realm(name: String, slug: String)

case class Stats(seasonWins: Int, seasonLosses: Int, weeklyWins: Int, weeklyLosses: Int) {
  val seasonTotal = seasonWins + seasonLosses
  val weeklyTotal = weeklyWins + weeklyLosses
  val seasonWinRatio = seasonWins.toDouble / seasonTotal
  val weeklyWinRatio = weeklyWins.toDouble / weeklyTotal.toDouble
}

case class Character(name: String, charClass: CharacterClass, realm: Realm, charStats: Stats)

abstract case class Team(characters: List[Character], teamStats: Stats) {
  def copy(characters: List[Character] = this.characters, teamStats: Stats = this.teamStats) = Team(characters, teamStats)
}

object Team {
  def apply(characters: List[Character], teamStats: Stats) = {
    val orderedChars = characters.sortBy(c => (c.realm.slug, c.name))
    new Team(orderedChars.toList, teamStats) {}
  }
}
