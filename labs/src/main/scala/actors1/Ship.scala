package scalatraining.actors

import se.scalablesolutions.akka.actor.Actor
import se.scalablesolutions.akka.actor.Actor.Sender.Self

import java.util.Date

// =============================
// Define the events
// =============================

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
