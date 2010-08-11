package scalatraining.lab3

import org.scalatest.junit.JUnitSuite
import org.junit.Test

/**
 * Lab 03: some more advanced Scala collection operations
 * 
 * Scala advanced Lists
 *
 * Your job is to implement the objects and classes in
 * such a way that the tests in this suite all succeed.
 * 
 * Hint: 
 * - the methods in Lab3 can all be implemented in various ways:
 *   -- build in List functionality
 *   -- pattern matching
 *   -- 'functional' style, using recursion, and/or folds
 * - note how a List can be constructed
 */
class Lab3Test extends JUnitSuite {
  import Lab3._

  @Test
  def maxIntInList() {
    assert(25 === maxElementInList(List(1, 7, 5, 17, 25, 24, 22, 19)))
  }

  @Test
  def rewriteImperativeToFunctional() {
     //This unit test succeeds! But, the code that is called is written 'Java style',
    //it contains a lot of boilerplate code. Your job is to rewrite the code, get rid of the
    //loops and variabels, and use only functions.
    val anton1 = Person(15, "Anton1", "Jansen")
    val anton2 = Person(17, "Anton2", "Janssen")
    val anton3 = Person(18, "Anton3", "Jansssen")
    val peter1 = Person(17, "Peter1", "Peterson")
    val peter2 = Person(19, "Peter2", "Petersson")
    val jason = Person(21, "Jason", "Jasonsson")
    
    val (boys, men) = separateTheMenFromTheBoys(List(jason, anton1, anton2, anton3, peter1, peter2))
    assert(List("Anton1", "Anton2", "Peter1") === boys)
    assert(List("Anton3", "Peter2", "Jason") === men)
  }
}