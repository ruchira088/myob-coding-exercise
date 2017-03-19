package com.ruchira

case class InputRow(
    name: Name,
    annualSalary: Int,
    superRate: Double,
    paymentPeriod: PaymentPeriod
)

object InputRow
{
  def parse(line: String): InputRow =
  {
    val List(firstName, lastName, annualSalary, superRate, paymentStartDate) = line.split(",").toList

    val name = Name(firstName, lastName)

    def parseSuperRate(rate: String): Double = rate.replaceAll("%", "").toDouble / 100

    InputRow(name, annualSalary.toInt, parseSuperRate(superRate), PaymentPeriod.parse(paymentStartDate))
  }
}

