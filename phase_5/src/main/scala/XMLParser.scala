import scala.util.parsing.combinator.JavaTokenParsers

class XMLParser extends JavaTokenParsers {
  def value: Parser[Any] = simpleTag | complexTag

  def simpleTag: Parser[Any] = "<" ~ ident ~ opt("\\s+") ~ opt(attributes) ~ opt("\\s+") ~ "/>"

  def attribute: Parser[Any] = ident ~ opt(opt("\\s+") ~ "=" ~ opt("\\s+") ~ stringLiteral)

  def attributes: Parser[Any] = repsep(attribute, "\\s+")

  def complexTag: Parser[Any] = "<" ~ ident ~ opt("\\s+") ~ opt(attributes) ~ ">" ~ repsep(value, opt("\\s+")) | opt(ident) ~ "</" ~ ident ~ ">"
}

object ParseXML extends XMLParser {
  def main(args: Array[String]): Unit = {
    println(parseAll(value,
      "<project xsi=\"http://www.w3.org/2001/XMLSchema_instance\">\n" +
        "    <parent>\n" +
        "        <artifactId>java_algorithms_learning</artifactId>\n" +
        "        <groupId>java_algorithms_learning</groupId>\n" +
        "    </parent>\n" +
        "\n" +
        "    <artifactId>google_code_jam</artifactId>\n" +
        "    <simpleTag/>\n" +
        "\n" +
        "    <dependencies>\n" +
        "        <dependency>\n" +
        "            <groupId>org_apache_logging_log4j</groupId>\n" +
        "            <artifactId>log4j_api</artifactId>\n" +
        "        </dependency>\n" +
        "    </dependencies>\n" +
        "    <simpletag/>\n" +
        "</project>\n" +
        ""))
  }
}
