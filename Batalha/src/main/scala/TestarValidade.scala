object TestarValidade {

  def simOuNao (alvo : Int): Int = {
    var retorno = alvo

    while (retorno != 1 && retorno != 0) {
      println("Entrada invalida, digite 1 para sim ou 0 para nao.")
      retorno = scala.io.StdIn.readInt()
    }

    return retorno
  }

  def maiorMenor (alvo: Int, isso: Int, aquilo: Int): Int = {
    var retorno = alvo

    while (retorno < isso || retorno > aquilo) {
      println("Entrada invalida. Digite um valor entre " + isso + " e " + aquilo +".")
      retorno = scala.io.StdIn.readInt()
    }

    return retorno
  }

  def horizontalVertical (alvo: Int): Int = {
    var retorno = alvo

    while (retorno != 1 && retorno != 2) {
      println("Entrada invalida, digite 1 para posicionar na vertical ou 0 para horizontal.")
      retorno = scala.io.StdIn.readInt()
    }
    return retorno
  }

  def testaPosicionamento (current: Ships, table: Table, direction: Int, x: Int, y: Int): Boolean = {

    if (direction == 1) {
      if ( (y+current.size) > PositionShips.ysize ) {
        println("Sua entrada eh invalida, pois parte do seu navio ficaria fora do tabuleiro. Tente novamente.")
        return true
      }
      for (j <- y until (y + current.size)) {
        if (table.grid(j)(y)(0) != '~') {
          println("Sua entrada eh invalida, pois seu este navio ficaria em uma posicao ja ocupada por outro. Tente novamente.")
          return true
        }
      }

    }
    else {
      if ( (x+current.size) > PositionShips.xsize ) {
        println("Sua entrada eh invalida, pois parte do seu navio ficaria fora do tabuleiro. Tente novamente.")
        return true
      }
      for (i <- x until (x + current.size)) {
        if (table.grid(y)(i)(0) != '~') {
          println("Sua entrada eh invalida, pois seu este navio ficaria em uma posicao ja ocupada por outro. Tente novamente.")
          return true
        }
      }
    }

    return false
  }

}
