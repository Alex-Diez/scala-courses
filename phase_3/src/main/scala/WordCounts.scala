import scala.collection.mutable
import scala.io.Source

class WordCounts(counters: mutable.Map[String, Int]) {
  def count(text: String): Map[String, Int] = {
    if (text.isEmpty) Map.empty
    else {
      for (word <- text.split(" ")) {
        counters.contains(word) match {
          case true => counters.get(word) match {
            case Some(counter) => counters += (word -> (counter + 1))
            case None => counters += (word -> 1)
          }
          case false => counters += (word -> 1)
        }
      }
      Map.empty ++ counters
    }
  }
}

object WordCounts {
  def apply(mapType: String): WordCounts = mapType match {
    case "hash" => new WordCounts(new mutable.HashMap[String, Int]())
    case "tree" => new WordCounts(new mutable.TreeMap[String, Int]())
    case _ => throw new UnsupportedOperationException("program supports only tree or hash map")
  }
}

object WordCountsMain {
  def main(args: Array[String]): Unit = {
    args match {
      case Array() =>
        println("please enter 'hash' to use HashMap or 'tree' to use TreeMap")
        System.exit(1)
      case Array(mapType) =>
        val line = Source.fromFile("./phase_3/src/main/scala/words").getLines().foldLeft("")((acc, item) => acc + item + " ")
        for ((word, count) <- WordCounts(mapType).count(line)) {
          val time = count match {
            case 1 => "time"
            case _ => "times"
          }
          println(s"The $word appears $count $time")
        }
    }
  }
}
