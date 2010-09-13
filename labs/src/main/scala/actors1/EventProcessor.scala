package scalatraining.actors

import se.scalablesolutions.akka.actor.Actor

// =============================
// Event processor and storage
// =============================

/**
 * Actors Lab 1: Your job is to implement the logic for the EventProcessor
 * by adding code for each of the message processing handlers:
 *   - StateChangeEvent
 *   - Replay
 *   - ReplayUpTo(date)
 */
object EventProcessor extends Actor {
  private var eventLog: List[StateChangeEvent] = Nil
  start
  
  def receive = {
    // TODO: process each event and add it to the event log

    // TODO: replay all events by iterating over the event log and invoke process on each event

    // TODO: replay all events up to a certain date,
    //       same as Replay bet you need to filter out all events older than 'date'

    case unknown =>
      log.error("Unknown event: %s", unknown);
      throw new UnsupportedOperationException("No handler for message [" + unknown + "]")
  }
}
