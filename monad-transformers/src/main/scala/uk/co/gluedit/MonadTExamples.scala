package uk.co.gluedit

import cats.data.{EitherT, OptionT}
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

  type ErrorOr[A] = Either[String, A]
  type ErrorOrOption[A] = OptionT[ErrorOr, A]

  import cats.instances.either._

  val a = 10.pure[ErrorOrOption]
  val b = 32.pure[ErrorOrOption]
  val c = a.flatMap(x => b.map(y => x + y))
  val d = for {
    x <- a
    y <- b
  } yield x + y

  println(s"c = $c, d = $d, c == d = ${c == d}")

  // Mind-buster, combining 3 or more monads
  import scala.concurrent.Future
  import cats.data.{EitherT, OptionT}

  type FutureEither[A] = EitherT[Future, String, A]
  type FutureEitherOption[A] = OptionT[FutureEither, A]

  import cats.instances.future._ // for Monad
  import scala.concurrent.Await
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  val futureEitherOr: FutureEitherOption[Int] =
    for {
      a <- 10.pure[FutureEitherOption]
      b <- 32.pure[FutureEitherOption]
    } yield a + b

//  val intermediate = futureEitherOr.value
//  val stack = intermediate.value
  println(s"Result is ${Await.result(futureEitherOr.value.value, 1 second)}")
}
