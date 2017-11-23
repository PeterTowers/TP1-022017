package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

class ExpLambda(val id : String, val corpo: Expressao, val tipoArgumento: Tipo) extends Expressao {

  override def avaliar(): Valor = {
     return Closure(id, corpo, Ambiente.ambienteAtual())
  }

  override def verificaTipo: Tipo = {
    val t1 = tipoArgumento
    val t2 = corpo.verificaTipo

    return TArr(t1, t2)
  }
  
}
