object GameEngine {
  var coin : Int = -1

  coin = GameInterface.pushStartButton()

  while (coin == 1) {

    //PositionShips

    coin = GameInterface.insertCoin()

    if (coin == 0)
      GameInterface.gameOver()
  }

  GameInterface.endGame()
}
