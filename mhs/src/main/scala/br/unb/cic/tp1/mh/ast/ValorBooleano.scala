package br.unb.cic.tp1.mh.ast

case class ValorBooleano(v : Boolean) extends ValorConcreto[Boolean](v) {
  override def verificaTipo: Tipo = TBool()
}
