package uk.co.gluedit.printable

object PrintableInstances {

  implicit val stringPrintable: Printable[String] = (value: String) => value

  implicit val intPrintable: Printable[Int] = (value: Int) => value.toString

  implicit val catPrintable: Printable[Cat] =
    (value: Cat) => s"${value.name} is a ${value.age} year-old ${value.colour} cat."

}
