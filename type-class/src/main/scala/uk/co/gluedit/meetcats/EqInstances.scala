package uk.co.gluedit.meetcats

import java.util.Date

import cats.Eq
import cats.implicits._
import uk.co.gluedit.printable.Cat

object EqInstances {

  implicit val dateEq: Eq[Date] = Eq.instance[Date] {
    (d1, d2) => d1.getTime === d2.getTime
  }

  implicit val catEq: Eq[Cat] = Eq.instance[Cat] {
    (c1, c2) => c1.name === c2.name && c1.age === c2.age && c1.colour === c2.colour
  }

}
