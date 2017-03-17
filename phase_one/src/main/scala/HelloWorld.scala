class HelloWorld(output: HelloWorldOutput) {
  def sayHelloTo(names: String*): Unit =
    names.foreach(name => output.println(s"Hello $name!"))

  def sayHello(): Unit = output.println("Hello world!")
}

// To test standard output
trait HelloWorldOutput {
  def println(message: String): Unit = Console.println(message)
}

object HelloWorld {

  def main(args: Array[String]): Unit = {
    val helloWorld = new HelloWorld(new HelloWorldOutput {})
    if (!args.isEmpty) helloWorld.sayHelloTo(args: _*)
    else helloWorld.sayHello()
  }
}