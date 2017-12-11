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

  behavior of "PPVisitor in an IF, THEN expression"
  ignore should "be evaluated to IF 12 >= 3 THEN (12 / 3)" in {
    val ifThen = ExpIfThenElse(ExpRelMaiorIg(ValorInteiro(12), ValorInteiro(3)),
                                ExpMatDiv(ValorInteiro(12), ValorInteiro(3)))

    val d = new PPVisitor()

    ifThen.aceitar(d)

    println(d.sb.toString)

    d.sb.toString should be ("IF 12 >= 3 THEN (12 / 3)")
  }

  behavior of "PPVisitor in an IF, THEN, ELSE expression"
  ignore should "be evaluated as IF 12 < 3 THEN 3 ELSE 12 - 3" in {
    val v3  = ValorInteiro(3)
    val v12 = ValorInteiro(12)

    val ifThenElse = ExpIfThenElse(ExpRelMenor(v12, v3), v3, ExpMatSubt(v12, v3))

    val e = new PPVisitor()

    ifThenElse.aceitar(e)

    println(e.sb.toString)

    e.sb.toString should be ("IF 12 < 3 THEN 3 ELSE 12 - 3")
  }

  behavior of "PPVisitor in a LAMBDA expression"
  ignore should "be evaluated as LAMBDA (((x) + 1)5)" in {
    val v1 = ValorInteiro(1)
    val v5 = ValorInteiro(5)

    val lambda  = new ExpLambda("x", TInt(), ExpMatSoma(ExpRef("x"), ValorInteiro(1)))
    val app     = new ExpAplicacaoLambda(lambda, ValorInteiro(5))

    val f = new PPVisitor()

    app.aceitar(f)

    println(f.sb.toString)

    f.sb.toString should be ("(((x) + 1)5)")
  }
}