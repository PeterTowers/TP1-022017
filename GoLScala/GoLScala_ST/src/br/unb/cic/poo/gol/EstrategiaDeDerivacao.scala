package br.unb.cic.poo.gol

import Main.{height, width}

trait EstrategiaDeDerivacao {

  /* verifica se uma celula deve ser mantida viva */
  def shouldKeepAlive(i: Int, j: Int, cells: Array[Array[Cell]]): Boolean = {
    (cells(i)(j).isAlive) &&
      (numberOfNeighborhoodAliveCells(i, j, cells) == 2 || numberOfNeighborhoodAliveCells(i, j, cells) == 3)
  }

  /* verifica se uma celula deve (re)nascer */
  def shouldRevive(i: Int, j: Int, cells: Array[Array[Cell]]): Boolean = {
    (!cells(i)(j).isAlive) &&
      (numberOfNeighborhoodAliveCells(i, j, cells: Array[Array[Cell]]) == 3)
  }

  /* Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro. */
  private def validPosition(i: Int, j: Int) = i >= 0 && i < height && j >= 0 && j < width;

  /*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */

  private def numberOfNeighborhoodAliveCells(i: Int, j: Int, cells: Array[Array[Cell]]): Int = {
    var alive = 0
    for(a <- (i - 1 to i + 1)) {
      for(b <- (j - 1 to j + 1)) {
        if (validPosition(a, b)  && (!(a==i && b == j)) && cells(a)(b).isAlive) {
          alive += 1
        }
      }
    }
    alive
  }
}
