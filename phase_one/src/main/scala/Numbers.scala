// To test standard output
trait NumbersOutput {
  def println(string: String): Unit = Console.println(string)
}

object Numbers {

  implicit def output = new NumbersOutput {}

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
      if (args.isEmpty) List(1, 2, 3, 4, 5)
      else args.toList.map(_.toInt)
    printList(numbers)
    printContainsPrime(numbers)
    printSumOfOdds(numbers)
  }

  def printList(list: List[Int])(implicit output: NumbersOutput): Unit = {
      output.println(s"All operation will be performed on $list")
  }

  def printContainsPrime(list: List[Int])(implicit output: NumbersOutput): Unit = {
    if (containsPrime(list))
      output.println(s"$list contains at least one prime number")
    else
      output.println(s"$list does not contain a prime number")
  }

  def printSumOfOdds(list: List[Int])(implicit output: NumbersOutput): Unit = {
    val odds = sumOfOdds(list)
    output.println(s"Sum of odds numbers in $list equals to $odds")
  }
}
