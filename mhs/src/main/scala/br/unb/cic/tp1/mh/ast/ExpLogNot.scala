package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpLogNot(bool: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = bool.avaliar().asInstanceOf[ValorBooleano]

    return ValorBooleano(!v1.v)
  }

  override def verificaTipo: Tipo = {
    if (bool.verificaTipo == TBool)
      return TBool()

    return TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}