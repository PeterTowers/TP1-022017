package br.unb.cic.tp1.mh.ast

case class ValorFloat(v: Float) extends ValorConcreto[Float](v) {
  override def verificaTipo: Tipo = TFloat()
}
