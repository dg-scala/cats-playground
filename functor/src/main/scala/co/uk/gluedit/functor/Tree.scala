package co.uk.gluedit.functor

import cats.Functor


sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {

  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] = Branch(left, right)

  def leaf[A](value: A): Tree[A] = Leaf(value)

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(value) => leaf(f(value))
      case Branch(left, right) => branch(map(left)(f), map(right)(f))
    }
  }

}

/* Driver code

import cats.syntax.functor._
import co.uk.gluedit.functor._
import co.uk.gluedit.functor.Tree._

leaf(1).map(_ * 2)
branch(Leaf(1), Leaf(2)).map(_ * 2)

 */

