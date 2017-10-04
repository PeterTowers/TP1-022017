import PositionShips.{xsize, ysize, zsize}

class Table {
  var grid = Array.ofDim[Char](xsize, ysize, zsize)

  def setTable(): Unit ={
    for ( x <- 0 until xsize ) {
      for ( y <- 0 until ysize ) {
        grid(x)(y)(0) = '~'
        grid(x)(y)(1) = 0
      }
    }
  }

  def printTable(): Unit = {
    print("  ")

    for (j <- 1 to xsize) { // Laco para imprimir a numeracao das colunas
      print(f"|$j%2d")
    }
    println('|')

    for (j <- 0 until ysize) { // Laco para imprimir o restante do tabuleiro
      print(f"${j+1}%2d")

      for (k <- 0 until xsize) {
        print("| " + grid(j)(k)(0))
      }
      println('|')
    } // Fim do laco
  }

  def setHorizontal(x: Int, y: Int, current: Ships): Unit = {
    var flag = true

    if (x + current.size < xsize) {

      for ( i <- x until (x + current.size) ) {
        if (grid(y)(i)(0) != '~') {
          flag = false
        }
      }

      if (flag) {
        for ( i <- x until (x + current.size) ) {
          grid(y)(i)(0) = current.desig
        }
        current.decreaseQuant()
      }
    }
  }

  def setVertical(x: Int, y: Int, current: Ships): Unit = {
    var flag = true

    if (y + current.size < ysize) {
      for (j <- y until (y + current.size))
        if (grid(j)(x)(0) != '~')
          flag = false

      if (flag) {
        for (j <- y until y + current.size)
          grid(j)(x)(0) = current.desig

        current.decreaseQuant()
      }
    }
  }
}
