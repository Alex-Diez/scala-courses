# Repo for learning [Scala](http://scala-lang.org)

## Other links
* [Questions that I faced and want to find answers](QUESTIONS.md)
* [What I learnt when complete particular exercise](WHAT-I-LEARNT.md)

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

### List of numbers

How to test default list on sum of odds number and existing a prime number in the list

```sh
$ sbt "phase_one/run-main Numbers"
```

will print out

```
All operation will be performed on List(1, 2, 3, 4, 5)
List(1, 2, 3, 4, 5) contains at least one prime number
Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9
```

Alternatively

```sh
$ scala phase_one/src/main/scala/Numbers.scala
```

How to test specified list

```sh
$ sbt "phase_one/run-main Numbers 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
List(2, 4, 6, 9, 11) contains at least one prime number
Sum of odds numbers in List(2, 4, 6, 9, 11) equals to 20
```

Alternatively

```sh
$ scala phase_one/src/main/scala/Numbers.scala 2 4 6 9 11
```
