import scala.util.Random
import PositionShips.{xsize, ysize, zsize}

object SetTable {
  val carrier     = new Ships("Porta-Avioes", 'P', 5, 1)
  val battleship  = new Ships("Encouracado", 'E', 4, 2)
  val cruiser     = new Ships("Cruzador", 'C', 3, 3)
  val submarine   = new Ships("Submarino", 'S', 3, 4)
  val destroyer   = new Ships("Contratorpedeiro", 'T', 2, 5)

  private var current: Ships = carrier

  def setRandom(): Array[Array[Array[Char]]] = {
    var a = setTable()
    var i = 0

    while (i < 4) {
      var x = Random.nextInt() % xsize
      var y = Random.nextInt() % ysize

      if ((x % 2) == 0) { //Caso j seja par, a embarcacao sera posicionada na horizontal
        a = setHorizontal(x, y, a)
      }
      else { //Caso j seja impar, a embarcacao sera posicionada na vertical
        a = setVertical(x, y, a)
      }
      if (current.quant == 0) {
        i match {
          case 0 => current = battleship
          case 1 => current = cruiser
          case 2 => current = submarine
          case 3 => current = destroyer
        }
        i += 1
      }
    }
    return a
  }

  def setManual(xsize: Int, ysize: Int, zsize: Int): Array[Array[Array[Char]]] = {
    var a = setTable()
    var i = 0
    while (i < 4) {
      var flag = true

      while (flag) {
        printTable(a) // Imprime o tabuleiro para o jogador conferir as posicoes de suas embarcacoes

        print("Embarcacao atual: " + current.name + ". Ocupa " + current.size + " quadrantes, sua designacao " + current.desig + " aparecera no tabuleiro depois de")
        println("posicionada.")

        val direction = getDirection()

        println("O " + current.name + " ocupa " + current.size + " quadrantes. Em quais coordenadas deseja posiciona-lo? (O navio sera posicionado nas coordenadas")
        println("desejadas e ocupara as coordenadas subsequentes de acordo com a sua escolha de direcao)")

        val y = getY(direction)
        val x = getX(direction)
      }


    }
    return a
  }

  private def setTable(): Array[Array[Array[Char]]] ={
    val a = Array.ofDim[Char](xsize, ysize, zsize)

    for ( x <- 0 until xsize ) {
      for ( y <- 0 until ysize ) {
        a(x)(y)(0) = '~'
        a(x)(y)(1) = 0
      }
    }
    return a
  }

  private def setHorizontal(x: Int, y: Int, array: Array[Array[Array[Char]]]): Array[Array[Array[Char]]] = {

    var flag = true

    if (x + current.size < ysize) {

      for (i <- x to (x + current.size - 1)) {
        if ('~' != array(i)(y)(0)) {
          flag = false
        }
      }

      if (flag) {
        for (i <- x to x + current.size - 1) {
          array(i)(y)(0) = current.desig
        }
        current.decreaseQuant()

      }
    }
    return array
  }

  private def setVertical(x: Int, y: Int, array: Array[Array[Array[Char]]]): Array[Array[Array[Char]]] = {
    var flag = true

    if (y + current.size < xsize) {
      for (j <- y to (x + current.size - 1))
        if ('~' != array(x)(j)(0))
          flag = false

    }
    if (flag) {
      for (j <- y to (x + current.size - 1))
        array(x)(j)(0) = current.desig

      current.decreaseQuant()
    }
    return array
  }

  private def printTable(array: Array[Array[Array[Char]]]): Unit = {
    print("  ")

    for (j <- 1 to xsize) { // Laco para imprimir a numeracao das colunas
      print(f"|$j%2d")
    }
    println('|')

    for (j <- 0 until ysize) { // Laco para imprimir o restante do tabuleiro
      print(f"${j+1}%2d")

      for (k <- 0 until xsize) {
        print("| " + array(j)(k)(0))
      }
      println('|')
    } // Fim do laco
  }

  private def getDirection(): Int = {
    println("Deseja posicionar o " + current.name + " na vertical (1) ou horizontal (2)?")
    var direction = scala.io.StdIn.readInt()

    direction = TestarValidade.horizontalVertical(direction)

    return direction
  }

  private def getY(direction: Int): Int = {
    print("\nEm qual linha deseja posicionar sua embarcacao? ")
    var y = scala.io.StdIn.readInt()

    y = TestarValidade.maiorMenor(y, 1, ysize)

    return y
  }

  private def getX(direction: Int): Int = {
    print("\nEm qual coluna deseja posicionar sua embarcacao? ")
    var x = scala.io.StdIn.readInt()

    x = TestarValidade.maiorMenor(x, 1, xsize)

    return x
  }
}