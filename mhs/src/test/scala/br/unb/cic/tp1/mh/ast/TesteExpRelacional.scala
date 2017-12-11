package br.unb.cic.tp1.mh.ast

import org.scalatest._

class TesteExpRelacional extends FlatSpec with Matchers {

  behavior of "An 'equals' expression"

  it should "return TRUE when 2 values are equal and false when they're not" in {

    val v1 = ValorInteiro(16)
    val v2 = ValorInteiro(11)

    val equal1 = ExpRelIgual(v1, ExpMatSoma(v2, ValorInteiro(5)))

    val equal2 = ExpRelIgual(v1, v2)

    equal1.avaliar() should be (ValorBooleano(true))

    equal2.avaliar() should be (ValorBooleano(false))
  }

  behavior of "Greater than expression"

  it should "return TRUE when the left sided argument is greater than the right sided one" in {

    val v1 = ValorInteiro(19)
    val v2 = ValorInteiro(91)

    val greater1 = ExpRelMaior(v2, v1)

    val greater2 = ExpRelMaior(v1, v2)

    greater1.avaliar() should be (ValorBooleano(true))

    greater2.avaliar() should be (ValorBooleano(false))
  }

  behavior of "Greater than or equal expression"

  it should "return TRUE when the left sided argument is greater than or equal the right sided one" in {

    val v1 = ValorInteiro(14)
    val v2 = ValorInteiro(59)

    val greaterE1 = ExpRelMaiorIg(v2, v1)

    val greaterE2 = ExpRelMaiorIg(v1, ExpMatSubt(v2, ValorInteiro(45)))

    val greaterE3 = ExpRelMaior(v1, v2)

    greaterE1.avaliar() should be (ValorBooleano(true))

    greaterE2.avaliar() should be (ValorBooleano(true))

    greaterE3.avaliar() should be (ValorBooleano(false))
  }

  behavior of "Less than expression"

  it should "return TRUE when the right sided argument is greater than the left sided one" in {

    val v1 = ValorInteiro(13)
    val v2 = ValorInteiro(44)

    val less1 = ExpRelMenor(v1, v2)

    val less2 = ExpRelMenor(v2, v1)

    less1.avaliar() should be (ValorBooleano(true))

    less2.avaliar() should be (ValorBooleano(false))
  }

  behavior of "Less than or equal expression"

  it should "return TRUE when the right sided argument is greater than or equal the left sided one" in {

    val v1 = ValorInteiro(17)
    val v2 = ValorInteiro(51)

    val lessE1 = ExpRelMenorIg(v1, v2)

    val lessE2 = ExpRelMenorIg(v1, ExpMatSubt(v2, ValorInteiro(34)))

    val lessE3 = ExpRelMenorIg(v2, v1)

    lessE1.avaliar() should be (ValorBooleano(true))

    lessE2.avaliar() should be (ValorBooleano(true))

    lessE3.avaliar() should be (ValorBooleano(false))
  }
}
