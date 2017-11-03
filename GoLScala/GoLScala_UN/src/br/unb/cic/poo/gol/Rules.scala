package br.unb.cic.poo.gol

/* Encapsula as regras e define os metodos que elas devem implementar. */
trait Rules {
  /* metodo abstrato para verificar se uma celula deve ser mantida viva */
  def shouldKeepAlive(i: Int, j: Int): Boolean

  /* metodo abstrato para verificar se uma celula deve (re)nascer */
  def shouldRevive(i: Int, j: Int): Boolean
}
