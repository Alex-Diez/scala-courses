import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class PrimeNumbersTest extends FunSpec with Matchers with BeforeAndAfter {

  describe("degenerated cases two, three, five, seven are a prime number") {
    it("two is a prime number") {
      PrimeNumbers.isPrime(2) shouldBe true
    }

    it("three is a prime number") {
      PrimeNumbers.isPrime(3) shouldBe true
    }

    it("five is a prime number") {
      PrimeNumbers.isPrime(5) shouldBe true
    }

    it("seven is a prime number") {
      PrimeNumbers.isPrime(7) shouldBe true
    }
  }

  describe("degenerated cases four, six, eight are not a prime number") {
    it("four is a not prime number") {
      PrimeNumbers.isPrime(4) shouldBe false
    }

    it("six is a not prime number") {
      PrimeNumbers.isPrime(6) shouldBe false
    }

    it("eight is a not prime number") {
      PrimeNumbers.isPrime(8) shouldBe false
    }
  }

  it("1000 is not prime number") {
    PrimeNumbers.isPrime(1000) shouldBe false
  }

  it("199 is a prime number") {
    PrimeNumbers.isPrime(199) shouldBe true
  }

  describe("list of prime numbers") {
    it("empty list does not contain prime numbers") {
      PrimeNumbers.containsPrime(List()) shouldBe false
    }

    it("list of degenerated numbers (4, 6, 8) does not contain a prime number") {
      PrimeNumbers.containsPrime(List(4, 6, 8)) shouldBe false
    }

    it("list of single prime number contain prime number") {
      PrimeNumbers.containsPrime(List(2)) shouldBe true
    }

    it("last number in the list is prime, thus list contains prime number") {
      PrimeNumbers.containsPrime(List(4, 10, 12, 2)) shouldBe true
    }
  }

  private class MockOutput extends PrimeNumbersOutput {
    var messages: Seq[String] = Seq()

    override def println(string: String): Unit = messages = string +: messages
  }

  private var output: MockOutput = _

  before {
    output = new MockOutput
  }

  describe("IO tests") {

    it ("print out that list contains at least one prime number") {
      PrimeNumbers.printContainsPrime(List(1, 2, 3, 4, 5))(output)

      output.messages should contain ("List(1, 2, 3, 4, 5) contains at least one prime number")
    }

    it ("print out that list contains none of prime number") {
      PrimeNumbers.printContainsPrime(List(4, 6, 8, 10))(output)

      output.messages should contain ("List(4, 6, 8, 10) does not contain a prime number")
    }
  }
}
