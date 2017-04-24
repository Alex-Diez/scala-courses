import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.Source
import scala.util.Success

class AsyncWordsCount(private val source: Future[Source]) {
  def count(): Future[Map[String, Int]] = {
    source.map(_.getLines())
      .map(_.flatMap(_.split(" ")))
      .map(_.foldLeft(Map.empty[String, Int])((acc, word) => acc + (word -> (acc.getOrElse(word, 0) + 1))))
  }
}

object AsyncWordsCount {

  def main(args: Array[String]): Unit = {
    val partOne = new AsyncWordsCount(Future.successful("./phase_5/src/main/scala/words-part-1").map(Source.fromFile)).count()
    val partTwo = new AsyncWordsCount(Future.successful("./phase_5/src/main/scala/words-part-2").map(Source.fromFile)).count()

    while (!partOne.isCompleted || !partTwo.isCompleted) {
    }

    val counters =
      (partOne.value, partTwo.value) match {
        case (Some(Success(partOneCounters)), Some(Success(partTwoCounters))) =>
          partOneCounters.foldLeft(partTwoCounters) { case (acc, (word, count)) => acc + (word -> (count + acc.getOrElse(word, 0))) }
        case _ => Map.empty
      }

    for ((word, count) <- counters) {
      val time = count match {
        case 1 => "time"
        case _ => "times"
      }
      println(s"The $word appears $count $time")
    }
  }
}
