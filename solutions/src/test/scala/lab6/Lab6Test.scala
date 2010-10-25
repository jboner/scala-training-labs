package scalatraining.lab6

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 6: Understanding Scala call-by-name by writing a ARM (Automatic Resource Management) method.
 */
class Lab6Test extends JUnitSuite {
  import Lab6._

  @Test
  def shouldReadFromFile() {
    assert(readFromFile.reverse === List("one=1","two=2","three=3","four=4","five=5"))
  }

  @Test
  def shouldReadFromFileUsingARM() {
    val lines: List[String] = withDataInputStream(FILE_NAME) { stream =>
      var lines: List[String] = Nil
      var line = stream.readLine
      while(line ne null) {
        lines ::= line
        line = stream.readLine
      }
      lines
    }
    assert(lines.reverse === List("one=1","two=2","three=3","four=4","five=5"))
  }
}