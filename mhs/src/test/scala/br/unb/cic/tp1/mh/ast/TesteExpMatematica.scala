package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteExpMatematica extends FlatSpec with Matchers {

  behavior of "A sum"
  it should "be evaluated to 15 in (5 + 10)" in {

    val val5  = ValorInteiro(5)
    val val10 = ValorInteiro(10)

    val soma = ExpMatSoma(val5, val10)

    soma.avaliar() should be (ValorInteiro(15))
  }

  behavior of "A multiplication"
  it should "be evaluated to 72 in (6 * 12)" in {

    val val6  = ValorInteiro(6)
    val val12 = ValorInteiro(12)

    val mult = ExpMatMult(val6, val12)

    mult.avaliar() should be (ValorInteiro(72))
  }

  behavior of "A subtraction"
  it should "be evaluated to -7 in (7 - 14)" in {

    val val7  = ValorInteiro(7)
    val val14 = ValorInteiro(14)

    val subt = ExpMatSubt(val7, val14)

    subt.avaliar() should be (ValorInteiro(-7))
  }

  behavior of "A division"

  it should "be evaluated to 0 in (8 / 16)" in {

    val val8  = ValorInteiro(8)
    val val16 = ValorInteiro(16)

    val soma = ExpMatDiv(val8, val16)

    soma.avaliar() should be (ValorInteiro(0))
  }

}
