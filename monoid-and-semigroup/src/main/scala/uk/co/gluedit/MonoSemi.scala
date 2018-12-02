package uk.co.gluedit

import cats.implicits._
import uk.co.gluedit.monosemi.Order
import uk.co.gluedit.monosemi.SuperAdder._

object MonoSemi extends App {

  val as = add(List(1, 2, 3))
  println(as.show)

  val aa = addM(List(1, 2, 3))
  println(aa.show)

  val maybeAa = addM(List(Some(1), Some(2), Some(3), None))
  println(maybeAa.show)

  val orders = addM(List(Order(2, 3), Order(1.5, 2), Order(3.72, 3)))
  println(orders.show)

}
