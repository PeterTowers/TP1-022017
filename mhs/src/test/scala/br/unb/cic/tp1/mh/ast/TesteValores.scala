package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteValores extends FlatSpec with Matchers {

  behavior of "Um Valor"
  it should "An integer value 5 should be evaluated to 5" in {
    val val5 = ValorInteiro(5)

    val5.avaliar() should be (ValorInteiro(5))
  }

}
