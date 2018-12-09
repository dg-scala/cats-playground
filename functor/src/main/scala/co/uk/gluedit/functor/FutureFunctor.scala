package co.uk.gluedit.functor

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureFunctor {

  def go: String = {
    val f: Future[String] = Future(123)
      .map(n => n + 1)
      .map(n => n * 2)
      .map(n => n + "!")

    Await.result(f, 1 second)
  }

}
