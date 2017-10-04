object PositionShips {
  val xsize = 10
  val ysize = 10
  val zsize = 2

  var control = -1

  println("Player 1, deseja que seus navios sejam posicionados aleatoriamente no tabuleiro? (Sim: 1 | Nao: 0)")
  control = scala.io.StdIn.readInt()
  control = TestarValidade.simOuNao(control)

  var player1Table = new Table

  if (control == 1) {
    SetTable.setRandom(player1Table)
  }
  else {
    SetTable.setManual(player1Table)
  }

  println("Player 2, deseja que seus navios sejam posicionados aleatoriamente no tabuleiro? (Sim: 1 | Nao: 0)")
  control = scala.io.StdIn.readInt()
  control = TestarValidade.simOuNao(control)

  var player2Table = new Table

  if (control == 1) {
    SetTable.setRandom(player2Table)
  }
  else {
    SetTable.setManual(player2Table)
  }

//return tabuleiros
}
