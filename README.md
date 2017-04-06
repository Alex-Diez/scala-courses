# Repo for learning [Scala](http://scala-lang.org)

## Other links
* [Questions that I faced and want to find answers](QUESTIONS.md)
* [What I learnt when complete particular exercise](WHAT-I-LEARNT.md)

## Phase 3

### ListMagic

```sh
$ sbt "phase_3/run-main ListMagic"
```

will print our

```sh
4 should be added in front of List(1, 2, 3) in `4 :: theList` List(4, 1, 2, 3)
4 should be added at the end of the List(1, 2, 3) in `theList :+ 4` List(1, 2, 3, 4)
4 should be prepend to List(1, 2, 3) in `4 +: theList` List(4, 1, 2, 3)
List() should throw NoSuchElementException when call head
List() should throw UnsupportedOperationException when call tail
List() should None when call optionHead
List(1, 2, 3) should have head 1
List(1, 2, 3) should have tail List(2, 3)
List(1, 2, 3) should have Some(1) when call headOption
List(1, 2, 3) should not be copied when add head. `(4 :: theList).tail eq theList` is true
List(1, 2, 3) should not be copied when prepend in front. `(4 +: theList).tail eq theList` is true
List(1, 2, 3) should be concatenated with List(4, 5, 6, 7) when call `theList ++ theOtherList`. List(1, 2, 3, 4, 5, 6, 7)
List(1, 2, 3) should be prepend to List(4, 5, 6, 7) when call `theList ::: theOtherList`. List(1, 2, 3, 4, 5, 6, 7)
List(1, 2, 3) should contain items greater than 1
List(1, 2, 3)'s items should be mapped in `theList.map(_ * 3)` List(3, 6, 9)
List(1, 2, 3)'s items less than 1 should be filtered out by (_ > 1) List(2, 3)
List(1, 2, 3) should be folded left into 16
List(1, 2, 3) should be reversed when folded left with List() as accumulator.
	theList.foldLeft(List[Int]())((acc, item) => item :: acc) == theList.reverse is true
When `zip` is called on List(1, 2, 3) with List(4, 5, 6, 7) the last item is discarded. List((1,4), (2,5), (3,6))
When `zipAll` is called on List(1, 2, 3) with List(4, 5, 6, 7) the last item is not discarded. List((1,4), (2,5), (3,6), (10,7))
The other way to get List(1, 2, 3)'s tail is to call drop(1). `theList.drop(1) eq theList.tail` is true
Items can be dropped by predicate (_ < 3) and List(1, 2, 3) become List(3)
Items can be taken from List(1, 2, 3). The list of `theList.take(1)` is List(1)
Items can be taken by predicate. List of items that greater than 3 is List(1, 2)
```

alternatively

```sh
$ scala phase_3/src/main/scala/ListMagic.scala
```

### WordCounts

```sh
$ sbt "phase_3/run-main WordsCountsMain [hash|tree]"
```

will print out

```sh
The format appears 1 time
The for appears 1 time
The s appears 1 time
The produce appears 1 time
The Use appears 1 time
The children appears 1 time
The in appears 2 times
The your appears 1 time
...
```

alternatively

```sh
$ scala phase_3/src/main/scala/WordCounts.scala [tree|hash]
```

## Phase 2

### Complex numbers

```sh
$ sbt "phase_2/run-main ComplexMain"
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
$ scala phase_2/src/main/scala/Complex.scala
```

### String collections

```sh
$ sbt "phase_2/run-main StringCollection"
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
      longLine <- new StringCollection().lineLongerThan(new FileInputStream("./phase_2/src/main/scala/StringCollection.scala"))(10)
    } println(longLine)
```

alternatively

```sh
$ scala phase_2/src/main/scala/StringCollection.scala
```

### Factorial

```sh
$ sbt "phase_2/runMain Factorial"
```

will print out

```sh
Factorial of 10 iteratively - 3628800
Factorial of 10 recursively - 3628800
```
alternatively

```sh
$ scala phase_2/src/main/scala/Factorial.scala
```

### Product of List.range(1, 100)

```sh
$ sbt "phase_2/run-main Product"
```

will print out

```sh
The product of `List.range(1, 100)` calculated iteratively using `for` 0
The product of `List.range(1, 100)` calculated iteratively using foreach 0
The product of `List.range(1, 100)` calculated recursively 0
```

alternatively

```sh
$ scala phase_2/src/main/scala/Product.scala
```

### Fibonacci

```sh
$ sbt "phase_2/run-main Fibonacci"
```

will print out

```sh
Tenth fibonacci number is 55
Tenth fibonacci number is 55
```

alternatively

```sh
$ scala phase_2/src/main/scala/Fibonacci.scala
```

## Phase 1

### Hello world

How to say `"hello world!"`

```sh
$ sbt "phase_1/run-main HelloWorld"
```

will print out

```
Hello world!
```

Alternatively

```sh
$ scala phase_1/src/main/scala/HelloWorld.scala
```

How to say `hello` to anybody

```sh
$ sbt "phase_1/run-main HelloWorld Alex Dima"
```

will print out

```
Hello Alex!
Hello Dima!
```

Alternatively

```sh
$ scala phase_1/src/main/scala/HelloWorld.scala Alex Dima
```

### Person

How to know my current age ;)

```sh
$ sbt "phase_1/run-main Person"
```

will print out something similar to

```
Alex is 26 years old
```

Alternatively

```sh
$ scala phase_1/src/main/scala/Person.scala
```

### Prime numbers

How to test default list on existing a prime number in the list

```sh
$ sbt "phase_1/run-main PrimeNumbers"
```

will print out

```
All operation will be performed on List(1, 2, 3, 4, 5)
List(1, 2, 3, 4, 5) contains at least one prime number
```

Alternatively

```sh
$ scala phase_1/src/main/scala/PrimeNumbers.scala
```

How to test specified list

```sh
$ sbt "phase_1/run-main PrimeNumbers 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
List(2, 4, 6, 9, 11) contains at least one prime number
```

Alternatively

```sh
$ scala phase_1/src/main/scala/PrimeNumbers.scala 2 4 6 9 11
```

### Odd numbers

How to test default list on existing a prime number in the list

```sh
$ sbt "phase_1/run-main OddNumbers"
```

will print out

```
All operation will be performed on List(1, 2, 3, 4, 5)
Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9
```

Alternatively

```sh
$ scala phase_1/src/main/scala/OddNumbers.scala
```

How to test specified list

```sh
$ sbt "phase_1/run-main OddNumbers 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
Sum of odds numbers in List(2, 4, 6, 9, 11) equals to 20
```

Alternatively

```sh
$ scala phase_1/src/main/scala/OddNumbers.scala 2 4 6 9 11
```
