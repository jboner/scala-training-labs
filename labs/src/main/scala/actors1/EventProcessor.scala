package scalatraining.actors

import se.scalablesolutions.akka.actor.Actor

/**
 * Actors Lab 1: Actor message handler.
 * <p/>
 * Your task is to:
 *  - create handler for the DepantureEvent message
 *  - create handler for the ArrivalEvent message
 *  - create handler for the CurrentPort message
 *  - create handler for the Reset message
 *  - run the Simulation and see the ships being killed and restarted
 */
class EventProcessor extends Actor {
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
      throw new UnsupportedOperationException("No handler for message [" + unknown + "]")
  }
}
