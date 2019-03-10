package uk.co.gluedit

import cats.data.OptionT
import cats.instances.list._
import cats.syntax.applicative._

object MonadTExamples extends App {

  // Transformers combine from inside out! You end up with List[Option[A]]
  type ListOption[A] = OptionT[List, A]

  val result1: ListOption[Int] = OptionT(List(Option(10)))

  val result2: ListOption[Int] = 32.pure[ListOption]

  println (result1.flatMap { (x: Int) =>
    result2.map { (y: Int) =>
      x + y
    }
  })

}
