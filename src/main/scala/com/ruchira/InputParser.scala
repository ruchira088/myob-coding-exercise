package com.ruchira

object InputParser
{
  val HEADER_COLUMN_NAMES = List(
    "first name",
    "last name",
    "annual salary",
    "super rate (%)",
    "payment start date"
  )

  /**
    * Parses the input header and returns input value mapper function
    */
  def parseHeaders(inputHeader: String): (String => List[String]) =
  {
    val header = inputHeader.substring(inputHeader.indexOf("(") + 1, inputHeader.lastIndexOf(")"))
    val headerColumns = header.split(",").toList.map( _.trim )

    val indexList: List[Int] = HEADER_COLUMN_NAMES.map(headerColumns.indexOf(_))

    def parser(line: String): List[String] =
    {
      val inputValues = line.split(",").toList
      indexList.map(inputValues(_))
    }

    parser
  }

  /**
    * Parses a List of Strings(input header and values) and returns a List of InputRows
    */
  def parseInput(inputLines: List[String]): List[InputRow] =
    inputLines.tail.map(line => InputRow.parse(line, parseHeaders(inputLines.head)))
}
