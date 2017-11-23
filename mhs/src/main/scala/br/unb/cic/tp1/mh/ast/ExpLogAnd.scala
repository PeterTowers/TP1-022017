package br.unb.cic.tp1.mh.ast

case class ExpLogAnd(lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorBooleano]
    val v2 = rhs.avaliar().asInstanceOf[ValorBooleano]

    if (v1.v) return ValorBooleano(v2.v)
    else return ValorBooleano(false)
  }
}
