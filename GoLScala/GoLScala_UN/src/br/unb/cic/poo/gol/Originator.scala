package br.unb.cic.poo.gol

/* Parte do padrao de projeto Memento. Cria o "memento", a restauracao fica por conta do CareTaker. */
object Originator {

  /* Metodo para criar o memento. */
  def createMemento(currentGen: Array[Array[Cell]], revivedCells: Int, killedCells: Int): Memento = {
    val generation = new Memento
    generation.setGeneration(currentGen, revivedCells: Int, killedCells: Int)

    return generation
  }
}
