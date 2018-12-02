package uk.co.gluedit

import cats.implicits._
import uk.co.gluedit.printable.Cat
import uk.co.gluedit.meetcats.ShowInstances._
import uk.co.gluedit.meetcats.EqInstances._
import java.util.Date

object HelloCats extends App {

  println((new Date).show)

  val micka = Cat("Micka", 12, "white and brown")
  val cicka = Cat("Cicka", 14, "moggie")
  val tigger = Cat("Tigger", 70, "orange and black")

  println(micka.show)
  println(cicka.show)
  println(tigger.show)

  val x = new Date
  val y = new Date
  println((x === x).show)
  println((y === x).show)

  println((micka === micka).show)
  println((cicka === micka).show)
  println((tigger === micka).show)

  val garfield = Cat("Garfield", 38, "orange and black")
  val maybeGarfield = Option(garfield)
  val notThere = Option.empty[Cat]
  println(maybeGarfield === notThere)

}
