package br.unb.cic.poo.gol

class Rule extends GameEngine with KeeperOfRules {

  def shouldKeepAlive(i: Int, j: Int): Boolean = {  /* verifica se uma celula deve ser mantida viva */
    (cells(i)(j).isAlive) &&
      (getNumberOfNeighborhoodAliveCells(i, j) == min_keep_alive ||
        getNumberOfNeighborhoodAliveCells(i, j) == max_keep_alive)
  }

  def shouldRevive(i: Int, j: Int): Boolean = {   /* verifica se uma celula deve (re)nascer */
    if (high_life) {
      ((!cells(i)(j).isAlive) && (getNumberOfNeighborhoodAliveCells(i, j) == should_revive)) ||
        ((!cells(i)(j).isAlive) && (getNumberOfNeighborhoodAliveCells(i, j) == max_should_revive))
    }
    else {
      ((!cells(i)(j).isAlive) && (getNumberOfNeighborhoodAliveCells(i, j) == should_revive))
    }
  }

}
