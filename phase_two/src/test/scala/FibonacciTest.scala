import org.scalatest.{Matchers, WordSpec}

class FibonacciTest extends WordSpec with Matchers {

  "Linear Fibonacci" when {
    "Fibonacci" should {
      "be 1 when count first element" in {
        new Fibonacci().linear(1) shouldBe 1
      }

      "be 1 when count second element" in {
        new Fibonacci().linear(2) shouldBe 1
      }

      "be 2 when count third element" in {
        new Fibonacci().linear(3) shouldBe 2
      }

      "be 3 when count fourth element" in {
        new Fibonacci().linear(4) shouldBe 3
      }

      "be 5 when count fifth element" in {
        new Fibonacci().linear(5) shouldBe 5
      }

      "be 8 when count sixth element" in {
        new Fibonacci().linear(6) shouldBe 8
      }

      "be 13 when count seventh element" in {
        new Fibonacci().linear(7) shouldBe 13
      }
    }
  }

  "Logarithmic Fibonacci" when {

    "Fibonacci" should {
      "be 1 when count first element" in {
        new Fibonacci().logarithmic(1) shouldBe 1
      }

      "be 1 when count second element" in {
        new Fibonacci().logarithmic(2) shouldBe 1
      }

      "be 2 when count third element" in {
        new Fibonacci().logarithmic(3) shouldBe 2
      }

      "be 3 when count fourth element" in {
        new Fibonacci().logarithmic(4) shouldBe 3
      }

      "be 5 when count fifth element" in {
        new Fibonacci().logarithmic(5) shouldBe 5
      }

      "be 8 when count sixth element" in {
        new Fibonacci().logarithmic(6) shouldBe 8
      }

      "be 13 when count seventh element" in {
        new Fibonacci().logarithmic(7) shouldBe 13
      }
    }
  }

}
