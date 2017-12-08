package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ValorVazio(n: Null) extends ValorConcreto[Null](n) {

  override def verificaTipo: Tipo = TVazio()

  override def aceitar(v: Visitor): Unit = v.visitar(this)

}
