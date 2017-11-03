package br.unb.cic.poo.gol

/** Classe usada para computar as estatisticas do GoL.
  * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br)
  * Refatorado por Pedro Torres no 2o semestre de 2017.
  * */
object Statistics {
  
  private var revivedCells = 0
	private var killedCells = 0
  
	
	def getRevivedCells = revivedCells

	def recordRevive = revivedCells += 1

  def getKilledCells = killedCells
	
  def recordKill = killedCells += 1

	/* Restaura o valor das celulas ressuscitadas em caso de um Undo. */
	def restoreRevivedCells(revivedCells: Int) = {
    this.revivedCells = revivedCells
  }

  /* Restaura o valor das celulas mortas em caso de um Undo. */
  def restoreKilledCells(killedCells: Int) = {
    this.killedCells = killedCells
  }

	def display = {
		println("=================================");
		println("           Statistics            ");
		println("=================================");
		println("Revived cells: " + revivedCells);
		println("Killed cells: " + killedCells);
		println("=================================");
	}
  
}