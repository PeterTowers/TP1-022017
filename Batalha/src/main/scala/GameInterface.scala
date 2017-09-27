object GameInterface {

  def  pushStartButton() : Int = {
    var control = - 1

    println ("\nBem vindo ao programa Batalha Nautica!\nEste programa simula o jogo Batalha Naval, com a opcao de preencher o tabuleiro automaticamente.")
    println ("Deseja jogar? (Sim: 1 | Nao: 0)")

    control = scala.io.StdIn.readInt ()

    control = TestarValidade.simOuNao (control)

    return control
  }

  def insertCoin() : Int = {
    var control = -1

    println("Deseja jogar novamente? (Sim: 1 | Nao: 0)")
    control = scala.io.StdIn.readInt()

    control = TestarValidade.simOuNao(control)

    return control
  }

  def gameOver() : Unit = {
    println("Obrigado por jogar e volte sempre!")
    System.exit(0)
  }

  def endGame() : Unit = {
    println("Obrigado por usar o programa!")
  }

}
