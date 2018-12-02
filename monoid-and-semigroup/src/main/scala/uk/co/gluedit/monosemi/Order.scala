package uk.co.gluedit.monosemi

import cats.{Monoid, Show}

case class Order(totalCost: Double, quantity: Double)

object Order {

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def empty: Order = Order(0, 0)

    override def combine(x: Order, y: Order): Order =
      Order(
        x.totalCost + y.totalCost,
        x.quantity + y.quantity
      )
  }

  implicit val orderShow: Show[Order] = Show.show(o => s"Order(${o.totalCost - o.totalCost % 0.01}, ${o.quantity.toInt})")

}