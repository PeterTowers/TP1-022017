package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpRelMenor(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = ExpRelMaior(rhs, lhs).avaliar()

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) return TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}

case class ExpRelMenorIg(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = ExpRelMaiorIg(rhs, lhs).avaliar()

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) return TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}