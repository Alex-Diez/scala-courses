import org.scalatest.{FlatSpec, Matchers}

class WordCountsTest extends FlatSpec with Matchers {

  "Word counts" should "return map of (word -> counter)" in {
    WordCounts("hash").count("") shouldBe Map.empty
  }

  it should "count one word" in {
    WordCounts("tree").count("one") shouldBe Map("one" -> 1)
  }

  it should "count collection of words" in {
    WordCounts("hash").count("one two three four") shouldBe Map("one" -> 1, "two" -> 1, "three" -> 1, "four" -> 1)
  }

  it should "count repeated words" in {
    WordCounts("tree").count("one one one one") shouldBe Map("one" -> 4)
  }

}
