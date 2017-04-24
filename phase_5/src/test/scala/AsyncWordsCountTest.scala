import java.io.ByteArrayInputStream

import org.scalatest.{AsyncFlatSpec, Matchers}

import scala.concurrent.Future
import scala.io.Source

class AsyncWordsCountTest extends AsyncFlatSpec with Matchers {

  behavior of "AsyncWordsCount"

  it should "count 0 when source is empty" in {
    val toCount = Future(Source.fromInputStream(new ByteArrayInputStream("".getBytes())))
    new AsyncWordsCount(toCount).count().map(ret => assert(ret == Map.empty))
  }

  it should "count 1 when source 1 word" in {
    val toCount = Future(Source.fromInputStream(new ByteArrayInputStream("word".getBytes())))
    new AsyncWordsCount(toCount).count().map(ret => assert(ret == Map("word" -> 1)))
  }

  it should "count 3 when source contains the same word three times" in {
    val toCount = Future(Source.fromInputStream(new ByteArrayInputStream("one one one".getBytes())))
    new AsyncWordsCount(toCount).count().map(ret => assert(ret == Map("one" -> 3)))
  }
}
