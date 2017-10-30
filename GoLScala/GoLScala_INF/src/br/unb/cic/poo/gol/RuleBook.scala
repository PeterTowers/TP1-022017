package br.unb.cic.poo.gol

class RuleBook(rules: Rules) extends GameEngine {

  def shouldKeepAlive(i: Int, j: Int): Boolean = rules.shouldKeepAlive(i, j)
  def shouldRevive(i: Int, j: Int): Boolean = rules.shouldRevive(i, j)

}