object GameInterface {
  var controle = -1

  println("\nBem vindo ao programa Batalha Nautica!\nEste programa simula o jogo Batalha Naval, com a opcao de " +
    "preencher o tabuleiro automaticamente.")
  println("Deseja jogar? (Sim: 1 | Nao: 0)")

  controle = scala.io.StdIn.readInt()

  controle = TestarValidade.simOuNao(controle)

  while (controle == 1) {
    //chamar funcao para posicionar as embarcacoes
    println("Deseja posicionar seus navios de forma aleatoria? (Sim: 1 | Nao: 0)")
    controle = scala.io.StdIn.readInt()
    controle = TestarValidade.simOuNao(controle)

    if (controle == 1)
      //PosicionaAle
    else
      //PosicionaManual

    println("Deseja jogar novamente? (Sim: 1 | Nao: 0)")
    controle = scala.io.StdIn.readInt()

    controle = TestarValidade.simOuNao(controle)

    if (controle == 0) {
      println("Obrigado por jogar e volte sempre!")
      System.exit(0)
    }
  }

  println("Obrigado por usar o programa!")

}
