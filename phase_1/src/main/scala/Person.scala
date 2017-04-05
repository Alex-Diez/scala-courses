import java.time.{Clock, LocalDate, LocalDateTime, ZoneOffset}

class Person(private val name: String, val dayOfBirth: LocalDate)

// To test standard output
trait PersonOutput {
  def println(string: String): Unit = Console.println(string)
}

object Person {
  def age(person: Person, clock: Clock): Int = {
    val currentDate = LocalDateTime.ofInstant(clock.instant(), ZoneOffset.UTC)
    if (currentDate.getDayOfYear < person.dayOfBirth.getDayOfYear)
      currentDate.getYear - person.dayOfBirth.getYear - 1
    else
      currentDate.getYear - person.dayOfBirth.getYear
  }

  def printInfo(person: Person, clock: Clock, output: PersonOutput):Unit = {
    val personAge = age(person, clock)
    output.println(s"${person.name} is $personAge years old")
  }

  def main(args: Array[String]): Unit = {
    printInfo(new Person("Alex", LocalDate.of(1990, 10, 23)), Clock.systemUTC(), new PersonOutput {})
  }
}
