package br.unb.cic.poo.gol

import scala.collection.mutable.ListBuffer

/** Representa a Game Engine do GoL
 *  @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br)
 *  Refatorado por Pedro Torres no 2o semestre de 2017.
 *  */
abstract class GameEngine {
  
  val height = Main.height
  val width = Main.width
  
  var cells = Array.ofDim[Cell](height, width)

  private final val TOP     = 0
  private final val BOTTOM  = 9
  private final val LEFT    = 0
  private final val RIGHT   = 9
  
  for(i <- (0 until height)) {
    for(j <- (0 until width)) {
      cells(i)(j) = new Cell
    }
  }


  /**
	 * Calcula uma nova geracao do ambiente. Essa implementacao utilizando um algoritmo definido nas classes que estendem
   * o trait Rule.
	 */
  
  def nextGeneration {
    val mustRevive = new ListBuffer[Cell]
    val mustKill = new ListBuffer[Cell]

    for(i <- (0 until height)) {
      for(j <- (0 until width)) {
        if(shouldRevive(i, j)) {
          mustRevive += cells(i)(j)
        }
        else if((!shouldKeepAlive(i, j)) && cells(i)(j).isAlive) {
          mustKill += cells(i)(j)
        }
      }
    }

    for(cell <- mustRevive) {
      cell.revive
      Statistics.recordRevive
    }
    
    for(cell <- mustKill) {
      cell.kill
      Statistics.recordKill
    }
  }
  
  /**
	 * Torna a celula de posicao (i, j) viva
	 * 
	 * @param i posicao vertical da celula
	 * @param j posicao horizontal da celula
	 * 
	 * @throws InvalidParameterException caso a posicao (i, j) nao seja valida.
	 */
  @throws(classOf[IllegalArgumentException])
  def makeCellAlive(i: Int, j: Int) = {
    if(validPosition(i, j)){
      cells(i)(j).revive
      Statistics.recordRevive
    } else {
      throw new IllegalArgumentException
    }
  }
  
  /**
	 * Verifica se uma celula na posicao (i, j) estah viva.
	 * 
	 * @param i Posicao vertical da celula
	 * @param j Posicao horizontal da celula
	 * @return Verdadeiro caso a celula de posicao (i,j) esteja viva.
	 * 
	 * @throws InvalidParameterException caso a posicao (i,j) nao seja valida. 
	 */
  @throws(classOf[IllegalArgumentException])
  def isCellAlive(i: Int, j: Int): Boolean = {
    if(validPosition(i, j)) {
      cells(i)(j).isAlive
    } else {
      throw new IllegalArgumentException
    }
  }

  /**
	 * Retorna o numero de celulas vivas no ambiente. Esse metodo eh particularmente util para o calculo de estatisticas
   * e para melhorar a testabilidade.
	 * 
	 * @return  numero de celulas vivas.
	 */
  def numberOfAliveCells {
    var aliveCells = 0
    for(i <- (0 until height)) {
      for(j <- (0 until width)) {
        if(isCellAlive(i, j)) aliveCells += 1
      }
    }
  }

  /* metodo abstrato para verificar se uma celula deve ser mantida viva. */
  def shouldKeepAlive(i: Int, j: Int): Boolean
  
  /* metodo abstrato para verificar se uma celula deve (re)nascer. */
  def shouldRevive(i: Int, j: Int): Boolean

  /* Verifica se uma posicao (a, b) referencia uma celula valida no tabuleiro. */
  private def validPosition(i: Int, j: Int): Boolean = i >= 0 && i < height && j >= 0 && j < width

  /*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente de referencia identificada pelos
	 * argumentos (i,j). O tabuleiro agora eh "infinito", ou seja, todos os seus lados estao conectados como em um
	 * toroide.
	 */
  private def numberOfNeighborhoodAliveCells(i: Int, j: Int): Int = {
    var alive = 0

    for(a <- (i - 1 to i + 1)) {
      for(b <- (j - 1 to j + 1)) {
        if (validPosition(a, b)) {
          if ((!(a == i && b == j)) && cells(a)(b).isAlive) {
            alive += 1
          }
        }

        else if (a < TOP) {
          if (b >= LEFT && b <= RIGHT) {
            if (cells(BOTTOM)(b).isAlive)
              alive += 1
          }
          else if (b < LEFT) {
            if (cells(BOTTOM)(RIGHT).isAlive)
              alive += 1
          }
          else {
            if (cells(BOTTOM)(LEFT).isAlive)
              alive += 1
          }
        }

        else if (a > BOTTOM) {
          if (b >= LEFT && b <= RIGHT) {
            if (cells(TOP)(b).isAlive)
              alive += 1
          }
          else if (b < LEFT) {
            if (cells(TOP)(RIGHT).isAlive)
              alive += 1
          }
          else {
            if (cells(TOP)(LEFT).isAlive)
              alive += 1
          }
        }

        else if (b < LEFT && a >= TOP && a <= BOTTOM) {
          if (cells(a)(RIGHT).isAlive)
            alive += 1
        }

        else if (b > RIGHT && a >= TOP && a <= BOTTOM) {
          if (cells(a)(LEFT).isAlive)
            alive += 1
        }
      }
    }
    return alive
  }
  /* Retorna o valor do metodo acima para outras funcoes */
  def getNumberOfNeighborhoodAliveCells(i: Int, j: Int): Int = numberOfNeighborhoodAliveCells(i, j)
}