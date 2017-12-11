package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.memoria.Ambiente
import br.unb.cic.tp1.mh.visitors.Visitor

class ExpAplicacaoNomeada(val nome: String, val argumentoAtual : Expressao*) extends Expressao {
  var tipo: Tipo = TErro()

  override def avaliar(): Valor = {
    val decFuncao = Ambiente.recuperarFuncao(nome)

    val variaveis = decFuncao.argFormal.toArray
    val valores   = argumentoAtual.toArray

    //if (variaveis.size != valores.size) throw VariavelNaoDeclaradaException()

    Ambiente.novoAmbiente()
    for(i <- variaveis.indices)
      Ambiente.atualiza(variaveis(i), valores(i).avaliar())

    val res = decFuncao.corpo.avaliar()
    tipo = res.verificaTipo

    Ambiente.removeAmbiente()

    return res
  }

  override def verificaTipo: Tipo = tipo

  override def aceitar(v: Visitor): Unit = v.visitar(this)
}