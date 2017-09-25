class Ships (var name: String, var desig : Char, var quant : Int, var size : Int, var isdown : Boolean) {

  def setName (classe : String): Unit = {
    name = classe
  }

  def setDesig (c : Char): Unit = {
    desig = c
  }

  def setQuant (i : Int): Unit = {
    quant = i
  }

  def setSize (i : Int): Unit = {
    size = i
  }

  def setState (b : Boolean): Unit = {
    isdown = b
  }

}
