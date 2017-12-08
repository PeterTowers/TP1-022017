package br.unb.cic.tp1.mh.ast
import br.unb.cic.tp1.exceptions.DivisaoPorZeroException
import br.unb.cic.tp1.mh.visitors.Visitor

case class ExpMatDiv (lhs: Expressao, rhs: Expressao) extends Expressao {

  override def avaliar(): Valor = {
    val v1 = lhs.avaliar().asInstanceOf[ValorInteiro]
    val v2 = rhs.avaliar().asInstanceOf[ValorInteiro]

    try ValorInteiro(v1.v / v2.v)

    catch {
      case ex: java.lang.ArithmeticException => throw DivisaoPorZeroException()
    }
  }

  override def verificaTipo: Tipo = {
    if (lhs.verificaTipo == TInt && rhs.verificaTipo == TInt) TInt()
    else if (lhs.verificaTipo == TFloat || rhs.verificaTipo == TFloat) TFloat()

    TErro()
  }

  override def aceitar(v: Visitor): Unit = v.visitar(this)

}
