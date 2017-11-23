package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteLogica extends FlatSpec with Matchers {

  behavior of "A NOT expression"

  it should "return the opposite of what was given as its parameter." in {
    val v1 = ValorBooleano(true)

    val not = ExpLogNot(v1)

    not.avaliar() should be (ValorBooleano(false))
  }

  behavior of "An AND expression"

  it should "evaluate both sides of an expression and return TRUE only when both sides are TRUE" in {
    val v1 = ValorBooleano(true)
    val v2 = ValorBooleano(true)

    val and = ExpLogAnd(v1, v2)

    and.avaliar() should be (ValorBooleano(true))
  }

  behavior of "An OR expression"

  it should "evaluate both sides of an expression and return TRUE when, at least, one of the sides is TRUE" in {
    val v1 = ValorBooleano(false)
    val v2 = ValorBooleano(true)

    val or = ExpLogOr(v1, v2)

    or.avaliar() should be (ValorBooleano(true))
  }

}
