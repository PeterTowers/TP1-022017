package br.unb.cic.tp1.mh.memoria

import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.ast._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Ambiente {

  /* -----Ambiente de memoria para variaveis----- */
  private val stack = ListBuffer[mutable.HashMap[String, Valor]]()

  def iniciar(): Unit = {
    stack.clear()
    stack += new mutable.HashMap[String, Valor]()
  }

  def atualiza(variavel : String, valor : Valor): Unit = {
    if(stack.isEmpty) {
      stack += new mutable.HashMap[String, Valor]
    }

    stack += mutable.HashMap(variavel -> valor)
  }

  def consulta(variavel : String) : Valor = {
    if(stack.nonEmpty) return stack.last(variavel)

    throw VariavelNaoDeclaradaException()
  }

  def consultaTipo(variavel: String) : Tipo = {
    if (stack.nonEmpty) return stack.last(variavel).verificaTipo

    throw VariavelNaoDeclaradaException()
  }

  def novoAmbiente(ambiente: mutable.HashMap[String, Valor]): Unit = {
    stack += ambiente
  }

  def ambienteAtual() : mutable.HashMap[String, Valor] = {
    if (stack.isEmpty) {
      stack += new mutable.HashMap[String, Valor]()
    }
    return stack.last
  }

  def removeAmbiente(): Unit = stack.trimEnd(1)

  /* ---------------------------------------------------------------------------------------------------------------- */
  /* -----Ambiente de memoria para funcoes----- */
  private val funcoesDeclaradas = new mutable.HashMap[String, DecFuncao]

  def declararFuncao(decFuncao: DecFuncao): Unit = {
    funcoesDeclaradas += (decFuncao.nome -> decFuncao)
  }

  def recuperarFuncao(nome: String) = funcoesDeclaradas(nome)

  def novoAmbiente(): Unit = {
    novoAmbiente(new mutable.HashMap[String, Valor]())
  }

}