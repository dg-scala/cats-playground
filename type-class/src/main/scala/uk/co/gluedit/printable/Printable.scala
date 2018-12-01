package uk.co.gluedit.printable

final case class Cat(name: String, age: Int, colour: String)

trait Printable[A] {
  def format(value: A): String
}

object Printable {

  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  def print[A](input: A)(implicit p: Printable[A]): Unit = println(format(input))

}