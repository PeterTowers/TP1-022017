class Ships(val name: String, val desig: Char, val size: Int, var quant: Int, var isdown: Boolean = false) {

def decreaseQuant(): Unit = {
  quant -= 1
}

def setState (b : Boolean): Unit = {
  isdown = b
}

}
