package scalatraining.lab5

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 5: Work with XML - templating, generating XML
 */
class Lab5Test extends JUnitSuite {
  import Lab5._

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
  def shouldGenerateTrainingDocumentFromAttendeeList() {
    val document = generateTrainingDocumentFrom("scala", "Introduction to Scala", "Jonas Boner", attendees)
    assert((document \ "@type").text === "scala")
    assert((document \ "name").text === "Introduction to Scala")
    assert((document \ "teacher").text === "Jonas Boner")
    val myAttendees = for (attendee <- (document \\ "attendee")) yield attendee.text
    assert(myAttendees.toList.zip(attendees).find(t => t._1 != t._2).isEmpty)
  }
*/
}