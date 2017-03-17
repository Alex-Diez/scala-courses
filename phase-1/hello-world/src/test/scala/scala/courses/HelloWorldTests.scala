package scala.courses

import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class HelloWorldTests extends FunSpec with Matchers with BeforeAndAfter {

  private class MockOutput extends Output {
    var messages: List[String] = List()

    override def println(message: String): Unit = messages = message :: messages
  }

  private var output: MockOutput = _
  private var hello: HelloWorld = _

  before {
    output = new MockOutput
    hello = new HelloWorld(output)
  }

  it("says hello in output") {
    hello.sayHello()

    output.messages should contain("Hello world!")
  }

  it("says hello for given name") {
    hello.sayHelloTo("Alex")

    output.messages should contain("Hello Alex!")

    hello.sayHelloTo("Dima")

    output.messages should contain("Hello Dima!")
  }

  it("says hello for list of given names") {
    hello.sayHelloTo("Alex", "Dima")

    output.messages should contain allOf ("Hello Alex!", "Hello Dima!")
  }
}
