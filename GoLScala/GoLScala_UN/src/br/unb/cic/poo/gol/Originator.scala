package br.unb.cic.poo.gol

/* Parte do padrao de projeto Memento. Este objeto cria o "memento" o restaura. */
object Originator {

  /* Metodo para criar o memento. */
  def createMemento(currentGen: Array[Array[Cell]], revivedCells: Int, killedCells: Int): Memento = {
    val generation = new Memento
    generation.setGeneration(currentGen, revivedCells: Int, killedCells: Int)

    return generation
  }

  /* Metodo para recuperar o memento. */
  //def restoreMemento: Memento = generation.getGeneration

}
