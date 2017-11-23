package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException

case class ExpRef(variavel : String) extends Expressao {

  override def avaliar(): Valor = {
    try {
      return Ambiente.consulta(variavel)
    }
    catch {
      case ex: NoSuchElementException => throw VariavelNaoDeclaradaException()
    }
  }

  override def verificaTipo: Tipo = {
    try {
      return Ambiente.consultaTipo(variavel)
    }

    catch {
      case ex: NoSuchElementException => throw VariavelNaoDeclaradaException()
    }
  }

}
