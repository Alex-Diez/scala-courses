package scala.courses

trait Output {
  def println(string: String): Unit = Console.println(string)
}

class Numbers private(val output: Output, val list: List[Int], val default: Boolean) {

  def this()(implicit output: Output) {
    this(output, List(1, 2, 3, 4, 5), true)
  }

  def this(list: List[Int])(implicit output: Output) {
    this(output, list, false)
  }

  def printList(): Unit = {
    if (default)
      output.println(s"You haven't provided a list. All operation will be performed on default list, which is $list")
    else
      output.println(s"All operation will be performed on $list")
  }

  def printSumOfOdds(): Unit = {
    val odds = Numbers.sumOfOdds(list)
    output.println(s"Sum of odds numbers in $list equals to $odds")
  }

  def printContainsPrime(): Unit = {
    if (Numbers.containsPrime(list))
      output.println(s"$list contains at least one prime number")
    else
      output.println(s"$list does not contain a prime number")
  }
}

object Numbers {
  implicit def output = new Output {}

  def sum(): (List[Int]) => ((Int) => Boolean) => Int =
    (list: List[Int]) => (predicate: Int => Boolean) => list.filter(predicate).sum

  def sumOf(list: List[Int]): (Int => Boolean) => Int = sum()(list)

  def sumOfOdds(list: List[Int]): Int = sumOf(list)(item => item % 2 != 0)

  def containsPrime(list: List[Int]): Boolean = list.exists(isPrime)

  def isPrime(number: Int): Boolean = {
    def end() = Math.sqrt(number).toInt + 1

    !(2 until end).exists(number % _ == 0)
  }

  def main(args: Array[String]): Unit = {
    val numbers =
      if (args.isEmpty) new Numbers()
      else new Numbers(args.toList.map(_.toInt))
    numbers.printList()
    numbers.printContainsPrime()
    numbers.printSumOfOdds()
  }
}
