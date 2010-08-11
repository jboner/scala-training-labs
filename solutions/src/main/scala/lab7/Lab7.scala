package scalatraining.lab7

/**
 * Lab 7: Writing a tiny ship routing DSLs. Will learn implicit conversions etc.
 */
object Lab7 {
  implicit def stringToShip(name: String) = new Ship(name)
  implicit def stringToRoute(from: String) = new Route(from)

  class Ship(val name: String) {
    def route(route: Route) = {
      route.ship = this
      route
    }
  }

  class Route(val from: String) {
    var to: String = _
    var ship: Ship = _
    def ==>>(to: String): Route = {
      this.to = to
      this
    }

    override def toString() = ship.name + " route " + from + " ==>> " + to
  }
}

