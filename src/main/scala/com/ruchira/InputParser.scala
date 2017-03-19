package com.ruchira

object InputParser
{
  def parseInput(inputLines: List[String]): List[InputRow] =
    inputLines.tail.map(InputRow.parse)
}
