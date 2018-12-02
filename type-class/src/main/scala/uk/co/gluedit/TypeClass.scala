package uk.co.gluedit

import uk.co.gluedit.asjson.Json._
import uk.co.gluedit.asjson.JsonWriterInstances._
import uk.co.gluedit.printable.Printable._
import uk.co.gluedit.printable.PrintableInstances._
import uk.co.gluedit.asjson.Person
import uk.co.gluedit.printable.Cat

object TypeClass extends App {

  val jString = toJson("Bob")
  val jPerson = toJson(Person("Dragan", "dragan.glumac@gmail.com"))

  print("Bob")
  print(45)

  val micka = Cat("Micka", 12, "white and brown")
  val cicka = Cat("Cicka", 14, "moggie")
  val tigger = Cat("Tigger", 70, "orange and black")

  print(micka)
  print(cicka)
  print(tigger)

  println("And now class extension, i.e. interface syntax:")
  import uk.co.gluedit.printable.PrintableSyntax._

  micka.print
  cicka.print
  tigger.print

}
