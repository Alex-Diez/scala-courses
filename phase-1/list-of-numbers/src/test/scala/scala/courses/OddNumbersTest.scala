package scala.courses

import org.scalatest.{FunSpec, Matchers}

class OddNumbersTest extends FunSpec with Matchers {

  it("sum of odds in empty list is zero") {
    Numbers.sum()(List())(item => item % 2 == 0) shouldBe 0
  }

  it("sum odds number in a list") {
    val ints = List(1, 2, 3, 4, 5)
    Numbers.sum()(ints)(item => item % 2 != 0) shouldBe 1 + 3 + 5

    Numbers.sumOf(ints)(item => item % 2 != 0) shouldBe 1 + 3 + 5

    Numbers.sumOfOdds(ints) shouldBe 1 + 3 + 5
  }
}
