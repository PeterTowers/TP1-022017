package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

case class ValorFloat(v: Float) extends ValorConcreto[Float](v) {
  override def verificaTipo: Tipo = TFloat()

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}
