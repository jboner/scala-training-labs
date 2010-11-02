package scalatraining.lab4

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 4: Work with XML - matching (XPath)
 */
class Lab4Test extends JUnitSuite {
  import Lab4._

  val training =
    <training type="scala">
      <name>Introduction to Scala</name>
      <teacher>Jonas Boner</teacher>
      <attendees>
        <attendee>Bill</attendee>
        <attendee>Bob</attendee>
        <attendee>Lucy</attendee>
        <attendee>John</attendee>
        <attendee>Anna</attendee>
        <attendee>Stu</attendee>
      </attendees>
    </training>
  val attendees = List("Bill", "Bob", "Lucy", "John", "Anna", "Stu")

  @Test def shouldDoNothing = assert(true)
/*
  @Test
  def shouldGetTrainingTypeFromDocument() {
    assert("scala" === getTrainingTypeFromDocument(training))
  }

  @Test
  def shouldGetTrainingNameFromDocument() {
    assert("Introduction to Scala" === getTrainingNameFromDocument(training))
  }

  @Test
  def shouldGetTeacherFromDocument() {
    assert("Jonas Boner" === getTeacherFromDocument(training))
  }

  @Test
  def shouldGetAttendeesFromDocument() {
    println("---------- " + getAttendeesFromDocument(training))
    println("---------- " + getAttendeesFromDocument(training).zip(attendees)) 
    assert(getAttendeesFromDocument(training).size === attendees.size)
    assert(getAttendeesFromDocument(training).zip(attendees).find(t => t._1 != t._2).isEmpty)
  }
*/
}