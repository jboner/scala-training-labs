package scalatraining.actors.supervision

import se.scalablesolutions.akka.actor.Actor
import se.scalablesolutions.akka.config.OneForOneStrategy
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
object EventProcessor extends Actor {
  private var eventLog: List[StateChangeEvent] = Nil

  def receive = {
    case event: StateChangeEvent =>
      event.process
      eventLog ::= event

    case Replay =>
      eventLog.reverse.foreach(_.process)

    case ReplayUpTo(date) =>
      eventLog.reverse.filter(_.occurred.getTime <= date.getTime).foreach(_.process)

    case unknown =>
      log.error("Unknown event: %s", unknown)
  }
}
