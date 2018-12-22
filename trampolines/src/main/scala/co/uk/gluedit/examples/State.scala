package co.uk.gluedit.examples

import co.uk.gluedit.trampoline.{More, Trampoline}

case class State[S, +A](runS: S => Trampoline[(A, S)]) {

  def map[B](f: A => B) = State[S, B](s => {
    val (a, s1) = runS(s).runT
    (f(a), s1)
  })

  def flatMap[B](f: A => State[S, B]) = State[S, B](
    s => More(() => runS(s) flatMap {
      case (a, s1) => More(() => f(a) runS s1)
    })
  )

}
