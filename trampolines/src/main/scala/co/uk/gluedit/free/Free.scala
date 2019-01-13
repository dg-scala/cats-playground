package co.uk.gluedit.free

sealed trait Free[S[+_], +A] {

  private case class FlatMap[S[+_], A, +B](
    a: Free[S, A],
    f: A => Free[S, B]
  ) extends Free[S, B]

}

case class Done[S[+_], +A](a: A) extends Free[S, A]

case class More[S[+_], +A](k: S[Free[S, A]]) extends Free[S, A]

object Free {

  type Trampoline[+A] = Free[Function0, A]

}