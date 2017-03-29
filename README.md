# Repo for learning [Scala](http://scala-lang.org)

## Other links
* [Questions that I faced and want to find answers](QUESTIONS.md)
* [What I learnt when complete particular exercise](WHAT-I-LEARNT.md)

## Phase 2

### Complex numbers

```sh
$ sbt "phase_two/run-main Complex"
```

will print out

```sh
(10.0 + 2.0i) + (5.0 + 3.0i) = 15.0 + 5.0i
(10.0 + 2.0i) - (5.0 + 3.0i) = 5.0 + -1.0i
(10.0 + 2.0i) * (5.0 + 3.0i) = 44.0 + 40.0i
(10.0 + 2.0i) / (5.0 + 3.0i) = 1.6 + -0.6i
```

alternatively

```sh
$ scala phase_two/src/main/scala/Complex.scala
```

### String collections

```sh
$ sbt "phase_two/run-main StringCollection"
```

will print out

```sh
import java.io.{File, FileInputStream, InputStream}
import scala.io.Source
class StringCollection() {
  def lineLongerThan(stringsSource: InputStream)(size: Int):Iterator[String] = {
      line <- Source.fromInputStream(stringsSource).getLines() if line.length > size
    } yield line
object StringCollection {
  def main(args: Array[String]): Unit = {
      longLine <- new StringCollection().lineLongerThan(new FileInputStream("./phase_two/src/main/scala/StringCollection.scala"))(10)
    } println(longLine)
```

alternatively

```sh
$ scala phase_two/src/main/scala/StringCollection.scala
```

### Factorial

```sh
$ sbt "phase_two/runMain Factorial"
```

will print out

```sh
Factorial of 10 iteratively - 3628800
Factorial of 10 recursively - 3628800
```
alternatively

```sh
$ scala phase_two/src/main/scala/Factorial.scala
```

### Product of List.range(1, 100)

```sh
$ sbt "phase_two/run-main Product"
```

will print out

```sh
The product of `List.range(1, 100)` calculated iteratively using `for` 0
The product of `List.range(1, 100)` calculated iteratively using foreach 0
The product of `List.range(1, 100)` calculated recursively 0
```

alternatively

```sh
$ scala phase_two/src/main/scala/Product.scala
```

### Fibonacci

```sh
$ sbt "phase_two/run-main Fibonacci"
```

will print out

```sh
Tenth fibonacci number is 55
Tenth fibonacci number is 55
```

alternatively

```sh
$ scala phase_two/src/main/scala/Fibonacci.scala
```

## Phase 1

### Hello world

How to say `"hello world!"`

```sh
$ sbt "phase_one/run-main HelloWorld"
```

will print out

```
Hello world!
```

Alternatively

```sh
$ scala phase_one/src/main/scala/HelloWorld.scala
```

How to say `hello` to anybody

```sh
$ sbt "phase_one/run-main HelloWorld Alex Dima"
```

will print out

```
Hello Alex!
Hello Dima!
```

Alternatively

```sh
$ scala phase_one/src/main/scala/HelloWorld.scala Alex Dima
```

### Person

How to know my current age ;)

```sh
$ sbt "phase_one/run-main Person"
```

will print out something similar to

```
Alex is 26 years old
```

Alternatively

```sh
$ scala phase_one/src/main/scala/Person.scala
```

### Prime numbers

How to test default list on existing a prime number in the list

```sh
$ sbt "phase_one/run-main PrimeNumbers"
```

will print out

```
All operation will be performed on List(1, 2, 3, 4, 5)
List(1, 2, 3, 4, 5) contains at least one prime number
```

Alternatively

```sh
$ scala phase_one/src/main/scala/PrimeNumbers.scala
```

How to test specified list

```sh
$ sbt "phase_one/run-main PrimeNumbers 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
List(2, 4, 6, 9, 11) contains at least one prime number
```

Alternatively

```sh
$ scala phase_one/src/main/scala/PrimeNumbers.scala 2 4 6 9 11
```

### Odd numbers

How to test default list on existing a prime number in the list

```sh
$ sbt "phase_one/run-main OddNumbers"
```

will print out

```
All operation will be performed on List(1, 2, 3, 4, 5)
Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9
```

Alternatively

```sh
$ scala phase_one/src/main/scala/OddNumbers.scala
```

How to test specified list

```sh
$ sbt "phase_one/run-main OddNumbers 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
Sum of odds numbers in List(2, 4, 6, 9, 11) equals to 20
```

Alternatively

```sh
$ scala phase_one/src/main/scala/OddNumbers.scala 2 4 6 9 11
```
