import scala.annotation.tailrec

class Factorial(private val n: Int) {

  def iteratively: Int = {
    var factorial = 1
    for (i <- 1 to n)
      factorial *= i
    factorial
  }

  def recursively: Int = {
    @tailrec
    def fact(n: Int, iter: Int): Int = {
      if (iter < 1) 1
      else if (iter == 1) n
      else fact(n * (iter - 1), iter - 1)
    }

    fact(n, n)
  }
}

object Factorial {
  def main(args: Array[String]): Unit = {
    val factorial = new Factorial(10)
    println(s"Factorial of 10 iteratively - ${factorial.iteratively}")
    println(s"Factorial of 10 recursively - ${factorial.recursively}")
  }
}
