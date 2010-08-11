package scalatraining.lab9

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 9: Learn about pattern matching and case classes.
 */
class Lab9Test extends JUnitSuite {
  import Lab9._
  @Test
  def shouldAggregateLeafValues() {
    val tree =
      Branch(
        Branch(
          Leaf("green"),
          Branch(
            Leaf("blue"),
            Leaf("red"))),
        Branch(
          Leaf("white"),
          Branch(
            Leaf("yellow"),
            Leaf("black"))))
    val allColors = aggregateLeafValues(tree)
    assert(allColors.contains("blue"))
    assert(allColors.contains("yellow"))
    assert(allColors.contains("red"))
    assert(allColors.contains("white"))
    assert(allColors.contains("black"))
    assert(allColors.contains("green"))
  }
}