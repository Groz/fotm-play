package controllers

import models._
import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    val sf = Realm("Soulflayer", "sf")
    val raz = Realm("Razuvious", "raz")

    val groz = Character("Groz", CharacterClass(5, Some(270)), sf, Stats(0, 0, 0, 0))
    val srez = Character("Srez", CharacterClass(3, Some(62)), raz, Stats(0, 0, 0, 0))
    val dond = Character("Donder", CharacterClass(4, Some(71)), raz, Stats(0, 0, 0, 0))

    Ok(views.html.index("Hullo", List(groz, srez, dond)))
  }

}