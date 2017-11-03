package br.unb.cic.poo.gol

/* Conjunto de regras "High Life" que podem ser "injetadas" no programa. */
class HighLifeRules extends Rules {
  val min_keep_alive    = 2
  val max_keep_alive    = 3
  val should_revive     = 3
  val max_should_revive = 6

  /* Metodo para verificar se uma celula deve ser mantida viva. */
  def shouldKeepAlive(i: Int, j: Int): Boolean = {
    (GameController.rules.cells(i)(j).isAlive) &&
      (GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == min_keep_alive ||
        GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == max_keep_alive)
  }

  /* Metodo para verificar se uma celula deve (re)nascer. */
  def shouldRevive(i: Int, j: Int): Boolean = {
    ((!GameController.rules.cells(i)(j).isAlive) &&
      (GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == should_revive)) ||
      ((!GameController.rules.cells(i)(j).isAlive) &&
        (GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == max_should_revive))
  }

}
