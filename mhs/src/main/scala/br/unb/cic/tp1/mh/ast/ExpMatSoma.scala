package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpMatSoma(lhs : Expressao, rhs : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.v + v2.v)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt() && rhs.verificaTipo == TInt()) TInt()
    else if (lhs.verificaTipo == TFloat() || rhs.verificaTipo == TFloat()) TFloat()

    TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}
