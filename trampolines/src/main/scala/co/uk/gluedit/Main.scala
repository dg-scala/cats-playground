package co.uk.gluedit

import co.uk.gluedit.examples.OddsAndEvens._

object Main extends App {

  println("1 .. 100000001 is " + (if (even((1 to 100000001).toList).runT) "even" else "odd"))

}
