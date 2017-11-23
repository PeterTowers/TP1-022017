package br.unb.cic.tp1.mh.ast

case class ExpMatSoma(lhs : Expressao, rhs : Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    return ValorInteiro(v1.v + v2.v)
  }

  override def verificaTipo: Tipo = {
    val t1 = lhs.verificaTipo
    val t2 = rhs.verificaTipo

    if (t1 == TInt && t2 == TInt)
      return TInt()

    else if (t1 == TFloat && t2 == TFloat)
      return TFloat()

    return TErro()
  }
}
