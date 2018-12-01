package uk.co.gluedit

import uk.co.gluedit.asjson.Json._
import uk.co.gluedit.asjson.JsonWriterInstances._
import uk.co.gluedit.printable.Printable._
import uk.co.gluedit.printable.PrintableInstances._
import uk.co.gluedit.asjson.Person

object TypeClass extends App {

  val jString = toJson("Bob")
  val jPerson = toJson(Person("Dragan", "dragan.glumac@gmail.com"))

  print("Bob")
  print(45)
  
}
