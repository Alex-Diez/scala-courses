# Repo for learning [Scala](http://scala-lang.org)

## Other links
* [Questions that I faced and want to find answers](QUESTION.md)
* [What I learnt when complete particular exercise](WHAT-I-LEARNT.md)

## Phase 1

### Hello world

How to say `"hello world!"`

```sh
$ cd phase-1/hello-world/
$ sbt run
```

will print out

```
Hello world!
```

How to say `hello` to anybody

```sh
$ cd phase-1/hello-world/
$ sbt "run Alex Dima"
```

will print out

```
Hello Alex!
Hello Dima!
```

### Person

How to know my current age ;)

```sh
$ cd phase-1/person/
$ sbt run
```

will print out something similar to

```
Alex is 26 years old
```

### List of numbers

How to test default list on sum of odds number and existing a prime number in the list

```sh
$ cd phase-1/list-of-numbers/
$ sbt run
```

will print out

```
You haven't provided a list. All operation will be performed on default list, which is List(1, 2, 3, 4, 5)
List(1, 2, 3, 4, 5) contains at least one prime number
Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9
```

How to test specified list

```sh
$ cd phase-1/list-of-numbers/
$ sbt "run 2 4 6 9 11"
```

will print out

```
All operation will be performed on List(2, 4, 6, 9, 11)
List(2, 4, 6, 9, 11) contains at least one prime number
Sum of odds numbers in List(2, 4, 6, 9, 11) equals to 20
```
