package br.unb.cic.poo.gol

import Main.{height, width}

class Memento {
  private final val MEMENTO_SIZE = 10

  var head = 0
  var tail = 0

  var generation = new Generation
  var stack_of_gens = Array(MEMENTO_SIZE)[Generation]

  def setState(currentGen: Generation): Unit = {
    this.generation.copyGen(currentGen)

    stack_of_gens(head) = generation

    headTailControl()
  }

  def getState(currentGen: Generation): Generation = {

    if (head == tail) {
      println("\nYou can't undo anymore.")

      return currentGen
    }
    else {

      if (head == 0 && tail > 0) {
        head = 9
        return stack_of_gens(head)
      }
      else {
        head -= 1
        return stack_of_gens(head)
      }
    }
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
/*


def setState(cells: Array[Array[Cell]]): Unit = { // Acho que o problema sao os argumentos de Cell
    stack_of_cells(head) = cells.clone

    for (i <- 0 until height)
      for (j <- 0 until width)
        stack_of_cells(head)(i)(j) = cells(i)(j)

    headTailControl()
  }

  def getState(cells: Array[Array[Cell]]): Array[Array[Cell]] = {

    if (head == tail) {
      println("\nYou can't undo anymore.")

      return cells
    }
    else {

      if (head == 0 && tail > 0) {
        head = 9
        return stack_of_cells(head)
      }
      else {
        head -= 1
        return stack_of_cells(head)
      }
    }
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
 */