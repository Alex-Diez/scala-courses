Questions
=========

- Is the following function partially applied?

```scala
  def sumOfOdds(): (List[Int] => Int) = sum(item => item % 2 != 0)
```

- Is the next snippet example of curring `sum` function

```scala
  def sum(predicate: Int => Boolean)(list: List[Int]): Int = list.filter(predicate).sum

  def sumOf(predicate: Int => Boolean, lists: List[List[Int]]): Unit = {
    lists.foreach(sum(predicate))
  }
```

- Why the next snippet can't be compiled?

```scala
  def add(a: Int)(b: Int): Int = a + b

  def addTwo(a: Int): Int => Int = add(2)

  def map(list: List[Int])(mapper: Int => Int): List[Int] = {
    list.map(mapper)
  }

  def sum_2(list: List[Int]) = map(list)(addTwo)
```

ERROR message
```
<console>:13: error: type mismatch;
 found   : Int => Int
 required: Int
       def sum_2(list: List[Int]) = map(list)(addTwo)
```

- What the difference between `BeforeAndAfter` and `BeforeAndAfterEach` traits in `scalatest`?
- How to use `BeforeAndAfterEach` trait?