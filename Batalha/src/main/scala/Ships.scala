trait Ships {

  val name  : String
  val desig : Char
  val size  : Int

  var quant : Int
  var isdown: Boolean

  def setQuant (i : Int): Unit = {
    quant = i
  }

  def setState (b : Boolean): Unit = {
    isdown = b
  }

}
