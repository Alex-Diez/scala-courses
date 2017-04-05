import scala.annotation.tailrec

class Fibonacci() {
  def linear(n: Int): Int = {
    @tailrec
    def loop(current: Int, prev: Int, n: Int): Int = {
      if (n == 0) current
      else loop(current + prev, current, n - 1)
    }

    loop(0, 1, n)
  }


  def logarithmic(n: Int): Int = {
    @tailrec
    def loop(current: Int, next: Int, iter: Int): Int = {
      def isOdd = (n >>> iter & 1) != 0

      if (iter >= 0)  {
        val doubled = current * (next * 2 - current)
        val doubledNext = current * current + next * next
        if (isOdd) loop(doubledNext, doubled + doubledNext, iter - 1)
        else loop(doubled, doubledNext, iter - 1)
      }
      else current
    }

    def numberOfIteration = 31 - Integer.numberOfLeadingZeros(n)

    loop(0, 1, numberOfIteration)
  }
}

object Fibonacci {
  def main(args: Array[String]): Unit = {
    println(s"Tenth fibonacci number is ${new Fibonacci().linear(10)}")
    println(s"Tenth fibonacci number is ${new Fibonacci().logarithmic(10)}")
  }
}
