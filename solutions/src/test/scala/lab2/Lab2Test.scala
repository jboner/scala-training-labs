package scalatraining.lab2

import org.scalatest._
import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 02: List functions
 * 
 * Scala basic Lists
 *
 * Your job is to implement the objects and classes in
 * such a way that the tests in this suite all succeed.
 * 
 * Hint: 
 * - the methods in Lab2 can all be implemented in various ways:
 *   -- build in List functionality
 *   -- pattern matching
 *   -- 'functional' style, using recursion, and/or folds
 * - note how a List can be constructed
 */
class Lab2Test extends JUnitSuite {
  val listOfStrings:List[String] = List("One", "Two", "Three")

  @Test
  def firstElementInList() {
    val result:String = Lab2.firstElementInList(listOfStrings)
    println("Found result: " + result)
    assert("One" === result)
  }

  @Test
  def lastElementInList() {
    assert("Three" === Lab2.lastElementInList(listOfStrings))
    assert(9 === Lab2.lastElementInList(List(1, 6, 10, 33, 54, 9)))
  }

  @Test
  def concatTwoLists() {
    assert(List("One", "Two", "Three", "Four", "Five") === Lab2.concatLists(listOfStrings, List("Four", "Five")))
  }

  @Test
  def listContainsOneTwoAndThree() {
    assert(Lab2.elementExists(listOfStrings, "One"))
    assert(Lab2.elementExists(listOfStrings, "Two"))
    assert(Lab2.elementExists(listOfStrings, "Three"))
  }

  @Test
  def sortListOfStrings() {
    val l = List("Scala", "Java", "Haskell", "Erlang", "Clojure", "Ruby", "Python")
    assert(List("Clojure", "Erlang", "Haskell", "Java", "Python", "Ruby", "Scala") === Lab2.sortList(l))
  }

  @Test
  def listContainsThreeOddElements() {
    assert(List(1, 3, 5) === Lab2.oddElements(List(1, 2, 3, 4, 5)))
  }
}
