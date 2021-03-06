package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.exceptions.ExpressaoInvalida
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpRelMaior(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    if (lhs.verificaTipo != rhs.verificaTipo) throw ExpressaoInvalida()

    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    if (v1.v > v2.v) ValorBooleano(true) else ValorBooleano(false)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt() && rhs.verificaTipo == TInt()) TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}

case class ExpRelMaiorIg(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    if (lhs.verificaTipo != rhs.verificaTipo) throw ExpressaoInvalida()

    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    if (v1.v >= v2.v) ValorBooleano(true) else ValorBooleano(false)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt() && rhs.verificaTipo == TInt()) TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}