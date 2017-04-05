import org.scalatest.{FlatSpec, Matchers}

class FactorialTest extends FlatSpec with Matchers {

  it should "calculate factorial of 0" in {
    val factorialOfZero = new Factorial(0)
    factorialOfZero.iteratively shouldBe 1
    factorialOfZero.recursively shouldBe 1
  }

  it should "calculate factorial of 1" in {
    val factorialOfOne = new Factorial(1)
    factorialOfOne.iteratively shouldBe 1
    factorialOfOne.recursively shouldBe 1
  }

  it should "calculate factorial of 2" in {
    val factorialOfTwo = new Factorial(2)
    factorialOfTwo.iteratively shouldBe 2
    factorialOfTwo.recursively shouldBe 2
  }

  it should "calculate factorial of 3" in {
    val factorialOfThree = new Factorial(3)
    factorialOfThree.iteratively shouldBe 6
    factorialOfThree.recursively shouldBe 6
  }

  it should "calculate factorial of 6" in {
    val factorialOfSix = new Factorial(6)
    factorialOfSix.iteratively shouldBe 1 * 2 * 3 * 4 * 5 * 6
    factorialOfSix.recursively shouldBe 1 * 2 * 3 * 4 * 5 * 6
  }
}
