// To test standard output
trait OddNumbersOutput {
  def println(string: String): Unit = Console.println(string)
}

object OddNumbers {

  implicit def output = new OddNumbersOutput {}

  def sumOfOdds(list: List[Int]): Int = sumOfCurried(list)(item => item % 2 != 0)

  private def sumOfCurried(list: List[Int])(predicate: Int => Boolean): Int = list.filter(predicate).sum

  def main(args: Array[String]): Unit = {
    val numbers =
      if (args.isEmpty) List(1, 2, 3, 4, 5)
      else args.toList.map(_.toInt)
    printList(numbers)
    printSumOfOdds(numbers)
  }

  def printList(list: List[Int])(implicit output: OddNumbersOutput): Unit = {
    output.println(s"All operation will be performed on $list")
  }

  def printSumOfOdds(list: List[Int])(implicit output: OddNumbersOutput): Unit = {
    val odds = sumOfOdds(list)
    output.println(s"Sum of odds numbers in $list equals to $odds")
  }
}
