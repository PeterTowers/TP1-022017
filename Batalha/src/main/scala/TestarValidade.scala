object TestarValidade {

  def simOuNao (alvo : Int): Int = {
    var retorno = alvo

    while (retorno != 1 && retorno != 0) {
      println("Entrada invalida, digite 1 para sim ou 0 para nao.")
      retorno = scala.io.StdIn.readInt()
    }

    return(retorno)
  }

  def maiorMenor (alvo : Int, isso : Int, aquilo : Int): Int = {
    var retorno = alvo

    while (retorno > isso || retorno < aquilo) {
      println("Entrada invalida. Digite um valor entre " + aquilo + " e " + isso +".")
      retorno = scala.io.StdIn.readInt()
    }

    return(retorno)
  }

}
