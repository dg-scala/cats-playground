package uk.co.gluedit.functor

import cats.instances.function._
import cats.syntax.functor._

object FunctionFunctor {

  val f1: Int => Double = _.toDouble

  val f2: Double => Double = _ * 2

  def mapsy: Int => Double = f1 map f2

  def andThensy: Int => Double = f1 andThen f2

  def composy: Int => Double = f2 compose f1

}
