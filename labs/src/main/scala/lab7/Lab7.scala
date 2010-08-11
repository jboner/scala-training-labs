package scalatraining.lab7

/**
 * Lab 7: Writing a tiny ship routing DSLs. Will learn implicit conversions etc.
 * <p/>
 * Your task is to use the two implicit conversions and the skeleton Ship and Route classes to
 * create a DSL like this:
 * <pre>
 * val aRoute = "myShip" route "port1" ==>> "port2"
 * </pre>
 */
object Lab7 {
  implicit def stringToShip(name: String) = {
    // Fill me in
  }

  implicit def stringToRoute(from: String) = {
    // Fill me in
  }

  class Ship(val name: String) {
    // Fill me in
  }

  class Route(val from: String) {
    // Fill me in

    var to: String = _
    var ship: Ship = _
    override def toString() = ship.name + " route " + from + " ==>> " + to
  }
}

