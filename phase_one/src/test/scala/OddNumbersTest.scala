import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class OddNumbersTest extends FunSpec with Matchers with BeforeAndAfter {

  private class MockOutput extends OddNumbersOutput {
    var messages: Seq[String] = Seq()

    override def println(string: String): Unit = messages = string +: messages
  }

  private var output: MockOutput = _

  before {
    output = new MockOutput
  }

  it("sum of odds in empty list is zero") {
    OddNumbers.sumOfOdds(List()) shouldBe 0
  }

  it("sum odds number in a list") {
    val ints = List(1, 2, 3, 4, 5)

    OddNumbers.sumOfOdds(ints) shouldBe 1 + 3 + 5
  }

  it ("output default list") {
    OddNumbers.printList(List(1, 2, 3, 4, 5))(output)

    output.messages should contain ("All operation will be performed on List(1, 2, 3, 4, 5)")
  }

  it ("output provided list") {
    OddNumbers.printList(List(1, 2, 3))(output)

    output.messages should contain ("All operation will be performed on List(1, 2, 3)")
  }

  it ("print out sum of odds number in list") {
    OddNumbers.printSumOfOdds(List(1, 2, 3, 4, 5))(output)

    output.messages should contain ("Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9")
  }
}
