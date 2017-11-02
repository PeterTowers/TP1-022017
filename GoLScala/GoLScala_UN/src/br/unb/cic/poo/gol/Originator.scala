package br.unb.cic.poo.gol

/* Parte do padrao de projeto Memento. Este objeto cria o "memento" e pode o restaurar. */
object Originator {
  var memento = new Memento

  def createMemento(cells: Array[Array[Cell]]): Unit = {
    memento.setState(cells)
  }

  def restoreMemento(cells: Array[Array[Cell]]): Array[Array[Cell]] = {
    val state = memento.getState(cells)

    return state
  }

}
