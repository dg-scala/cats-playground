package uk.co.gluedit.printable

final case class Cat(name: String, age: Int, colour: String)

trait Printable[A] {
  self =>
  def format(value: A): String

  def contramap[B](func: B => A): Printable[B] = new Printable[B] {
    override def format(value: B): String = self.format(func(value))
  }
}

object Printable {

  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)

  def print[A](input: A)(implicit p: Printable[A]): Unit = println(format(input))

}