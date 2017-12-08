package br.unb.cic.tp1.mh.visitors

import br.unb.cic.tp1.mh.ast._

trait Visitor {

  def visitar(exp: ValorFloat)          : Unit
  def visitar(exp: ValorInteiro)        : Unit
  def visitar(exp: ValorBooleano)       : Unit

  def visitar(exp: ExpLogAnd)           : Unit
  def visitar(exp: ExpIfThenElse)       : Unit
  def visitar(exp: ExpLogNot)           : Unit
  def visitar(exp: ExpLogOr)            : Unit

  def visitar(exp: ExpMatSoma)          : Unit
  def visitar(exp: ExpMatMult)          : Unit

  def visitar(exp: ExpRelIgual)         : Unit
  def visitar(exp: ExpRelMaior)         : Unit
  def visitar(exp: ExpRelMaiorIg)       : Unit
  def visitar(exp: ExpRelMenor)         : Unit
  def visitar(exp: ExpRelMenorIg)       : Unit

  def visitar(exp: ExpLet)              : Unit
  def visitar(exp: ExpLambda)           : Unit
  def visitar(exp: ExpAplicacaoLambda)  : Unit

  def visitar(exp: ExpAplicacaoNomeada) : Unit

  def visitar(exp: ExpRef)              : Unit

  def visitar(exp: Closure)             : Unit

}
