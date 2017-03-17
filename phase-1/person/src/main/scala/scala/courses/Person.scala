package scala.courses

import java.time.{Clock, LocalDate, LocalDateTime, ZoneOffset}

class Person(name: String, val dayOfBirth: LocalDate) {
  override def toString: String = name
}

object Person {
  implicit def clock: Clock = Clock.systemUTC()
  implicit def output: Output = new Output {}

  def age(person: Person)(implicit clock: Clock): Int = {
    val currentDate = LocalDateTime.ofInstant(clock.instant(), ZoneOffset.UTC)
    if (currentDate.getDayOfYear < person.dayOfBirth.getDayOfYear)
      currentDate.getYear - person.dayOfBirth.getYear - 1
    else
      currentDate.getYear - person.dayOfBirth.getYear
  }

  def printInfo(person: Person)(implicit clock: Clock, output: Output):Unit = {
    val age = Person.age(person)(clock)
    output.println(s"$person is $age years old")
  }

  def main(args: Array[String]): Unit = {
    Person.printInfo(new Person("Alex", LocalDate.of(1990, 10, 23)))
  }
}

trait Output {
  def println(string: String): Unit = Console.println(string)
}
