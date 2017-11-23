package br.unb.cic.tp1.mh.ast

import org.scalatest._
import br.unb.cic.tp1.exceptions.VariavelNaoDeclaradaException
import br.unb.cic.tp1.mh.memoria.Ambiente

class TesteExpLet extends FlatSpec with Matchers {

  behavior of "a let expression"

  it should "be evaluated to Valor(20) when let x = 10 in x + x" in {
    val let  = new ExpLet("x", ValorInteiro(10), ExpMatSoma( ExpRef("x"), ExpRef("x") ))


    let.avaliar() should be (ValorInteiro(20))
  }

  it should "be evaluated to Valor(30) when let x = 10 in let y = 20 in x + y" in {
    val let1 = new ExpLet("y", ValorInteiro(20), ExpMatSoma( ExpRef("x"), ExpRef("y") ))

    val let2 = new ExpLet("x", ValorInteiro(10), let1)

    let2.avaliar() should be (ValorInteiro(30))
  }

  it should "throw VariavelNaoDeclarada when let x = 10 in x + y" in {
    val let = new ExpLet("x", ValorInteiro(10), ExpMatSoma(ExpRef("x"), ExpRef("y")))

    intercept[VariavelNaoDeclaradaException] {
      let.avaliar()
    }
  }
}