package scala.courses

class HelloWorld(output: Output) {
  def sayHelloTo(names: String*): Unit =
    names.foreach(name => output.println(s"Hello $name!"))

  def sayHello(): Unit = output.println("Hello world!")
}

trait Output {
  def println(message: String): Unit = Console.println(message)
}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val helloWorld = new HelloWorld(new Output {})
    if (!args.isEmpty) helloWorld.sayHelloTo(args: _*)
    else helloWorld.sayHello()
  }
}
