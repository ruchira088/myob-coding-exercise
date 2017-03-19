package com.ruchira

import scala.io.Source

object InputParser
{
  def readInput(fileName: String): List[String] =
    Source.fromFile(fileName).getLines().toList

  def parseInput(inputLines: List[String]): List[InputRow] =
    inputLines.tail.map(InputRow.parse)
}
