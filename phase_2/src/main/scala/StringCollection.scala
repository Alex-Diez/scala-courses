import java.io.{FileInputStream, InputStream}

import scala.io.Source

class StringCollection() {
  def lineLongerThan(stringsSource: InputStream)(size: Int):Iterator[String] = {
    for {
      line <- Source.fromInputStream(stringsSource).getLines() if line.length > size
    } yield line
  }
}

object StringCollection {
  def main(args: Array[String]): Unit = {
    for {
      longLine <- new StringCollection().lineLongerThan(new FileInputStream("./phase_2/src/main/scala/StringCollection.scala"))(10)
    } println(longLine)
  }
}
