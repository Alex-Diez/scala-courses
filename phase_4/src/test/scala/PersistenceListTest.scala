import org.scalatest.{BeforeAndAfter, FunSpec, Matchers}

class PersistenceListTest extends FunSpec with Matchers with BeforeAndAfter {

  var emptyList: PersistenceList[Int] = _
  var nonemptyList: PersistenceList[Int] = _

  before {
    emptyList = PersistenceList()
    nonemptyList = PersistenceList(10, 20, 30)
  }

  describe("A list") {
    describe("when empty") {
      it("should be formatted as '[]'") {
        emptyList.toString shouldBe "[]"
      }

      it("should add item in front") {
        (10 :: emptyList).toString shouldBe "[10]"
        (20 :: emptyList).toString shouldBe "[20]"
      }

      it("should add item in back") {
        (emptyList :+ 10).toString shouldBe "[10]"
      }

      it("should have 'None' as head") {
        emptyList.head shouldBe None
      }

      it("should have an empty list as a tail") {
        emptyList.tail shouldBe emptyList
      }

      it("should not contain item") {
        emptyList.contains(10) shouldBe false
      }

      it("always hold property for all items") {
        emptyList.forall(_ == 10) shouldBe true
      }

      it("does not have any item") {
        emptyList.exists(_ == 10) shouldBe false
      }
    }

    describe("when nonempty") {
      it("should be formatted in '[item1, item2, ... itemN]'") {
        nonemptyList.toString shouldBe "[10, 20, 30]"
      }

      it("should add items in front") {
        60 :: 50 :: 40 :: nonemptyList shouldBe 60 :: 50 :: 40 :: 10 :: 20 :: 30 :: emptyList
      }

      it("should add items in back") {
        nonemptyList :+ 40 :+ 50 :+ 60 shouldBe 10 :: 20 :: 30 :: 40 :: 50 :: 60 :: emptyList
      }

      it("should have head Some(firstItem)") {
        nonemptyList.head shouldBe Some(10)
        (40 :: nonemptyList).head shouldBe Some(40)
      }

      it("should have tail") {
        nonemptyList.tail shouldBe 20 :: 30 :: emptyList
      }

      it("should contain inserted item") {
        nonemptyList.contains(10) shouldBe true
        nonemptyList.contains(20) shouldBe true
        nonemptyList.contains(30) shouldBe true
      }

      it("should not contain not inserted item") {
        nonemptyList.contains(40) shouldBe false
      }

      it("hold a property when all items match a predicate") {
        nonemptyList.forall(_ % 10 == 0) shouldBe true
      }

      it("does not hold a property when at least one item does not match a predicate") {
        nonemptyList.forall(_ != 30) shouldBe false
      }

      it("the existence test pass if at least one item matches a predicate") {
        nonemptyList.exists(_ == 10) shouldBe true
      }

      it("the existence test does not pass if all items don't match predicate") {
        nonemptyList.exists(_ > 50) shouldBe false
      }
    }
  }

  describe("When") {
    describe("an empty list") {
      it("concatenated with another empty list the result should be an empty list") {
        emptyList ++ emptyList shouldBe emptyList
      }

      it("concatenated with nonempty list the result should be the other list") {
        emptyList ++ nonemptyList shouldBe nonemptyList
      }
    }

    describe("a nonempty list") {
      it("concatenated with an empty list the result should be this list") {
        nonemptyList ++ emptyList shouldBe nonemptyList
      }

      it("concatenated with a nonempty list the result should contain all elements") {
        nonemptyList ++ nonemptyList shouldBe 10 :: 20 :: 30 :: 10 :: 20 :: 30 :: emptyList
      }
    }

    describe("drop") {
      describe("0 items") {
        describe("from a nonempty list") {
          it("the result should the same list") {
            nonemptyList.drop(0) shouldBe nonemptyList
          }
        }

        describe("from an empty list") {
          it("the result should be an empty list") {
            emptyList.drop(0) shouldBe emptyList
          }
        }
      }

      describe("none zero items") {
        describe("from an empty list") {
          it("the result should be an empty list") {
            emptyList.drop(10) shouldBe emptyList
          }
        }

        describe("from a nonempty list") {
          it("the result should have the rest of the list's items") {
            nonemptyList.drop(2) shouldBe 30 :: emptyList
          }

          it("the result should be an empty list if 'n' more than the list size") {
            nonemptyList.drop(10) shouldBe emptyList
          }
        }
      }

      describe("items by a predicate") {
        describe("from an empty list") {
          it("the result should be an empty list") {
            emptyList.dropWhile(_ < 10) shouldBe emptyList
          }
        }

        describe("from a nonempty list") {
          it("and none of elements match predicate the result should be the same list") {
            nonemptyList.dropWhile(_ < 0) shouldBe nonemptyList
          }

          it("the result should not contain items that match the predicate") {
            nonemptyList.dropWhile(_ < 30) shouldBe 30 :: emptyList
          }
        }
      }
    }

    describe("take") {
      describe("items from an empty list") {
        it("the result is an empty list") {
          emptyList.take(10) shouldBe emptyList
        }
      }

      describe("items from a nonempty list") {
        it("the result is the list if 'n' more than the list size") {
          nonemptyList.take(10) shouldBe nonemptyList
        }

        it("the result is the list of first 'n' items of the list") {
          nonemptyList.take(2) shouldBe 10 :: 20 :: emptyList
        }
      }

      describe("items by a predicate") {
        describe("from an empty list") {
          it("the result is an empty list") {
            emptyList.takeWhile(_ > 50) shouldBe emptyList
          }
        }

        describe("from a nonempty list") {
          it("the result is the same list if all items match the predicate") {
            nonemptyList.takeWhile(_ < 60) shouldBe nonemptyList
          }

          it("the result contains items that match predicate") {
            nonemptyList.takeWhile(_ < 30) shouldBe 10 :: 20 :: emptyList
          }
        }
      }
    }

    describe("filtering") {
      describe("an empty list") {
        it("the result is an empty list") {
          emptyList.filter(_ > 50) shouldBe emptyList
        }
      }

      describe("a nonempty list") {
        it("the result is the same list if all items match a predicate") {
          nonemptyList.filter(_ < 40) shouldBe nonemptyList
        }

        it("the result contains only items that match a predicate") {
          nonemptyList.filter(_ < 30) shouldBe 10 :: 20 :: emptyList
        }
      }
    }

    describe("reverse") {
      describe("an empty list") {
        it("the result is an empty list") {
          emptyList.reverse shouldBe emptyList
        }
      }

      describe("a nonempty list") {
        it("the result contains items in reverse order") {
          nonemptyList.reverse shouldBe 30 :: 20 :: 10 :: emptyList
        }
      }
    }
  }

  describe("Transform a list when") {
    it("items are mapped into other type") {
      nonemptyList.map(e => String.valueOf(e)) shouldBe "10" :: "20" :: "30" :: PersistenceList()
    }

    it("fold it left") {
      nonemptyList.foldLeft("")((acc, e) => acc + e) shouldBe "102030"
    }

    it("fold it right") {
      nonemptyList.foldRight("")((e, acc) => acc + e) shouldBe "302010"
    }
  }
}
