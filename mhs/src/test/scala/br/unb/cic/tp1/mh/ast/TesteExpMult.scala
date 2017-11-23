package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteExpMult extends FlatSpec with Matchers {

  behavior of "a multiplication"
  it should  "be evaluated to ValorInteiro(25) when ExpMult(5, 5)" in {
    val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val mult = ExpMatMult(val5, val10)

    mult.avaliar() should be (ValorInteiro(50))
  }



}
