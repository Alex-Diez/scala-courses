import org.scalatest.{FlatSpec, Matchers}

class ComplexNumberTest extends FlatSpec with Matchers {

  "Complex number" should "be formatted" in {
    new Complex(2, 3).toString shouldBe "2.0 + 3.0i"
    new Complex(3, 2).toString shouldBe "3.0 + 2.0i"
  }

  it should "be added to another complex number" in {
    (new Complex(3, 2) + new Complex(2, 3)).toString shouldBe "5.0 + 5.0i"
  }

  it should "add an integer" in {
    (new Complex(4, 1) + 2).toString shouldBe "6.0 + 1.0i"
  }

  it should "be subtract from another complex number" in {
    (new Complex(5, 2) - new Complex(3, 1)).toString shouldBe "2.0 + 1.0i"
  }

  it should "subtract an integer" in {
    (new Complex(6, 1) - 3).toString shouldBe "3.0 + 1.0i"
  }

  it should "be multiplied by another complex number" in {
    (new Complex(3, 2) * new Complex(4, 3)).toString shouldBe "6.0 + 17.0i"
  }

  it should "be multiplied by an integer" in {
    (new Complex(3, 3) * 4).toString shouldBe "12.0 + 3.0i"
  }

  it should "be divided by another complex number" in {
    (new Complex(4, 1) / new Complex(2, 3)).toString shouldBe new Complex(11.0/13, -10.0/13).toString
  }

  it should "be divided by an integer" in {
    (new Complex(4, 6) / 2).toString shouldBe "2.0 + 3.0i"
  }
}
