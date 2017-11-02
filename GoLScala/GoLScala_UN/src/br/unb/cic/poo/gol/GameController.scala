package br.unb.cic.poo.gol

//import java.io.{BufferedReader, InputStreamReader}

/**
 * Relaciona o componente View com o componente Model. 
 * 
 * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br
 */
object GameController {
  var rules = new RuleBook(new ConwayRules)

  /* Inicia o jogo, apresentando a opcao das regras e as opcoes disponiveis para o jogo */
  def start {
    GameView.configureRules

    GameView.update()
  }

  /* Encerra o jogo */
  def halt() {
    //oops, nao muito legal fazer sysout na classe Controller
    println("\n \n")
    Statistics.display
    System.exit(0)
  }

  /* Tenta ressuscitar uma celula */
  def makeCellAlive(i: Int, j: Int) {
    try {
      Originator.createMemento(rules.cells)
			rules.makeCellAlive(i, j)
			GameView.update()
		}
		catch {
		  case ex: IllegalArgumentException => {
		    println(ex.getMessage)
		  }
		}
  }

  /* Computa a proxima geracao */
  def nextGeneration {
    Originator.createMemento(rules.cells)
    rules.nextGeneration
    GameView.update()
  }

  /* Computa n geracoes automaticamente */
  def letItGo(generations: Int): Unit = {

    for (i <- 1 to generations) {
      Originator.createMemento(rules.cells)
      rules.nextGeneration

      if (i < generations) { // Garante que a chamada do GameView.update() fora do laco nao sera repetida.
        println("\nGeneration " + i + ":")
        GameView.update(false)
      }

      Thread.sleep(1000)
    }

    println("Generation " + generations + ":")
    GameView.update()
  }

  def undo: Unit = {
    val state = Originator.restoreMemento(rules.cells)

    for (i <- 0 until Main.height)
      for (j <- 0 until Main.width)
        rules.cells(i)(j) = state(i)(j)

    GameView.update()
  }
}