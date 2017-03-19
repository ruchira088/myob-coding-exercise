package com.ruchira

import scala.io.Source

object InputParser
{
  def parseInput(inputLines: List[String]): List[InputRow] =
    inputLines.tail.map(InputRow.parse)
}
