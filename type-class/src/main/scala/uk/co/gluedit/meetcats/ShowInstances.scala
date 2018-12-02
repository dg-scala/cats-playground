package uk.co.gluedit.meetcats

import java.util.Date

import cats._
import uk.co.gluedit.printable.Cat

object ShowInstances {

  implicit val dateShow: Show[Date] = Show.show(date => s"${date.getTime}ms since the epoch.")

  implicit val catShow: Show[Cat] = Show.show(cat => s"${cat.name} is a ${cat.age} year-old ${cat.colour} cat.")

}
