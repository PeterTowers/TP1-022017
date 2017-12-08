package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class PPVisitor extends Visitor {

  val sb = new StringBuilder("")

  override def visitar(exp: ValorInteiro): Unit = {
    sb.append(exp.v.toString)
  }

  override def visitar(exp: ValorBooleano): Unit = {
    sb.append(exp.v.toString)
  }

  override def visitar(exp: ExpMatSoma): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '+'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpLet): Unit = { }

  override def visitar(exp: ExpLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = { }

  override def visitar(exp: Closure): Unit = { }

  override def visitar(exp: ValorFloat): Unit = {}

  override def visitar(exp: ExpLogAnd): Unit = {}

  override def visitar(exp: ExpIfThenElse): Unit = {}

  override def visitar(exp: ExpLogNot): Unit = {}

  override def visitar(exp: ExpLogOr): Unit = {}

  override def visitar(exp: ExpMatMult): Unit = {}

  override def visitar(exp: ExpRelIgual): Unit = {}

  override def visitar(exp: ExpRelMaior): Unit = {}

  override def visitar(exp: ExpRelMaiorIg): Unit = {}

  override def visitar(exp: ExpRelMenor): Unit = {}

  override def visitar(exp: ExpRelMenorIg): Unit = {}
}