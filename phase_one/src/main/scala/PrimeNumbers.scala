// To test standard output
trait PrimeNumbersOutput {
  def println(string: String): Unit = Console.println(string)
}

object PrimeNumbers {

  implicit def output = new PrimeNumbersOutput {}

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
  }

  def printList(list: List[Int])(implicit output: PrimeNumbersOutput): Unit = {
      output.println(s"All operation will be performed on $list")
  }

  def printContainsPrime(list: List[Int])(implicit output: PrimeNumbersOutput): Unit = {
    if (containsPrime(list))
      output.println(s"$list contains at least one prime number")
    else
      output.println(s"$list does not contain a prime number")
  }
}
