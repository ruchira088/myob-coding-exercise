package com.ruchira

case class PaySlip(
    fullName: Name,
    grossIncome: Int,
    incomeTax: Int,
    netIncome: Int,
    superAmount: Int
)

object PaySlip
{
  def createPaySlip(input: Input): PaySlip =
  {
    PaySlip(Name("", ""), 0, 0, 0, 0)
  }
}
