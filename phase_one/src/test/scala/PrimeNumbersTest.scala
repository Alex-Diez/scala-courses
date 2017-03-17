import org.scalatest.{FunSpec, Matchers}

class PrimeNumbersTest extends FunSpec with Matchers {

  describe("degenerated cases two, three, five, seven are a prime number") {
    it("two is a prime number") {
      Numbers.isPrime(2) shouldBe true
    }

    it("three is a prime number") {
      Numbers.isPrime(3) shouldBe true
    }

    it("five is a prime number") {
      Numbers.isPrime(5) shouldBe true
    }

    it("seven is a prime number") {
      Numbers.isPrime(7) shouldBe true
    }
  }

  describe("degenerated cases four, six, eight are not a prime number") {
    it("four is a not prime number") {
      Numbers.isPrime(4) shouldBe false
    }

    it("six is a not prime number") {
      Numbers.isPrime(6) shouldBe false
    }

    it("eight is a not prime number") {
      Numbers.isPrime(8) shouldBe false
    }
  }

  it("1000 is not prime number") {
    Numbers.isPrime(1000) shouldBe false
  }

  it("199 is a prime number") {
    Numbers.isPrime(199) shouldBe true
  }

  describe("list of prime numbers") {
    it("empty list does not contain prime numbers") {
      Numbers.containsPrime(List()) shouldBe false
    }

    it("list of degenerated numbers (4, 6, 8) does not contain a prime number") {
      Numbers.containsPrime(List(4, 6, 8)) shouldBe false
    }

    it("list of single prime number contain prime number") {
      Numbers.containsPrime(List(2)) shouldBe true
    }

    it("last number in the list is prime, thus list contains prime number") {
      Numbers.containsPrime(List(4, 10, 12, 2)) shouldBe true
    }
  }
}
