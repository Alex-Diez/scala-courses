# What I learnt from each exercise

* DO NOT TRUST IDE ... sometimes code can't be compile; however, ide shows that everything is ok

## Hello world

* How to test output stream of your program

your source:
```scala
trait Output {
  def println(message: String): Unit = Console.println(message)
}

class HelloWorld(output: Output) {
  def sayHello(): Unit = output.println("Hello world!")
}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    new HelloWorld(new Output {}).sayHello()
  }
}
```

your tests:
```scala
class HelloWorldTests extends FunSpec with Matchers {
  private class MockOutput extends Output {
    var messages: List[String] = List()

    override def println(message: String): Unit = messages = message :: messages
  }

  it("says hello in output") {
    val output = new MockOutput
    val hello = new HelloWorld(output)

    hello.sayHello()

    output.messages should contain("Hello world!")
  }
}
```

## Person

* One of example how I can use implicit parameters

your source:
```scala
class Person(name: String, val dayOfBirth: LocalDate) {
  override def toString: String = name
}

object Person {
  implicit def clock: Clock = Clock.systemUTC()
  implicit def output: Output = new Output {}

  def age(person: Person)(implicit clock: Clock): Int = {
    val currentDate = LocalDateTime.ofInstant(clock.instant(), ZoneOffset.UTC)
    if (currentDate.getDayOfYear < person.dayOfBirth.getDayOfYear)
      currentDate.getYear - person.dayOfBirth.getYear - 1
    else
      currentDate.getYear - person.dayOfBirth.getYear
  }

  def printInfo(person: Person)(implicit clock: Clock, output: Output):Unit = {
    val age = Person.age(person)(clock)
    output.println(s"$person is $age years old")
  }

  def main(args: Array[String]): Unit = {
    Person.printInfo(new Person("Alex", LocalDate.of(1990, 10, 23)))
  }
}
```

Notice that you don't need to specify `clock` and `output` for `printInfo` in main function. Compiler will put `implicit def clock: Clock = Clock.systemUTC()` and `implicit def output: Output = new Output {}`

## List of numbers

* How to return anonymous function:

```scala
def sum(): (List[Int]) => ((Int) => Boolean) => Int =
    (list: List[Int]) => (predicate: Int => Boolean) => list.filter(predicate).sum
```

Notice that you need to use `=>` instead of `:` to specify what type anonymous function returns
