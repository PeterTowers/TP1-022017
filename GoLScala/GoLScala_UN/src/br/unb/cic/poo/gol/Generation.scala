package br.unb.cic.poo.gol

import Main.{height, width}

class Generation {
  var generationCells = Array.ofDim[Cell](height, width)
  var revivedCells  = 0
  var killedCells   = 0

  for (i <- 0 until height)
    for (j <- 0 until width)
      generationCells(i)(j) = new Cell

  def copyGen(currentGen: Generation) = {

    for (i <- 0 until height)
      for (j <- 0 until width)
        if (currentGen.generationCells(i)(j).isAlive)
          generationCells(i)(j).revive

    this.revivedCells  = currentGen.revivedCells
    this.killedCells   = currentGen.killedCells
  }

}
