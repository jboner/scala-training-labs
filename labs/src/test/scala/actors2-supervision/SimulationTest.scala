package scalatraining.actors.supervision

import java.util.Date

import se.scalablesolutions.akka.actor.Actor._
import se.scalablesolutions.akka.actor.ActorRef

import org.scalatest.junit.JUnitSuite
import org.junit.{After, Before, Test}

class SimulationTest extends JUnitSuite {
  val eventProcessor = actorOf[EventProcessor].start
  val portSFO = new Port("San Francisco")
  val portLA = new Port("Los Angeles")
  val portYYV = new Port("Vancouver")
  val shipKR = actorOf(new Ship("King Roy", portYYV)).start
//  eventProcessor ! Register(shipKR)

  @Test def shouldDoNothing = assert(true)
/*
  @Test def runSimulation = {
    println("\n===> arrivalSetsShipsLocation")

    eventProcessor ! DepartureEvent(new Date(2009, 2, 1), portSFO, shipKR)
    Thread.sleep(500)

    eventProcessor ! ArrivalEvent(new Date(2009, 2, 3), portSFO, shipKR)
    Thread.sleep(500)

    assert(portSFO === (shipKR !! CurrentPort).get)

    println("\n===> departurePutsShipOutToSea")

// ------- NEW -------
    shipKR ! Sink
// ------- NEW -------

    eventProcessor ! DepartureEvent(new Date(2009, 2, 4), portLA, shipKR)
    Thread.sleep(1000)

    println("\n===> smallTrip")

    eventProcessor ! ArrivalEvent(new Date(2009, 2, 5), portLA, shipKR)
    Thread.sleep(500)

    eventProcessor ! DepartureEvent(new Date(2009, 2, 6), portYYV, shipKR)
    Thread.sleep(500)

    eventProcessor ! ArrivalEvent(new Date(2009, 2, 8), portYYV, shipKR)
    Thread.sleep(500)

    eventProcessor ! DepartureEvent(new Date(2009, 2, 9), portSFO, shipKR)
    Thread.sleep(500)

    eventProcessor ! ArrivalEvent(new Date(2009, 2, 11), portSFO, shipKR)
    Thread.sleep(500)

    assert(portSFO === (shipKR !! CurrentPort).get)

    println("\n===> resetAndReplayEventLog")

    eventProcessor ! Replay
    Thread.sleep(500)

    assert(portSFO === (shipKR !! CurrentPort).get)

    println("\n===> resetAndReplayEventLogUpToDate")

    eventProcessor ! ReplayUpTo(new Date(2009, 2, 4))
    Thread.sleep(500)

    assert(Port.AT_SEA === (shipKR !! CurrentPort).get)
  }
*/
}
