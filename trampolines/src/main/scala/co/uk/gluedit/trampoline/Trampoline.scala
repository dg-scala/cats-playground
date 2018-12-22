package co.uk.gluedit.trampoline

sealed trait Trampoline[+A] {

  final def resume: Either[() => Trampoline[A], A] = this match {
    case Done(v) => Right(v)
    case More(k) => Left(k)
    case FlatMap(a, f) => a match {
      case Done(v) => f(v).resume
      case More(k) => Left(() => FlatMap(k(), f))
      case FlatMap(b, g) => (FlatMap(b, (x: Any) => FlatMap(g(x), f)): Trampoline[A]).resume
    }
  }

  final def runT: A = resume match {
    case Right(a) => a
    case Left(k) => k().runT
  }

  def flatMap[B](f: A => Trampoline[B]): Trampoline[B] = ???

}

case class More[+A](k: () => Trampoline[A]) extends Trampoline[A]

case class Done[+A](result: A) extends Trampoline[A]

case class FlatMap[A, +B](sub: Trampoline[A], k: A => Trampoline[B]) extends Trampoline[B]
