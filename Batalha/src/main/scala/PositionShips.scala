object PositionShips {
  val xsize = 10
  val ysize = 10
  val zsize = 2
  var control = -1

  println("Player 1, deseja que seus navios sejam posicionados aleatoriamente no tabuleiro? (Sim: 1 | Nao: 0)")
  control = scala.io.StdIn.readInt()
  control = TestarValidade.simOuNao(control)

  var player1Table = Array.ofDim[Char](xsize, ysize, zsize)

  if (control == 1) {

    //SetTable.setRandom(player1Table)
  }
  else {
    //Criar tabuleiro p/ player 1
    //Manual
  }

  println("Player 2, deseja que seus navios sejam posicionados aleatoriamente no tabuleiro? (Sim: 1 | Nao: 0)")
  control = scala.io.StdIn.readInt()
  control = TestarValidade.simOuNao(control)

  if (control == 1) {
    //Criar tabuleiro p/ player 2
    //Random
  }
  else {
    //Criar tabuleiro p/ player 2
    //Manual
  }

//return tabuleiros
}
