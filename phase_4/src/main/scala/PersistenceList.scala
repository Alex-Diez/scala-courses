import scala.annotation.tailrec
import scala.collection.mutable

sealed trait PersistenceList[+E] {

  import PersistenceList._

  def head: Option[E]

  def tail: PersistenceList[E]

  def ::[T >: E](item: T): PersistenceList[T] = Cons(item, this)

  def :+[T >: E](item: T): PersistenceList[T] = reverse.foldLeft(PersistenceList[T](item))((list, e) => e :: list)

  def ++[T >: E](other: PersistenceList[T]): PersistenceList[T] = reverse.foldLeft(other)((acc, e) => e :: acc)

  def contains[T >: E](item: T): Boolean = exists(_ == item)

  @tailrec
  final def drop(n: Int): PersistenceList[E] = this match {
    case Cons(_, tail) if n > 0 => tail.drop(n - 1)
    case _ => this
  }

  @tailrec
  final def dropWhile(predicate: E => Boolean): PersistenceList[E] = this match {
    case Cons(head, tail) if predicate(head) => tail.dropWhile(predicate)
    case _ => this
  }

  def take(n: Int): PersistenceList[E] = {
    @tailrec
    def iterate(iter: Int, list: PersistenceList[E], buffer: mutable.Buffer[E]): mutable.Buffer[E] = list match {
      case Cons(head, tail) if iter > 0 => iterate(iter - 1, tail, buffer += head)
      case _ => buffer
    }

    iterate(n, this, new mutable.ArrayBuffer).reverseIterator.foldLeft(PersistenceList[E]())((acc, e) => e :: acc)
  }

  def takeWhile(predicate: E => Boolean): PersistenceList[E] = reverse.foldLeft(PersistenceList[E]())((acc, e) => if (predicate(e)) e :: acc else acc)

  def map[A](mapper: E => A): PersistenceList[A] = reverse.foldLeft(PersistenceList[A]())((acc, e) => mapper(e) :: acc)

  @tailrec
  final def foldLeft[A](acc: A)(func: (A, E) => A): A = this match {
    case Cons(head, tail) => tail.foldLeft(func(acc, head))(func)
    case Empty => acc
  }

  def foldRight[A](acc: A)(func: (E, A) => A): A = reverse.foldLeft(acc)((acc, e) => func(e, acc))

  def filter(predicate: E => Boolean): PersistenceList[E] = reverse.foldLeft(PersistenceList[E]())((acc, e) => if (predicate(e)) e :: acc else acc)

  def reverse: PersistenceList[E] = foldLeft(PersistenceList[E]())((reversed, e) => e :: reversed)

  def forall(predicate: E => Boolean): Boolean = foldLeft(true)((acc, e) => acc && predicate(e))

  def exists(predicate: E => Boolean): Boolean = foldLeft(false)((acc, e) => acc || predicate(e))

  override def toString: String = {
    @tailrec
    def listToString(list: PersistenceList[E], builder: StringBuilder): String = {
      list match {
        case Cons(head, Empty) => builder.append(head).toString()
        case Cons(head, tail) => listToString(tail, builder.append(head).append(", "))
        case Empty => builder.toString()
      }
    }

    "[" + listToString(this, new StringBuilder()) + "]"
  }
}

object PersistenceList {

  def apply[E](): PersistenceList[E] = Empty

  def apply[E](item: E): PersistenceList[E] = Cons(item, Empty)

  def apply[E](items: E*): PersistenceList[E] = items.headOption match {
    case Some(item) => item :: apply(items.tail: _*)
    case _ => apply()
  }

  private case object Empty extends PersistenceList[Nothing] {
    override def head: Option[Nothing] = None

    override def tail: PersistenceList[Nothing] = Empty
  }

  private case class Cons[+E](elem: E, tail: PersistenceList[E]) extends PersistenceList[E] {
    override def head: Option[E] = Some(elem)
  }

}

