package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpMatMult(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    ValorInteiro(v1.v * v2.v)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt() && rhs.verificaTipo == TInt()) return TInt()
    else if (lhs.verificaTipo == TFloat() || rhs.verificaTipo == TFloat()) return TFloat()

    TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}
