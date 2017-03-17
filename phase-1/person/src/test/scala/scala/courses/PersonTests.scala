package scala.courses

import java.time._

import org.scalatest.{FunSpec, Matchers}

class PersonTests extends FunSpec with Matchers {

  private class MockClock(val instant: Instant) extends Clock {
    override def getZone: ZoneId = ZoneOffset.UTC

    override def withZone(zone: ZoneId): Clock = new MockClock(Instant.EPOCH)
  }

  val alex = new Person("Alex", LocalDate.of(1990, 10, 23))

  it("calculates Person age by year") {
    val clock = new MockClock(LocalDate.of(2016, 12, 15).atStartOfDay().toInstant(ZoneOffset.UTC))

    Person.age(alex)(clock) shouldBe 26
  }

  it("calculates Person age by year and month") {
    val clock = new MockClock(LocalDate.of(2017, 3, 15).atStartOfDay().toInstant(ZoneOffset.UTC))

    Person.age(alex)(clock) shouldBe 26
  }

  it("calculates Person age by year, month and day") {
    val clock = new MockClock(LocalDate.of(2017, 10, 22).atStartOfDay().toInstant(ZoneOffset.UTC))

    Person.age(alex)(clock) shouldBe 26
  }

  it("calculates future Person age") {
    val clock = new MockClock(LocalDate.of(2017, 10, 23).atStartOfDay().toInstant(ZoneOffset.UTC))

    Person.age(alex)(clock) shouldBe 27
  }

  private class MockOutput extends Output {
    var messages: Seq[String] = Seq()

    override def println(string: String): Unit = messages = string +: messages
  }

  it ("prints person name and age") {
    val clock = new MockClock(LocalDate.of(2017, 3, 15).atStartOfDay().toInstant(ZoneOffset.UTC))
    val output = new MockOutput
    Person.printInfo(alex)(clock, output)

    output.messages should contain ("Alex is 26 years old")
  }
}
