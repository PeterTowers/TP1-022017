package br.unb.cic.poo.gol

trait KeeperOfRules {
  private final val CONWAY          = 1
  private final val HIGHLIFE        = 2
  //private final val SEEDS           = 3
  private final val INVALID_OPTION  = 0

  var min_keep_alive    = -1
  var max_keep_alive    = -1
  var should_revive     = -1
  var max_should_revive = -1
  var high_life         = false

  /**
    * Metodo para o usuario escolher a regra que sera utilizada para computar a proxima geracao
    */
  def getRule: Unit = {
    var option = 0

    do{
      println("Which set of rules do you wish to use?\n\n")
      println("[1] Conway")
      println("[2] HighLife")
      //println("[3] Seeds")

      print("\n\n Rule: ")
      option = parseOption(scala.io.StdIn.readLine())
    }while (option == 0)

    option match {
			case CONWAY		=> setConway
			case HIGHLIFE => setHighLife
			//case SEEDS		=> setSeeds
			case _        => 0
		}

    def parseOption(option: String): Int = option match {
      case "1"  => CONWAY
      case "2"  => HIGHLIFE
      //case "3"  => SEEDS
      case _    => INVALID_OPTION
    }
  }

  /**
    * Regras originais do Conway
    */
  def setConway: Unit = {
    min_keep_alive  = 2
    max_keep_alive  = 3
    should_revive   = 3
  }

  /**
    * Regra de derivacao HighLife
    */
  def setHighLife: Unit = {
    min_keep_alive    = 2
    max_keep_alive    = 3
    should_revive     = 3
    max_should_revive = 6
    high_life         = true
  }

}
