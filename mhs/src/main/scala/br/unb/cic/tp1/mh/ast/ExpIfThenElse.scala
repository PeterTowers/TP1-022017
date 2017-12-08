package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpIfThenElse(se: Expressao, entao: Expressao, casoContra: Expressao = ValorVazio(null)) extends Expressao {

  private val phi = se.avaliar().asInstanceOf[ValorBooleano]

  override def avaliar(): Valor = if (phi.v) entao.avaliar() else casoContra.avaliar()

  override def verificaTipo: Tipo = {

    if (se.verificaTipo == TBool()) {
      if (phi.v) entao.verificaTipo
      else casoContra.verificaTipo
    }

    return TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)

}
