object GameEngine {
  var coin : Int = -1

  coin = GameInterface.pushStartButton()

  while (coin == 1) {

    PositionShips

    PositionShips.player1Table.printTable()
    PositionShips.player2Table.printTable()

    coin = GameInterface.insertCoin()

    if (coin == 0)
      GameInterface.gameOver()
  }

  GameInterface.endGame()
}
