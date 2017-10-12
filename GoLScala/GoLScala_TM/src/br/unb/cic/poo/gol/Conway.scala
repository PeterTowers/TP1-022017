package br.unb.cic.poo.gol

class Conway extends GameEngine{

  def shouldKeepAlive(i: Int, j: Int): Boolean = {  /* verifica se uma celula deve ser mantida viva */
    (cells(i)(j).isAlive) &&
      (getNumberOfNeighborhoodAliveCells(i, j) == 2 || getNumberOfNeighborhoodAliveCells(i, j) == 3)
  }

  def shouldRevive(i: Int, j: Int): Boolean = {   /* verifica se uma celula deve (re)nascer */
    (!cells(i)(j).isAlive) &&
      (getNumberOfNeighborhoodAliveCells(i, j) == 3)
  }

}
