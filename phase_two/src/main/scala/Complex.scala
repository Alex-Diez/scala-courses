class Complex(r: Double, i: Double) {
  private val real = r
  private val img = i

  def +(that: Complex): Complex = {
    new Complex(real + that.real, img + that.img)
  }

  def +(i: Int): Complex = {
    new Complex(real + i, img)
  }

  def -(that: Complex): Complex = {
    new Complex(real - that.real, img - that.img)
  }

  def -(i: Int): Complex = {
    new Complex(real - i, img)
  }

  def *(that: Complex): Complex = {
    new Complex(real * that.real - img * that.img, img * that.real + real * that.img)
  }

  def *(i: Int): Complex = {
    new Complex(real * i, img)
  }

  def /(that: Complex): Complex = {
    new Complex(
      (real * that.real + img * that.img) / (that.real * that.real + that.img * that.img),
      (img * that.real - real * that.img) / (that.real * that.real + that.img * that.img)
    )
  }

  def /(i: Int): Complex = {
    new Complex(real / i, img / i)
  }

  override def toString: String = f"$real%2.1f + $img%2.1fi"
}

object Complex {
  def main(args: Array[String]): Unit = {
    val complex = new Complex(10, 2)
    val anotherComplex = new Complex(5, 3)
    println(f"($complex) + ($anotherComplex) = ${complex + anotherComplex}")
    println(f"($complex) - ($anotherComplex) = ${complex - anotherComplex}")
    println(f"($complex) * ($anotherComplex) = ${complex * anotherComplex}")
    println(f"($complex) / ($anotherComplex) = ${complex / anotherComplex}")
  }
}
