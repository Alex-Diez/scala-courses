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

## Curring, Partially application, Functor

* Next three examples how to accomplish calculation of odd numbers in a list

```scala
  //using curring methods
  //=============
  def sumOfOddsCurried(list: List[Int]): Int = sumOfCurried(list)(item => item % 2 != 0)

  private def sumOfCurried(list: List[Int])(predicate: Int => Boolean): Int = list.filter(predicate).sum
  //=============

  //using partially applied method
  //============
  def sumOfOddsPartial(list: List[Int]): Int = sumOfPartialApplied(list)(item => item % 2 != 0)

  private def sumOfPartialApplied(list: List[Int]): (Int => Boolean) => Int = sumOfPartial(list: List[Int], _: Int => Boolean)

  private def sumOfPartial(list: List[Int], predicate: Int => Boolean):Int = list.filter(predicate).sum
  //============

  //using Functor
  //=============
  def sumOfOddsWithFunctor(list: List[Int]): Int = sumOfWithFunctor(list)(item => item % 2 != 0)

  private def sumOfWithFunctor(list: List[Int]): (Int => Boolean) => Int = sumWithFunctor()(list)

  private def sumWithFunctor(): (List[Int]) => ((Int) => Boolean) => Int =
    (list: List[Int]) => (predicate: Int => Boolean) => list.filter(predicate).sum
  //=============
```

## Case classes

* Case class is much more than just a class ...
* scalac will:
  1. generate companion object with `apply` method
  2. make all constructor parameters `val`
  3. generate `unapply` function that will be used in pattern matching

```scala
case class CaseComplex(real: Double, imaginary: Double) {

  def +(that: CaseComplex): CaseComplex = CaseComplex(real + that.real, imaginary + that.imaginary)

  def +(i: Int): CaseComplex = copy(real = real + i)

  override def toString: String = this match {
    case CaseComplex(_, 0) => s"$real"
    case CaseComplex(0, img) => s"${img}i"
    case CaseComplex(_, img) if img < 0 => s"$real - ${math.abs(img)}i"
    case CaseComplex(_, img) => f"$real + ${img}i"
  }
}

object CaseComplex {
  def apply(real: Int): CaseComplex = new CaseComplex(real, 0)
}
```

## Implicit function: Second part

Import implicit function to help compile find them

source class
```scala
import scala.math.BigInt._ //to import implicit function of conversion Int into BigInt

class Factorial(private val n: BigInt) {

  def iteratively: BigInt = {
    var factorial: BigInt = 1 //factorial has type BigInt. Therefore, implicit {BigInt#int2bigInt(i: Int): BigInt} will be called on `1`
    for (i <- 1 to n) //create range with type of Range.BigInt. implicit BigInt#int2bigInt(i: Int): BigInt will be called on `1`
      factorial *= i
    factorial
  }
}
```

Note that you need declare `factorial` type, another way compile would not infer it

test class
```scala
class FactorialTest extends FlatSpec with Matchers {

  it should "calculate factorial of 0" in {
    new Factorial(0).iteratively shouldBe 1
  }

  it should "calculate factorial of 1" in {
    new Factorial(1).iteratively shouldBe 1
  }

  it should "calculate factorial of 2" in {
    new Factorial(2).iteratively shouldBe 2
  }

  it should "calculate factorial of 3" in {
    new Factorial(3).iteratively shouldBe 6
  }

  it should "calculate factorial of 6" in {
    new Factorial(6).iteratively shouldBe 1 * 2 * 3 * 4 * 5 * 6
  }
}
```

Note that you don't need to import `BigInt` to help compile to find `implicit` function to convert Int into BigInt

## Iteration over `List` with tail recursive approach

```scala
def recursivePatternMatch(list: List[Int]): Int = {
    @tailrec
    def loop(n: Int, items: List[Int]): Int = items match {
        case (item :: rest) => loop(n * item, rest)
        case Nil => n
    }

    loop(1, list)
}

def recursiveHeadPatternMatch(list: List[Int]): Int = {
    @tailrec
    def loop(n: Int, items: List[Int]): Int = items.headOption match {
        case Some(item) => loop(item * n, items.tail)
        case None => n
    }

    loop(1, list)
}
```
