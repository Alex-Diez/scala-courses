import scala.util.{Failure, Try}

object ListMagic {
  def main(args: Array[String]): Unit = {
    val theList = List(1, 2, 3)
    println(s"4 should be added in front of $theList in `4 :: theList` ${4 :: theList}")
    println(s"4 should be added at the end of the $theList in `theList :+ 4` ${theList :+ 4}")
    println(s"4 should be prepend to $theList in `4 +: theList` ${4 +: theList}")
    println(s"${List()} should throw ${
      Try(List().head) match {
        case Failure(e) => e.getClass.getSimpleName
      }
    } when call head")
    println(s"${List()} should throw ${
      Try(List().tail) match {
        case Failure(e) => e.getClass.getSimpleName
      }
    } when call tail")
    println(s"${List()} should ${
      List().headOption match {
        case None => "None"
      }
    } when call optionHead")
    println(s"$theList should have head ${theList.head}")
    println(s"$theList should have tail ${theList.tail}")
    println(s"$theList should have ${
      theList.headOption match {
        case Some(e) => s"Some($e)"
      }
    } when call headOption")
    println(s"$theList should not be copied when add head. `(4 :: theList).tail eq theList` is ${(4 :: theList).tail eq theList}")
    println(s"$theList should not be copied when prepend in front. `(4 +: theList).tail eq theList` is ${(4 :: theList).tail eq theList}")
    val theOtherList = List(4, 5, 6, 7)
    println(s"$theList should be concatenated with $theOtherList when call `theList ++ theOtherList`. ${theList ++ theOtherList}")
    println(s"$theList should be prepend to $theOtherList when call `theList ::: theOtherList`. ${theList ::: theOtherList}")
    println(s"$theList should${if (theList.exists(_ > 1)) "" else " not"} contain items greater than 1")
    println(s"$theList's items should be mapped in `theList.map(_ * 3)` ${theList.map(_ * 3)}")
    println(s"$theList's items less than 1 should be filtered out by (_ > 1) ${theList.filter(_ > 1)}")
    println(s"$theList should be folded left into ${theList.foldLeft(10)(_ + _)}")
    println(s"$theList should be reversed when folded left with ${List()} as accumulator.\n\t" +
      s"theList.foldLeft(List[Int]())((acc, item) => item :: acc) == theList.reverse is " +
      s"${theList.foldLeft(List[Int]())((acc, item) => item :: acc) == theList.reverse}")
    println(s"When `zip` is called on $theList with $theOtherList the last item is discarded. ${theList.zip(theOtherList)}")
    println(s"When `zipAll` is called on $theList with $theOtherList the last item is not discarded. ${theList.zipAll(theOtherList, 10, 11)}")
    println(s"The other way to get $theList's tail is to call drop(1). `theList.drop(1) eq theList.tail` is ${theList.drop(1) eq theList.tail}")
    println(s"Items can be dropped by predicate (_ < 3) and $theList become ${theList.dropWhile(_ < 3)}")
    println(s"Items can be taken from $theList. The list of `theList.take(1)` is ${theList.take(1)}")
    println(s"Items can be taken by predicate. List of items that greater than 3 is ${theList.takeWhile(_ < 3)}")
  }
}
