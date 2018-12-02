package uk.co.gluedit.monosemi

import cats._
import cats.implicits._

object SuperAdder {

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)

  // context-bound A, restricting it to Monoid subclasses
  def addM[A: Monoid](items: List[A]): A = items.foldLeft(Monoid[A].empty)(_ |+| _)

}
