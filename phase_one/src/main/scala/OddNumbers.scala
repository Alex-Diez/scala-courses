// To test standard output
trait OddNumbersOutput {
  def println(string: String): Unit = Console.println(string)
}

object OddNumbers {

  implicit def output = new OddNumbersOutput {}

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
    val odds = sumOfOddsWithFunctor(list)
    output.println(s"Sum of odds numbers in $list equals to $odds")
  }
}
