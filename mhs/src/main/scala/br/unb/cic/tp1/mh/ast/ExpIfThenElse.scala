package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpIfThenElse(se: Expressao, entao: Expressao, casoContra: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val phi = se.avaliar().asInstanceOf[ValorBooleano]

    if(phi.v) entao.avaliar()
    else casoContra.avaliar()

  }

  override def verificaTipo: Tipo = {
    if(se.verificaTipo == ValorBooleano(true)) return entao.verificaTipo
    else if (se.verificaTipo == ValorBooleano(false)) return casoContra.verificaTipo

    return TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)

}
