package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpRelIgual(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    if (v1 == v2) return ValorBooleano(true) else ValorBooleano(false)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) return TBool()
    else return TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)

}
