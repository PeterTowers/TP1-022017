package br.unb.cic.tp1.mh.ast

import br.unb.cic.tp1.mh.visitors.PPVisitor

import org.scalatest._

class TestePPVisitor extends  FlatSpec with Matchers{

  behavior of "PPVisitor in a sum"
  it should "be evaluated to (3 + 4) + 5) when (3+4)+5" in {
    val soma = ExpMatSoma(ExpMatSoma(ValorInteiro(3), ValorInteiro(4)),
      ValorInteiro(5))

    val a = new PPVisitor()

    soma.aceitar(a)

    println(a.sb.toString)

    a.sb.toString should be ("((3 + 4) + 5)")
  }

  behavior of "PPVisitor in a LET expression"
  ignore should "be evaluated to LET x = 2 IN x * 4" in {
    val let = new ExpLet("x", ValorInteiro(2), ExpMatMult(ExpRef("x"), ValorInteiro(4)))

    val b = new PPVisitor()

    let.aceitar(b)

    println(b.sb.toString)

    b.sb.toString should be ("LET x = 2 IN x * 4")
  }

  behavior of "PPVisitor in an OR expression"
  it should "be evaluated to true OR false" in {
    val and = ExpLogOr(ValorBooleano(true), ValorBooleano(false))

    val c = new PPVisitor()

    and.aceitar(c)

    println(c.sb.toString)

    c.sb.toString should be ("(true OR false)")
  }

}