package scalatraining.actors.remote

import java.util.Date

import se.scalablesolutions.akka.actor.{Actor, ActorRef}
import se.scalablesolutions.akka.config.ScalaConfig._

/**
 * Actors Lab 3: Remote actors.
 * <p/>
 * Your task is to:
 *  - make the Event base trait @serializable
 *  - add handler for the NewShip(name, port) message in the Ship which will set the name and port
 *  - start a RemoteServer in the EventProcessor
 *  - add handler for the NewShip(name, port) message in the EventProcessor, which should:
 *    - create the Ship on a remote host (localhost is fine)
 *    - link the Ship to the EventProcessor
 *    - pass on the NewShip event to the newly created Ship
 *    - reply with the newly created Ship
 *  - run the Simulation and see the transparent management of the remote ship
 */
@serializable sealed trait Event

case object CurrentPort extends Event

case object Replay extends Event
case class ReplayUpTo(date: Date) extends Event

case object Sink extends Event

abstract case class StateChangeEvent(val occurred: Date) extends Event {
  val recorded = new Date
  def process: Unit
}

case class DepartureEvent(val time: Date, val port: Port, val ship: ActorRef) extends StateChangeEvent(time) {
  override def process = ship ! DepartureEvent(time, port, null)
}

case class ArrivalEvent(val time: Date, val port: Port, val ship: ActorRef) extends StateChangeEvent(time) {
  override def process = ship ! ArrivalEvent(time, port, null)
}

// =============================
// Define the Ship
// =============================

class Ship extends Actor {

  private var shipName: String = _
  private var currentDestination: Port = _

  def receive = {
    case ArrivalEvent(time, port, _) =>
      log.info("%s ARRIVED at port %s @ %s", toString, port, time)
      currentDestination = port

    case DepartureEvent(time, port, _) =>
      log.info("%s DEPARTED from port %s @ %s", toString, port, time)
      currentDestination = Port.AT_SEA

    case CurrentPort =>
      self.reply(currentDestination)

    case Sink =>
      throw new RuntimeException("I'm killed: " + this)

    case unknown =>
      log.error("Unknown event: %s", unknown)
  }
  
  override def toString = "Ship(" + shipName + ")"
}

case class Port(val name: String)
object Port {
  val AT_SEA = new Port("AT SEA")
}

