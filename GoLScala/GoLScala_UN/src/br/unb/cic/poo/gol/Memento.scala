package br.unb.cic.poo.gol

import Main.{height, width}

class Memento {
  //private val generation = new Memento

  var generationCells = Array.ofDim[Cell](height, width)
  var revivedCells  = 0
  var killedCells   = 0

  for (i <- 0 until height) {
    for (j <- 0 until width) {
      generationCells(i)(j) = new Cell
    }
  }

  def setGeneration(currentGen: Array[Array[Cell]], revivedCells: Int, killedCells: Int) = {
    for (i <- 0 until height) {
      for (j <- 0 until width) {
        if (currentGen(i)(j).isAlive)
          generationCells(i)(j).revive
        else
          generationCells(i)(j).kill
      }
    }

    this.revivedCells  = revivedCells
    this.killedCells   = killedCells
  }

  //def getGeneration: Memento = generation
}