package br.unb.cic.poo.gol

/* Regras classicas do Conway que podem ser "injetadas" no programa. */
class ConwayRules extends Rules {
  val min_keep_alive: Int = 2
  val max_keep_alive: Int = 3
  val should_revive:  Int = 3

  /* Metodo para verificar se uma celula deve ser mantida viva. */
  def shouldKeepAlive(i: Int, j: Int): Boolean = {
    (GameController.rules.cells(i)(j).isAlive) &&
      (GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == min_keep_alive ||
        GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == max_keep_alive)
  }

  /* Metodo para verificar se uma celula deve (re)nascer. */
  def shouldRevive(i: Int, j: Int): Boolean = {
    ((!GameController.rules.cells(i)(j).isAlive) &&
      (GameController.rules.getNumberOfNeighborhoodAliveCells(i, j) == should_revive))
  }

}
