package scalatraining.lab6

import java.io._

/**
 * Lab 6:  Understanding Scala call-by-name by writing a ARM (Automatic Resource Management) method.
 */
object Lab6 {
  val FILE_NAME = "/Users/jboner/src/scala/scala-training-labs/solutions/src/test/resources/lab6.properties"

  /**
   * Read lines from file. Traditional way with resource cleanup etc.
   */
  def readFromFile: List[String] = {
    var stream: DataInputStream = null
    var lines = List[String]()
    try {
      stream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(FILE_NAME))))
      while (stream.available != 0) lines ::= stream.readLine
    } finally {
      stream.close
    }
    lines
  }

  /**
   * Your task is to write a ARM (Automatic Resource Management) method, that works with code like below.
   * Base it on the code in the 'readFromFile' method above.
   * <pre>
   * // This should be its AP:
   * val lines: List[String] = withInputStream(FILE_NAME) { stream =>
   *    var lines: List[String] = Nil
   *    while (stream.available != 0) lines ::= stream.readLine
   *    lines
   *  }
   * </pre>
   */
  def withDataInputStream[T](fileName: String)(body: DataInputStream => T): T = {
    val stream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(fileName))))
    try {
      body(stream)
    } finally {
      stream.close
    }
  }
}