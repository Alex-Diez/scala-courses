import org.scalatest.{FlatSpec, Matchers}

class ProductsOfIntsTest extends FlatSpec with Matchers {

  "Product" should "be 1 when list is empty" in {
    Product.iterativelyFor(List()) shouldBe 1
    Product.iterativelyForeach(List()) shouldBe 1
    Product.recursively(List()) shouldBe 1
  }

  it should "be equal to element when list contains single element" in {
    Product.iterativelyFor(List(2)) shouldBe 2
    Product.iterativelyForeach(List(3)) shouldBe 3
    Product.recursively(List(4)) shouldBe 4
  }

  it should "be a multiplication of all elements in list" in {
    Product.iterativelyFor(List(1, 2, 3)) shouldBe 1 * 2 * 3
    Product.iterativelyForeach(List(3, 2, 1)) shouldBe 1 * 2 * 3
    Product.recursively(List(4, 3, 2, 1)) shouldBe 1 * 2 * 3 * 4
  }
}
