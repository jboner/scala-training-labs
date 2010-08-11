package scalatraining.lab4

import scala.xml.Elem

/**
 * Lab 4: Work with XML - matching (XPath)
 * <p/>
 * All these methods should extract information from the following XML document:
 * <pre>
 *  <training type="scala">
 *    <name>Introduction to Scala</name>
 *    <teacher>Jonas Boner</teacher>
 *    <attendees>
 *      <attendee>Bill</attendee>
 *      <attendee>Bob</attendee>
 *      <attendee>Lucy</attendee>
 *      <attendee>John</attendee>
 *      <attendee>Anna</attendee>
 *      <attendee>Stu</attendee>
 *    </attendees>
 *  </training>
 * </pre>
 */
object Lab4 {
  
  def getTrainingTypeFromDocument(document: Elem): String = { error("fix me") }

  def getTrainingNameFromDocument(document: Elem): String = { error("fix me") }

  def getTeacherFromDocument(document: Elem): String = { error("fix me") }

  def getAttendeesFromDocument(document: Elem): List[String] = { error("fix me") }
}
