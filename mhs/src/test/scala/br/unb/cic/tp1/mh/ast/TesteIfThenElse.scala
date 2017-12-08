package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteIfThenElse extends FlatSpec with Matchers {
  behavior of "An IF, THEN, ELSE expression"
  it should "Return (4) in IF (2 < 4) THEN (2 + 2) ELSE (2)"

  var v1 = ValorInteiro(2)
  val v2 = ValorInteiro(4)

  val ifThenElse = ExpIfThenElse(ExpRelMenor(v2, v1), ExpMatSoma(v1, v1))

  ifThenElse.avaliar() should be (v1)

}
