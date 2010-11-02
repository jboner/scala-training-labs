package scalatraining.lab1

import org.scalatest._
import org.scalatest.junit.JUnitSuite
import org.junit.Assert._
import org.junit.Test

/**
 * Lab 01: Beginner Hello World:
 * 
 * You will learn about:
 *  - classes
 *  - objects
 *  - traits
 *  - methods
 *  - parameters
 *  - companion objects
 *  - apply methods
 *
 * Your job is to implement the objects and classes in
 * such a way that the tests in this suite all succeed.
 */
class Lab1Test extends JUnitSuite {
  import Lab1._

  @Test def shouldDoNothing = assert(true)

/*
  @Test
  def shouldSayHelloFromClass() {
    val helloWorld = new HelloWorld
    assert("Hello World" === helloWorld.sayHelloWorld)
  }

  @Test
  def shouldSayHelloFromObject() {
    assert("Hello World" === HelloWorld.sayHelloWorld)
  }

  @Test
  def shouldEcho() {
    assert("Echo" === HelloWorld.echo("Echo"))
  }

  @Test
  def shouldSayHelloFromTrait() {
    val composedHelloWorld = new ComposedHelloWorld
    assert(composedHelloWorld.isInstanceOf[HelloTrait])
    assert(composedHelloWorld.isInstanceOf[WorldTrait])
    assert("Hello" === composedHelloWorld.sayHello)
    assert("World" === composedHelloWorld.sayWorld)
    assert("Hello World" === composedHelloWorld.sayHelloWorld)
  }

  @Test
  def shouldSayHelloFromObjectWithApplyMethod() {
    val helloSweden = GenericHello("Sweden")
    assert("Hello Sweden" === helloSweden.sayHello)

    val helloNorway = GenericHello("Norway")
    assert("Hello Norway" === helloNorway.sayHello)
  }
*/
}
