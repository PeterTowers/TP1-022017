import scala.util.Random
import PositionShips.{xsize, ysize}

object SetTable {

  def setRandom(a: Table): Table = {
    var current = new Ships("Porta-Avioes", 'P', 5, 1)
    var i = 0

    a.setTable()

    while (i < 4) {
      var x = Random.nextInt() % xsize: Int
      if (x < 0)
        x *= (-1)

      var y = Random.nextInt() % ysize: Int
      if (y < 0)
        y *= (-1)

      if ((x % 2) == 0) { //Caso x seja par, a embarcacao sera posicionada na horizontal
        a.setHorizontal(x, y, current)
      }
      else { //Caso x seja impar, a embarcacao sera posicionada na vertical
        a.setVertical(x, y, current)
      }
      if (current.quant == 0) {
        current = matchShip(i)
        i += 1
      }
    }
    return a
  }

  def setManual(a: Table): Table = {
    var current = new Ships("Porta-Avioes", 'P', 5, 1)
    var i = 0

    a.setTable()

    while (i < 4) {
      var flag = true

      while (flag) {
        println()
        a.printTable() // Imprime o tabuleiro para o jogador conferir as posicoes de suas embarcacoes
        println()

        print("Embarcacao atual: " + current.name + ". Ocupa " + current.size + " quadrantes, sua designacao " + current.desig + " aparecera no tabuleiro depois de ")
        println("posicionada.")

        val direction = getDirection(current)

        println("O " + current.name + " ocupa " + current.size + " quadrantes. Em quais coordenadas deseja posiciona-lo? (O navio sera posicionado nas coordenadas")
        println("desejadas e ocupara as coordenadas subsequentes de acordo com a sua escolha de direcao)")

        var y = getY(direction)
        var x = getX(direction)

        flag = TestarValidade.testaPosicionamento(current, a, direction, x, y)

        if (!flag) {
          x -= 1  // Ajustes para adequacao a matriz
          y -= 1

          current.decreaseQuant()

          if (direction == 2) {
            a.setHorizontal(x, y, current)
          }
          else {
            a.setVertical(x, y, current)
          }
        }
      }
      if (current.quant == 0) {
        current = matchShip(i)
        i += 1
      }
    }
    return a
  }

  private def getDirection(current: Ships): Int = {
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

  private def matchShip(i: Int): Ships = {
    i match {
      case 0 => return(new Ships("Encouracado", 'E', 4, 2))
      case 1 => return(new Ships("Cruzador", 'C', 3, 3))
      case 2 => return(new Ships("Submarino", 'S', 3, 4))
      case 3 => return(new Ships("Contratorpedeiro", 'T', 2, 5))
    }
  }
}