object SetTable {
  val carrier     = new Ships("Porta-Avioes", 'P', 5, 1)
  val battleship  = new Ships("Encouracado", 'E', 4, 2)
  val cruiser     = new Ships("Cruzador", 'C', 3, 3)
  val submarine   = new Ships("Submarino", 'S', 3, 4)
  val destroyer   = new Ships("Contratorpedeiro", 'T', 2, 5)

  private var current: Ships = carrier

  def setRandom(a: Array[Char]): Array[Char] = {
    for (var x <- 0 to PositionShips.xsize) {
      for (var y <- 0 to PositionShips.ysize) {
        a(x)(y)(0) = '~'
        a(x)(y)(1) = 0
      }
    }

    var i = 0

    while (i < 5) {
      var j = scala.util.Random.nextInt() % PositionShips.xsize
      var k = scala.util.Random.nextInt() % PositionShips.ysize

      if ((j%2) == 0) { //Caso j seja par, a embarcacao sera posicionada na horizontal
        setHorizontal(j, k, a)
      }
      else {  //Caso j seja impar, a embarcacao sera posicionada na vertical

      }
    }



  }
  private def setHorizontal(x: Int, y: Int, array: Array[Char]): Array[Char] = {

    var flag = false
    if (x + current.size < PositionShips.ysize) {

      for (var j <- x to x+current.size) {
        if ('~' != array(j)(y)(0)) {
          flag = true
        }
      }

      if (flag == false) {
        for (var j <- x to x+current.size) {
          array(j)(y)(0) = current.desig
        }

      }
    }
  }
}