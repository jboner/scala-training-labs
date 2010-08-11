package scalatraining.lab5

import scala.xml.Elem

/**
 * Lab 5: Work with XML - templating, generating XML
 */
object Lab5 {

  /**
   * Should generate the following XML document:
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
  def generateTrainingDocumentFrom(trainingType: String,
                                   trainingName: String,
                                   teacher: String,
                                   attendees: List[String]): Elem = {
    <training type={trainingType}>
      <name>{trainingName}</name>
      <teacher>{teacher}</teacher>
      <attendees>
        { for (attendee <- attendees) yield <attendee>{attendee}</attendee> }
      </attendees>
    </training>
  }
}