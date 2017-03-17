import java.time.{Clock, LocalDate, LocalDateTime, ZoneOffset}

class Person(name: String, val dayOfBirth: LocalDate) {
  override def toString: String = name
}

// To test standard output
trait PersonOutput {
  def println(string: String): Unit = Console.println(string)
}

object Person {
  implicit def clock: Clock = Clock.systemUTC()
  implicit def output: PersonOutput = new PersonOutput {}

  def age(person: Person)(implicit clock: Clock): Int = {
    val currentDate = LocalDateTime.ofInstant(clock.instant(), ZoneOffset.UTC)
    if (currentDate.getDayOfYear < person.dayOfBirth.getDayOfYear)
      currentDate.getYear - person.dayOfBirth.getYear - 1
    else
      currentDate.getYear - person.dayOfBirth.getYear
  }

  def printInfo(person: Person)(implicit clock: Clock, output: PersonOutput):Unit = {
    val personAge = age(person)(clock)
    output.println(s"$person is $personAge years old")
  }

  def main(args: Array[String]): Unit = {
    printInfo(new Person("Alex", LocalDate.of(1990, 10, 23)))
  }
}
