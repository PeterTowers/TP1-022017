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
    sb.append(" + ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpMatSubt): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" - ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpMatMult): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" * ")
    exp.rhs.aceitar(this)
    sb += ')'}

  override def visitar(exp: ExpMatDiv): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" / ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes logicas----- */

  override def visitar(exp: ExpLogAnd): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" AND ")
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
    sb.append(" OR ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpIfThenElse): Unit = {
    sb.append("IF ")
    exp.se.aceitar(this)
    sb.append(" THEN ")
    sb.append(exp.entao.aceitar(this))

    if (exp.casoContra != ValorVazio()) {
      sb.append(" ELSE ")
      sb.append(exp.casoContra.aceitar(this))
    }
  }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes relacionais----- */

  override def visitar(exp: ExpRelIgual): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" == ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMaior): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" > ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMaiorIg): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" >= ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMenor): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" < ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  override def visitar(exp: ExpRelMenorIg): Unit = {
    sb += '('
    exp.lhs.aceitar(this)
    sb.append(" <= ")
    exp.rhs.aceitar(this)
    sb += ')'
  }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Funcoes----- */

  override def visitar(exp: ExpLet): Unit = {
    sb.append("LET ")
    sb.append(exp.id)
    sb.append(" = ")
    sb.append(exp.expNomeada.aceitar(this))
    sb.append(" IN ")
    sb.append(exp.corpo.aceitar(this))
  }

  override def visitar(exp: ExpLambda): Unit = {
    sb += '('
    sb += '('
    sb.append(exp.id)
    sb += ')'
    sb.append(" -> ")
    sb.append(exp.corpo.aceitar(this))
    sb += ')'
  }

  override def visitar(exp: ExpAplicacaoLambda): Unit = {
    sb += '('
    sb.append(exp.exp1.aceitar(this))
    sb += ')'
    sb.append(exp.exp2.aceitar(this))
  }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = { }

  override def visitar(exp: ExpRef): Unit = {
    sb.append(exp.variavel)
  }

  override def visitar(exp: DecFuncao): Unit = { }

  /* ---------------------------------------------------------------------------------------------------------------- */
}