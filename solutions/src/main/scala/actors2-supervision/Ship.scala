package scalatraining.actors.supervision

import java.util.Date

import se.scalablesolutions.akka.actor.{Actor, ActorRef}

import se.scalablesolutions.akka.config.ScalaConfig._

/**
 * Actors Lab 2: Supervisor hierarchies.
 * <p/>
 * Your task is to:
 *  - create the Sink and Register events
 *  - add a lifeCycleConfig definition to the Ship
 *  - add a handler for the Sink message in Ship
 *  - add a faultHandler definition to the EventProcessor
 *  - add handler for Register(ship) message in EventProcessor
 *  - link the Ship to the EventProcessor
 *  - run the Simulation and see the ships being killed and restarted
 */
sealed trait Event

case object CurrentPort extends Event

case object Replay extends Event
case class ReplayUpTo(date: Date) extends Event

// ------- NEW -------
case class Register(ship: ActorRef) extends Event
case object Sink extends Event
// ------- NEW -------

abstract case class StateChangeEvent(val occurred: Date) extends Event {
  val recorded = new Date

  def process: Unit
}

case class DepartureEvent(val time: Date, val port: Port, val ship: ActorRef) extends StateChangeEvent(time) {
  override def process = ship ! this
}

case class ArrivalEvent(val time: Date, val port: Port, val ship: ActorRef) extends StateChangeEvent(time) {
  override def process = ship ! this
}

// =============================
// Define the Ship
// =============================

class Ship(val shipName: String, val home: Port) extends Actor {
   private var current: Port = home

  def receive = {
    case ArrivalEvent(time, port, _) =>
      log.info("%s ARRIVED at port %s @ %s", toString, port, time)
      current = port

    case DepartureEvent(time, port, _) =>
      log.info("%s DEPARTED from port %s @ %s", toString, port, time)
      current = Port.AT_SEA

    case CurrentPort =>
      self.reply(current)

// ------- NEW -------
    case Sink =>
      throw new RuntimeException("I'm killed: " + this)
// ------- NEW -------

    case unknown =>
      log.error("Unknown event: %s", unknown)
  }
  
  override def toString = "Ship(" + shipName + ")"
}

case class Port(val name: String)
object Port {
  val AT_SEA = new Port("AT SEA")
}
