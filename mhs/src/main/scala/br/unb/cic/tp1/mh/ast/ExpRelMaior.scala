package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpRelMaior(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    val v3 = v1.asInstanceOf[Int]
    val v4 = v2.asInstanceOf[Int]

    if (v3 > v4) return ValorBooleano(true) else ValorBooleano(false)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) return TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}

case class ExpRelMaiorIg(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    val v3 = v1.asInstanceOf[Int]
    val v4 = v2.asInstanceOf[Int]

    if (v3 >= v4) return ValorBooleano(true) else ValorBooleano(false)
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) return TBool() else TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}