package uk.co.gluedit

object FunctorApp extends App {

  // Futures
  import co.uk.gluedit.functor.FutureFunctor._

  println(go)

  // Functions
  import co.uk.gluedit.functor.FunctionFunctor._

  println(mapsy(1))
  println(andThensy(1))
  println(composy(1))

}
