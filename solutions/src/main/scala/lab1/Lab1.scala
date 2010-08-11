package scalatraining.lab1

object Lab1 {
  class HelloWorld {
    def sayHelloWorld = "Hello World"
  }

  object HelloWorld extends HelloWorld {
    def echo(s: String) = s
  }

  trait HelloTrait {
    def sayHello = "Hello"
  }

  trait WorldTrait {
    def sayWorld = "World"
  }

  class ComposedHelloWorld extends HelloTrait with WorldTrait {
    def sayHelloWorld = sayHello + " " + sayWorld
  }

  object GenericHello {
    def apply(name: String) = new GenericHello(name)
  }

  class GenericHello(val name: String) {
    def sayHello: String = "Hello " + name
  }
}

