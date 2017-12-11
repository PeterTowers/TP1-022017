package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.memoria.Ambiente
import org.scalatest._

class TesteAplicacaoNomeada extends FlatSpec with Matchers {

  behavior of "a named function DEF inc (x) = x + 1"

  it should "be evaluated to 16 when inc 1 " in {
    val inc = new DecFuncao("inc", ExpMatSoma(ExpRef("x"), ValorInteiro(1)), "x")

    Ambiente.declararFuncao(inc)

    val app1 = new ExpAplicacaoNomeada("inc", ExpMatSoma(ValorInteiro(5), ValorInteiro(10)))

    app1.avaliar() should be (ValorInteiro(16))

  }

  behavior of "a named function DEF mult (x, y) = x * y"

  it should "be evaluated to 756 when mult(18, 42) " in {
    val mult = new DecFuncao("inc", ExpMatMult(ExpRef("x"), ExpRef("y")), "x", "y")

    Ambiente.declararFuncao(mult)

    val app2 = new ExpAplicacaoNomeada("inc", ValorInteiro(18), ValorInteiro(42))

    app2.avaliar() should be (ValorInteiro(756))

  }

  behavior of "a named function DEF factorial (x) = IF x == 0 THEN 1 ELSE x*factorial(x-1)"

  it should "be evaluated to x!" in {
    val fact = new DecFuncao("factorial", ExpIfThenElse(ExpRelIgual(ExpRef("x"), ValorInteiro(0)),
                                                        ValorInteiro(1),
                                          new ExpAplicacaoNomeada("factorial", ExpMatSubt(ExpRef("x"), ValorInteiro(1)))),
                                          "x")

    Ambiente.declararFuncao(fact)

    val app3 = new ExpAplicacaoNomeada("inc", ValorInteiro(0))

    app3.avaliar() should be (ValorInteiro(1))

  }
}
