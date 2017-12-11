package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteValores extends FlatSpec with Matchers {

  behavior of "An integer value"
  it should "An integer value 5 should be evaluated to 5" in {
    val val5 = ValorInteiro(5)

    val5.avaliar() should be (ValorInteiro(5))
  }

  behavior of "A float value"
  it should "A float value 5.5 should be evaluated to 5.5" in {
    val val5 = ValorFloat(5.5f)

    val5.avaliar() should be (ValorFloat(5.5f))
  }

  behavior of "A boolean value"
  it should "A boolean value true should be evaluated to true" in {
    val val2 = ValorBooleano(true)

    val2.avaliar() should be (ValorBooleano(true))
  }

  behavior of "An empty value"
  it should "An empty value should be evaluated to empty value" in {
    val valVazio = ValorVazio()

    valVazio.avaliar() should be (ValorVazio())
  }
}
