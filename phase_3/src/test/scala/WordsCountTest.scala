import org.scalatest.{FlatSpec, Matchers}

class WordsCountTest extends FlatSpec with Matchers {

  "Word counts" should "return map of (word -> counter)" in {
    WordsCount("hash").count("") shouldBe Map.empty
  }

  it should "count one word" in {
    WordsCount("tree").count("one") shouldBe Map("one" -> 1)
  }

  it should "count collection of words" in {
    WordsCount("hash").count("one two three four") shouldBe Map("one" -> 1, "two" -> 1, "three" -> 1, "four" -> 1)
  }

  it should "count repeated words" in {
    WordsCount("tree").count("one one one one") shouldBe Map("one" -> 4)
  }

}
