package com.ruchira

case class InputRow(
    name: Name,
    annualSalary: Int,
    superRate: Double,
    paymentPeriod: PaymentPeriod
)

object InputRow
{
  def defaultParser(line: String) = line.split(",").toList

  /**
    * Parses a String and returns an InputRow
    *
    * @param line
    * @param lineParser
    * @return
    */
  def parse(line: String, lineParser: String => List[String] = defaultParser): InputRow =
  {
    val List(firstName, lastName, annualSalary, superRate, paymentStartDate) = lineParser(line)

    val name = Name(firstName, lastName)

    def parseSuperRate(rate: String): Double = rate.replaceAll("%", "").toDouble / 100

    InputRow(name, annualSalary.toInt, parseSuperRate(superRate), PaymentPeriod.parse(paymentStartDate))
  }
}

