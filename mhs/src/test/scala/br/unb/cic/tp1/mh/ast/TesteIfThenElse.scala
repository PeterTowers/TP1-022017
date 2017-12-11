package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteIfThenElse extends FlatSpec with Matchers {
  behavior of "An IF, THEN, ELSE expression"

  /* -----Teste do funcionamento da clausula THEN----- */
  it should "Return (x + x) in IF (x < y) THEN (x + x) ELSE (y)" in {

    val x = ValorInteiro(2)
    val y = ValorInteiro(4)

    val ifThenElse1 = ExpIfThenElse(ExpRelMenor(x, y), ExpMatSoma(x, x), y)
    val ifThenElse2 = ExpIfThenElse(ExpRelMenor(y, x), ExpMatSoma(x, x), y)

    ifThenElse1.avaliar() should be (ExpMatSoma(x, x).avaliar())

    ifThenElse2.avaliar() should be (y)
  }

  /* -----Teste do funcionamento da clausula ELSE----- */
  it should "Return (2 * x) in IF (x < y) THEN (2 * x) ELSE (y)" in {

    val x = ValorInteiro(2)
    val y = ValorInteiro(4)

    val ifThenElse2 = ExpIfThenElse(ExpRelMenor(y, x), ExpMatMult(x, ValorInteiro(2)), y)


    ifThenElse2.avaliar() should be (y)
  }

  /* -----Teste do funcionamento da expressao sem uma clausula ELSE definida----- */
  it should "Return ValorVazio in IF (z == 0) THEN (z / 666)" in {

    val z = ValorInteiro(-1)

    val ifThenElse3 = ExpIfThenElse(ExpRelIgual(z, ValorInteiro(0)), ExpMatDiv(z, ValorInteiro(666)))

    ifThenElse3.avaliar() should be (ValorVazio(null))
  }
}
