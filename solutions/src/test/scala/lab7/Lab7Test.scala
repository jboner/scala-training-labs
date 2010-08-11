package scalatraining.lab7

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 7: Writing a tiny ship routing DSLs. Will learn implicit conversions etc.
 */
class Lab7Test extends JUnitSuite {
  import Lab7._

  @Test
  def shouldCreateRoutes() {
    val route1 = "ship1" route "port1" ==>> "port2"
    assert(route1.toString === "ship1 route port1 ==>> port2")

    val route2 = "ship2" route "port3" ==>> "port4"
    assert(route2.toString == "ship2 route port3 ==>> port4")
  }
}