
trait Food

class Grass extends Food

class Steak extends Food

abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood)
}

class Cow extends Animal {
  override type SuitableFood = Grass

  var weight: Int = 50

  def isReady: Boolean = weight >= 100

  def eat(food: SuitableFood): Unit = weight += 5
}

trait ProductFactory[P] {
  type Product = P
  type From <: Animal

  def produce(animal: From): List[Product]
}

class SteakFactory extends ProductFactory[Steak] {
  override type From = Cow

  def produce(animal: From): List[Product] = List.fill(10)(new Steak)
}

class Dog(val name: String) extends Animal {
  override type SuitableFood = Steak

  def eat(food: Steak): Unit = Console.println(s"$name is saying 'nom-nom'. The steak was delicious")
}

object AnimalsMain extends App {
  val cow = new Cow

  for (_ <- 0 until 10) {
    if (!cow.isReady) {
      Console.println("cow is not ready to be cocked...")
      Thread.sleep(100)
    }
    cow.eat(new Grass)
  }

  val dog = new Dog("Bob")
  for (steak <- new SteakFactory().produce(cow)) {
    dog.eat(steak)
    Thread.sleep(100)
  }
}
