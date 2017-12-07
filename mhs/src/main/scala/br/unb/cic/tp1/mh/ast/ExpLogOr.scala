package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpLogOr(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorBooleano]
    val v2 = rhs.avaliar().asInstanceOf[ValorBooleano]

    if (v1.v) return ValorBooleano(v1.v)
    else return ValorBooleano(v2.v)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TBool && rhs.verificaTipo == TBool) return TBool()

    return TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}