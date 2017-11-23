package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

import br.unb.cic.tp1.exceptions.ExpressaoInvalida

case class ExpAplicacaoLambda(exp1 : Expressao, exp2 : Expressao) extends Expressao { 
  val t1
  override def avaliar(): Valor = {
    //println("- exp1: " + exp1)
    val v1 = exp1.avaliar()

    //println("- ambiente atual: " + Ambiente.ambienteAtual())
    //println("- Ambiente closure: " + v1.asInstanceOf[Closure].ambiente)

    v1 match {
      case Closure(v, c, ambiente) => {
        Ambiente.novoAmbiente(ambiente)
        Ambiente.atualiza(v, exp2.avaliar())
	      val res =  c.avaliar()
        Ambiente.removeAmbiente()
        return res
      }
      
      case _             => throw ExpressaoInvalida()
    } 
  }

  override def verificaTipo: Tipo = {

    val t2 = exp2.verificaTipo
  }
}
