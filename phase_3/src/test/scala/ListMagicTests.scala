import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class ListMagicTests extends FlatSpec with Matchers with BeforeAndAfter {

  val emptyList: List[Int] = Nil
  var list: List[Int] = _

  before {
    list = List(1, 2, 3)
  }

  "Item" should "be added in front of list" in {
    4 :: list shouldBe List(4, 1, 2, 3)
  }

  it should "be added at the end of the list" in {
    list :+ 4 shouldBe List(1, 2, 3, 4)
  }

  it should "be prepend to list" in {
    4 +: list shouldBe List(4, 1, 2, 3)
  }

  "Empty list" should "throw no such element exception" in {
    assertThrows[NoSuchElementException] {
      emptyList.head
    }
  }

  it should "throw not supported operation exception" in {
    assertThrows[UnsupportedOperationException] {
      emptyList.tail shouldBe emptyList
    }
  }

  it should "have None option head" in {
    emptyList.headOption shouldBe None
  }

  "List" should "have head 1" in {
    list.head shouldBe 1
  }

  it should "have tail [List](2, 3)" in {
    list.tail shouldBe List(2, 3)
  }

  it should "have Some(1) headOption" in {
    list.headOption shouldBe Some(1)
  }

  it should "not be copied when add head" in {
    val ret = 4 :: list
    ret.tail eq list shouldBe true
  }

  it should "not be copied when prepend in front" in {
    val ret = 4 +: list
    ret.tail eq list shouldBe true
  }

  it should "be concatenated with other list" in {
    val other = List(4, 5, 6)
    list ++ other shouldBe List(1, 2, 3, 4, 5, 6)
    other ++ list shouldBe List(4, 5, 6, 1, 2, 3)
  }

  it should "be prepend to the other list" in {
    val other = List(4, 5, 6)
    list ::: other shouldBe List(1, 2, 3, 4, 5, 6)
    other ::: list shouldBe List(4, 5, 6, 1, 2, 3)
  }

  it should "be concatenated to a string" in {
    list + " concatenated to the string" shouldBe "List(1, 2, 3) concatenated to the string"
  }

  it should "contains items greater than 1" in {
    list.exists(_ > 1) shouldBe true
  }

  it should "be mapped" in {
    list.map(_ * 3) shouldBe List(3, 6, 9)
  }

  it should "be filtered out" in {
    list.filter(_ > 1) shouldBe List(2, 3)
  }

  it should "be folded left" in {
    list.foldLeft(10)(_ + _) shouldBe 16
  }

  it should "be reversed" in {
    list.foldLeft(List[Int]())((acc, item) => item :: acc) shouldBe list.reverse
  }

  it should "be zipped with the other" in {
    val other = List(4, 5, 6, 7)

    list.zip(other) shouldBe List((1, 4), (2, 5), (3, 6))
    list.zipAll(other, 10, 11) shouldBe List((1, 4), (2, 5), (3, 6), (10, 7))
  }

  it should "drop first item" in {
    list.drop(1) shouldBe List(2, 3)
  }

  it should "drop items by predicate" in {
    list.dropWhile(_ < 3) shouldBe List(3)
  }

  it should "take the first item" in {
    list.take(1) shouldBe List(1)
  }

  it should "take items by predicate" in {
    list.takeWhile(_ < 3) shouldBe List(1, 2)
  }
}
