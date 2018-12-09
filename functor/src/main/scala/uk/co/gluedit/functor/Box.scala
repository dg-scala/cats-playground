package uk.co.gluedit.functor

import uk.co.gluedit.printable._

final case class Box[A](value: A)

object Box {

  implicit def boxPrintable[A](implicit pb: Printable[A]): Printable[Box[A]] =
    pb.contramap[Box[A]](_.value)

}