import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class NumbersOutputTest extends FlatSpec with Matchers with BeforeAndAfter {

  private class MockOutput extends NumbersOutput {
    var messages: Seq[String] = Seq()

    override def println(string: String): Unit = messages = string +: messages
  }

  private var output: MockOutput = _

  before {
    output = new MockOutput
  }

  it should "output default list" in {
    Numbers.printList(List(1, 2, 3, 4, 5))(output)

    output.messages should contain ("All operation will be performed on List(1, 2, 3, 4, 5)")
  }

  it should "output provided list" in {
    Numbers.printList(List(1, 2, 3))(output)

    output.messages should contain ("All operation will be performed on List(1, 2, 3)")
  }

  it should "print out sum of odds number in list" in {
    Numbers.printSumOfOdds(List(1, 2, 3, 4, 5))(output)

    output.messages should contain ("Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9")
  }

  it should "print out that list contains at least one prime number" in {
    Numbers.printContainsPrime(List(1, 2, 3, 4, 5))(output)

    output.messages should contain ("List(1, 2, 3, 4, 5) contains at least one prime number")
  }

  it should "print out that list contains none of prime number" in {
    Numbers.printContainsPrime(List(4, 6, 8, 10))(output)

    output.messages should contain ("List(4, 6, 8, 10) does not contain a prime number")
  }
}
