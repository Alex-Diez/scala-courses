import scala.annotation.tailrec

object Product {
  def iterativelyFor(list: List[Int]): Int = {
    var ret = 1
    for (item <- list)
      ret *= item
    ret
  }

  def iterativelyForeach(list: List[Int]): Int = {
    var ret = 1
    list.foreach(ret *= _)
    ret
  }

  def recursively(list: List[Int]): Int = {
    @tailrec
    def loop(n: Int, items: List[Int]): Int = {
      if (items.isEmpty) n
      else loop(n * items.head, items.tail)
    }

    loop(1, list)
  }

  def main(args: Array[String]): Unit = {
    val items = List.range(1, 100)
    println(s"The product of `List.range(1, 100)` calculated iteratively using `for` ${iterativelyFor(items)}")
    println(s"The product of `List.range(1, 100)` calculated iteratively using foreach ${iterativelyForeach(items)}")
    println(s"The product of `List.range(1, 100)` calculated recursively ${recursively(items)}")
  }
}
