package uk.co.gluedit

import cats.implicits._
import uk.co.gluedit.printable.Cat
import uk.co.gluedit.meetcats.ShowInstances._
import java.util.Date

object HelloCats extends App {

  println((new Date).show)

  val micka = Cat("Micka", 12, "white and brown")
  val cicka = Cat("Cicka", 14, "moggie")
  val tigger = Cat("Tigger", 70, "orange and black")

  println(micka.show)
  println(cicka.show)
  println(tigger.show)

}
