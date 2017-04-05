import java.io.ByteArrayInputStream

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class StringCollectionTest extends FlatSpec with Matchers with BeforeAndAfter {

  private var stringsSource: ByteArrayInputStream = _

  before {
    stringsSource = new ByteArrayInputStream("lot\nof\nstrings\n".getBytes)
  }

  "String collections" should "be created" in {
    new StringCollection()
  }

  it should "be filtered out longer than 3 elements" in {
    new StringCollection().lineLongerThan(stringsSource)(3).toStream should contain ("strings")
  }

  it should "filter out strings longer than 2 elements" in {
    new StringCollection().lineLongerThan(stringsSource)(2).toStream should contain allOf ("lot", "strings")
  }
}
