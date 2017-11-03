package br.unb.cic.poo.gol

import Main.{height, width}

/* Parte do padrao Memento. Armazena as jogadas anteriores e permite desfazer as ultimas. */
object CareTaker {
  private final val MEMENTO_SIZE = 10 // Define o maximo de jogadas que podem ser desfeitas

  private var head = 0
  private var tail = 0

  private var stack_of_gens = Array.ofDim[Memento](MEMENTO_SIZE)

  /* Salva a ultima jogada na pilha. */
  def setState(currentGen: Array[Array[Cell]], revivedCells: Int, killedCells: Int): Unit = {
    val generation = Originator.createMemento(currentGen, revivedCells, killedCells)

    stack_of_gens(head) = generation

    headTailControl()
  }

  /* Retorna a ultima jogada salva. */
  def getState(currentGen: Array[Array[Cell]]): Array[Array[Cell]] = {

    if (head == tail) {
      println("\nYou can't undo anymore.")

      return currentGen
    }
    else {
      if (head == 0 && tail > 0) {
        val cells = toCells(stack_of_gens(head))

        head = 9

        Statistics.restoreRevivedCells(stack_of_gens(head).revivedCells)
        Statistics.restoreKilledCells(stack_of_gens(head).killedCells)
        return cells
      }
      else {
        head -= 1

        val cells = toCells(stack_of_gens(head))

        Statistics.restoreRevivedCells(stack_of_gens(head).revivedCells)
        Statistics.restoreKilledCells(stack_of_gens(head).killedCells)
        return cells
      }
    }
  }

  /* Converte o Memento em uma matriz para o uso do jogo. */
  private def toCells(generation: Memento): Array[Array[Cell]] ={
    var cells = Array.ofDim[Cell](height, width)

    for (i <- 0 until height) {
      for (j <- 0 until width) {
        cells(i)(j) = new Cell

        if (generation.generationCells(i)(j).isAlive)
          cells(i)(j).revive
      }
    }

    return cells
  }

  /* Controla o argumentos head e tail de forma a criar uma lista circular que sera utilizada como pilha. */
  private def headTailControl(): Unit = {
    head += 1

    if (head == MEMENTO_SIZE)
      head = 0

    if (head == tail) {
      tail += 1

      if (tail == MEMENTO_SIZE)
        tail = 0
    }
  }
}
