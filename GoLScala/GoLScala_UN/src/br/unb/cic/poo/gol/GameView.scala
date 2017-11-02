package br.unb.cic.poo.gol

import scala.io.StdIn.{readInt, readLine}

/**
 * Representa o componente View do GoL
 * 
 * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br
 */
object GameView {
	private final val CONWAY          = 1
	private final val HIGHLIFE        = 2
	//private final val SEEDS           = 3
  
	private final val LINE = "+-----+"
	private final val DEAD_CELL = "|     |"
	private final val ALIVE_CELL = "|  o  |"

	private final val INVALID_OPTION = 0
	private final val MAKE_CELL_ALIVE = 1
	private final val NEXT_GENERATION = 2
	private final val LET_IT_GO = 3
	private final val UNDO = 4
	private final val HALT = 5

	/**
		* Metodo para o usuario escolher a regra que sera utilizada para computar a proxima geracao
		*/
	def configureRules: Unit = {
			var option = 0

			do{
				println("Which set of rules do you wish to use?\n\n")
				println("[1] Conway")
				println("[2] HighLife")
				//println("[3] Seeds")

				print("\n\n Rule: ")
				option = parseOptions(scala.io.StdIn.readLine())
			}while (option == 0)

			option match {
				case CONWAY		=> { }
				case HIGHLIFE => GameController.rules = new RuleBook(new HighLifeRules)
				//case SEEDS		=> return SEEDS
				case _        => 0
			}

			def parseOptions(option: String): Int = option match {
				case "1"  => CONWAY
				case "2"  => HIGHLIFE
				//case "3"  => SEEDS
				case _    => INVALID_OPTION
			}
	}
  /**
	 * Atualiza o componente view (representado pela classe GameBoard),
	 * possivelmente como uma resposta a uma atualizacao do jogo.
	 */
	def update(shouldPrintOptions: Boolean = true) {
		printFirstRow
		printLine
		
		for(i <- (0 until Main.height)) {
		  for(j <- (0 until Main.width)) {
		    print(if (GameController.rules.isCellAlive(i, j))  ALIVE_CELL else DEAD_CELL);
		  }
		  println("   " + i)
		  printLine
		}
		if (shouldPrintOptions)
			printOptions
	}
  
  private def printOptions {
	  
	  var option = 0
	  println("\n")
	  
	  do{
	    println("Select one of the options: \n");
			println("[1] Make a cell alive");
			println("[2] Next generation");
			println("[3] Simulate a number of generations")
      println("[4] Undo");
      println("[5] Halt");
		
			print("\n Option: ");
			
			option = parseOption(readLine)
	  }while(option == 0)
	  
	  option match {
      case MAKE_CELL_ALIVE => makeCellAlive
      case NEXT_GENERATION => nextGeneration
			case LET_IT_GO => letItGo
      case UNDO => GameController.undo
      case HALT => halt
    }

    def parseOption(option: String): Int = option match {
      case "1" => MAKE_CELL_ALIVE
      case "2" => NEXT_GENERATION
      case "3" => LET_IT_GO
      case "4" => UNDO
      case "5" => HALT
      case _ => INVALID_OPTION
    }
	}
  
  private def makeCellAlive {
	  
	  var i = 0
	  var j = 0
	  
	  do {
      print("\n Inform the row number (0 - " + (Main.height - 1) + "): ")
      i = readInt
      
      print("\n Inform the column number (0 - " + (Main.width - 1) + "): ")
      j = readInt
      
    } while(!validPosition(i,j))
      
    GameController.makeCellAlive(i, j)
	}

  private def nextGeneration = GameController.nextGeneration
  private def halt = GameController.halt

	private def letItGo: Unit = {
    var generations = -1

		println("\n\nHow many generations do you want to simulate? (Max: 32767) (Type 0 to return)")
		generations = readInt()

		while (generations < 0) {
			print("Invalid input, try again: ")
			generations = readInt()
		}

		if (generations == 0)
			update(true)
		else
			GameController.letItGo(generations)
	}
	
  private def validPosition(i: Int, j: Int): Boolean = {
		println(i);
		println(j);
		i >= 0 && i < Main.height && j >= 0 && j < Main.width
	}
  
  /* Imprime uma linha usada como separador das linhas do tabuleiro */
	/*private*/ def printLine() {
	  for(j <- (0 until Main.width)) {
	    print(LINE)
	  }
	  println()
	}
  
  /*
	 * Imprime os identificadores das colunas na primeira linha do tabuleiro
	 */
	/*private*/ def printFirstRow {
		println("\n");
		
		for(j <- (0 until Main.width)) {
		  print("   " + j + "   ")
		}
		println()
	}
}