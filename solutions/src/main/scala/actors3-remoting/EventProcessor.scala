package scalatraining.actors.remote

import se.scalablesolutions.akka.actor.Actor
import se.scalablesolutions.akka.config.OneForOneStrategy
import se.scalablesolutions.akka.config.ScalaConfig._
import se.scalablesolutions.akka.remote.RemoteNode

/**
 * Actors Lab 3: Remote actors.
 * <p/>
 * Your task is to:
 *  - make the Event base trait @serializable
 *  - add handler for the NewShip(name, port) message in the Ship which will set the name and port
 *  - remove the constructor in Ship
 *  - start a RemoteServer in the EventProcessor
 *  - add handler for the NewShip(name, port) message in the EventProcessor, which should:
 *    - create the Ship on a remote host (localhost is fine)
 *    - link the Ship to the EventProcessor
 *    - pass on the NewShip event to the newly created Ship
 *    - reply with the newly created Ship
 *  - run the Simulation and see the transparent management of the remote ship
 */
class EventProcessor extends Actor {
  self.faultHandler = Some(OneForOneStrategy(5, 5000))
  self.trapExit = List(classOf[Throwable])
  
// ------- NEW -------
  RemoteNode.start("localhost", 9999)
// ------- NEW -------

  private var eventLog: List[StateChangeEvent] = Nil

  def receive: PartialFunction[Any, Unit] = {
    case event: StateChangeEvent =>
      event.process
      eventLog ::= event

    case Replay =>
      eventLog.reverse.foreach(_.process)

    case ReplayUpTo(date) =>
      eventLog.reverse.filter(_.occurred.getTime <= date.getTime).foreach(_.process)

// ------- NEW -------
    case newShip @ NewShip(_,_) =>
      val ship = self.spawnLinkRemote[Ship]("localhost", 9999)
      ship ! newShip
      self.reply(ship)
// ------- NEW -------
            
    case unknown =>
      log.error("Unknown event: %s", unknown)
  }
}
