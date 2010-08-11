package scalatraining.lab1

object Lab1 {
  class HelloWorld 

  object HelloWorld extends HelloWorld

  trait HelloTrait

  trait WorldTrait

  class ComposedHelloWorld extends HelloTrait with WorldTrait

  object GenericHello

  class GenericHello(val name: String)
}

