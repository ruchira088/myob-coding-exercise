package com.ruchira

case class Input(
    name: Name,
    annualSalary: Int,
    superRate: Double,
    paymentStartDate: String
)

object Input
{
  def parse(line: String): Input =
  {
    val Array(firstName, lastName, annualSalary, superRate, paymentStartDate) = line.split(",")

    val name = Name(firstName, lastName)
    def parseSuperRate(rate: String): Double = rate.replaceAll("%", "").toDouble / 100

    Input(name, annualSalary.toInt, parseSuperRate(superRate), paymentStartDate)
  }
}

