package com.ruchira

object InputParser
{
  val headerColumnNames = List(
    "first name",
    "last name",
    "annual salary",
    "super rate (%)",
    "payment start date"
  )

  def parseHeaders(inputHeader: String): (String => List[String]) =
  {
    val header = inputHeader.substring(inputHeader.indexOf("(") + 1, inputHeader.lastIndexOf(")"))
    val headerColumns = header.split(",").toList.map( _.trim )

    val indexList: List[Int] = headerColumnNames.map(headerColumns.indexOf(_))

    def parser(line: String): List[String] =
    {
      val inputValues = line.split(",").toList
      indexList.map(inputValues(_))
    }

    parser
  }

  def parseInput(inputLines: List[String]): List[InputRow] =
    inputLines.tail.map(line => InputRow.parse(line, parseHeaders(inputLines.head)))
}
