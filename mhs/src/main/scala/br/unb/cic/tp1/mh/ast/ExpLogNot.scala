package br.unb.cic.tp1.mh.ast

case class ExpLogNot(bool: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = bool.avaliar().asInstanceOf[ValorBooleano]

    return ValorBooleano(!v1.v)
  }
}