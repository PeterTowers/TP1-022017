package br.unb.cic.poo.gol

import Main.{height, width}

object CareTaker {
  private final val MEMENTO_SIZE = 10

  private var head = 0
  private var tail = 0

  private var stack_of_gens = Array.ofDim[Memento](MEMENTO_SIZE)

  def setState(currentGen: Array[Array[Cell]], revivedCells: Int, killedCells: Int): Unit = {
    val generation = Originator.createMemento(currentGen, revivedCells, killedCells)

    stack_of_gens(head) = generation

    headTailControl()
  }

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
