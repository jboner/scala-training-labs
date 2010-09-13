package scalatraining.actors.supervision

import java.util.Date

import se.scalablesolutions.akka.actor.Actor
import se.scalablesolutions.akka.actor.Actor.Sender.Self
import se.scalablesolutions.akka.config.ScalaConfig._

/**
 * Actors Lab 2: Supervisor hierarchies.
 * <p/>
 * Your task is to:
 *  - create the Sink and Register events
 *  - add a lifeCycle definition to the Ship
 *  - add a handler for the Sink message in Ship
 *  - add a faultHandler definition to the EventProcessor
 *  - add handler for Register(ship) message in EventProcessor
 *  - link the Ship to the EventProcessor
 *  - run the Simulation and see the ships being killed and restarted
 */
sealed trait Event

case object Reset extends Event
case object CurrentPort extends Event

case object Replay extends Event
case class ReplayUpTo(date: Date) extends Event

abstract case class StateChangeEvent(val occurred: Date) extends Event {
  val recorded = new Date
  def process: Unit
}

case class DepartureEvent(val time: Date, val port: Port, val ship: Ship) extends StateChangeEvent(time) {
  override def process = ship ! this
}

case class ArrivalEvent(val time: Date, val port: Port, val ship: Ship) extends StateChangeEvent(time) {
  override def process = ship ! this
}

class Ship(val shipName: String, val home: Port) extends Actor {
   private var current: Port = home

  def receive = {
    case ArrivalEvent(time, port, _) =>
      log.info("%s ARRIVED at port %s @ %s", toString, port, time)
      current = port

    case DepartureEvent(time, port, _) =>
      log.info("%s DEPARTED from port %s @ %s", toString, port, time)
      current = Port.AT_SEA

    case Reset =>
      log.info("%s has been reset", toString)

    case CurrentPort =>
      reply(current)

    case unknown =>
      log.error("Unknown event: %s", unknown)
  }
  
  override def toString = "Ship(" + shipName + ")"
}

case class Port(val name: String)
object Port {
  val AT_SEA = new Port("AT SEA")
}
