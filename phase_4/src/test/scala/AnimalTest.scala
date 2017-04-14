import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class AnimalTest extends FlatSpec with Matchers with BeforeAndAfter {

  var cow: Cow = _

  before {
    cow = new Cow
  }

  "Cow" should "get weight when feed by grass" in {
    cow.weight shouldBe 50

    cow.eat(new Grass)

    cow.weight shouldBe 55
  }

  it should "be ready to make stakes from it when weight is 100" in {
    for (_ <- 0 until 10) {
      cow.eat(new Grass)
    }

    cow.weight shouldBe 100
    cow.isReady shouldBe true
  }

  "Factory" should "be able to make stakes from a cow" in {
    val factory = new SteakFactory

    for(_ <- 0 until 10) {
      cow.eat(new Grass)
    }

    factory.produce(cow).length shouldBe 10
  }

  "Dog" should "be feed by steaks" in {
    val dog = new Dog("Bob")

    dog.eat(new Steak)
  }

}
