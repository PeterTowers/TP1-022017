package br.unb.cic.tp1.mh.ast

case class ValorInteiro(v : Integer) extends ValorConcreto[Int](v) {
  override def verificaTipo: Tipo = TInt()
}
