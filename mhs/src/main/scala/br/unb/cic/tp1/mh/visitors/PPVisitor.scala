package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class PPVisitor extends Visitor {

  val sb = new StringBuilder("")

  /* -----Tipos de variaveis----- */

  override def visitar(exp: ValorInteiro): Unit = sb.append(exp.v.toString)

  override def visitar(exp: ValorFloat): Unit = sb.append(exp.v.toString)

  override def visitar(exp: ValorBooleano): Unit = sb.append(exp.v.toString)

  override def visitar(exp: Closure): Unit = { }

  override def visitar(exp: ValorVazio): Unit = { } // Nao deve fazer nada, pois ValorVazio nao faz nada.

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes matematicas----- */

  override def visitar(exp: ExpMatSoma): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '+'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpMatSubt): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '-'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpMatMult): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '*'
    exp.rhs.aceitar(this)
    sb += ')'}

  override def visitar(exp: ExpMatDiv): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb += '/'
    exp.rhs.aceitar(this)
    sb += ')'
  }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes logicas----- */

  override def visitar(exp: ExpLogAnd): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append("AND")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpLogNot): Unit = {
    sb += '('
    exp.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpLogOr): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append("OR")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpIfThenElse): Unit = { }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes relacionais----- */

  override def visitar(exp: ExpRelIgual): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append("==")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMaior): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(">")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMaiorIg): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(">=")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMenor): Unit = { }    // Vazio pois seu funcionamento eh implementado por ExpRelMaior.

  override def visitar(exp: ExpRelMenorIg): Unit = { }  // Vazio pois seu funcionamento eh implementado por ExpRelMaiorIg.

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Funcoes----- */

  override def visitar(exp: ExpLet): Unit = { }

  override def visitar(exp: ExpLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoLambda): Unit = { }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = { }

  override def visitar(exp: DecFuncao): Unit = { }

  /* ---------------------------------------------------------------------------------------------------------------- */
}