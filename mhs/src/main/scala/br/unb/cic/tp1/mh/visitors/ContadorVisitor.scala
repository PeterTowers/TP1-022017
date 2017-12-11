package br.unb.cic.tp1.mh.visitors
import br.unb.cic.tp1.mh.ast._

class ContadorVisitor extends Visitor {

  var contador = 0

  /* -----Tipos de variaveis----- */

  override def visitar(exp: ValorInteiro): Unit = contador += 1

  override def visitar(exp: ValorFloat): Unit = contador += 1

  override def visitar(exp: ValorBooleano): Unit = contador += 1

  override def visitar(exp: Closure): Unit = {
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ValorVazio): Unit = { } // Deve ser vazio, mesmo, pois a expressao ValorVazio nao faz nada.

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes matematicas----- */

  override def visitar(exp: ExpMatSoma): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpMatSubt): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpMatMult): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpMatDiv): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes logicas----- */

  override def visitar(exp: ExpLogAnd): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpLogNot): Unit = contador += 1

  override def visitar(exp: ExpLogOr): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpIfThenElse): Unit = {}

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Expressoes relacionais----- */

  override def visitar(exp: ExpRelIgual): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpRelMaior): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpRelMaiorIg): Unit = {
    exp.lhs.aceitar(this)
    exp.rhs.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpRelMenor): Unit = { }    // Vazio, pois utiliza ExpRelMaior para determinar seu retorno.

  override def visitar(exp: ExpRelMenorIg): Unit = { }  // Vazio, pois utiliza ExpRelMaiorIg para determinar seu retorno.

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Funcoes----- */

  override def visitar(exp: ExpLet): Unit = {
    exp.expNomeada.aceitar(this)
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpLambda): Unit = {
    exp.corpo.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpAplicacaoLambda): Unit = {
    exp.exp1.aceitar(this)
    exp.exp2.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpAplicacaoNomeada): Unit = {
    exp.argumentoAtual.aceitar(this)
    contador += 1
  }

  override def visitar(exp: ExpRef): Unit = contador += 1

  override def visitar(exp: DecFuncao): Unit = { }

  /* ---------------------------------------------------------------------------------------------------------------- */
}