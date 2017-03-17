package scala.courses

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class NumbersOutputTest extends FlatSpec with Matchers with BeforeAndAfter {

  private class MockOutput extends Output {
    var messages: Seq[String] = Seq()

    override def println(string: String): Unit = messages = string +: messages
  }

  private var output: MockOutput = _

  before {
    output = new MockOutput
  }

  it should "output default list" in {
    new Numbers()(output).printList()

    output.messages should contain ("You haven't provided a list. All operation will be performed on default list, which is List(1, 2, 3, 4, 5)")
  }

  it should "output provided list" in {
    new Numbers(List(1, 2, 3))(output).printList()

    output.messages should contain ("All operation will be performed on List(1, 2, 3)")
  }

  it should "print out sum of odds number in list" in {
    new Numbers()(output).printSumOfOdds()

    output.messages should contain ("Sum of odds numbers in List(1, 2, 3, 4, 5) equals to 9")
  }

  it should "print out that list contains at least one prime number" in {
    new Numbers()(output).printContainsPrime()

    output.messages should contain ("List(1, 2, 3, 4, 5) contains at least one prime number")
  }

  it should "print out that list contains none of prime number" in {
    new Numbers(List(4, 6, 8, 10))(output).printContainsPrime()

    output.messages should contain ("List(4, 6, 8, 10) does not contain a prime number")
  }
}
