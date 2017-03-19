package com.ruchira

case class PaySlip(
    fullName: Name,
    paymentPeriod: PaymentPeriod,
    grossIncome: Int,
    incomeTax: Int,
    netIncome: Int,
    superAmount: Int
) {
  override def toString: String =
    s"${fullName.firstName} ${fullName.lastName},${paymentPeriod.displayString},${grossIncome},${incomeTax},${netIncome},${superAmount}"
}

object PaySlip
{
  def header = "Output (name, pay period, gross income, income tax, net income, super):"

  def createPaySlip(inputRow: InputRow): PaySlip =
  {
    val InputRow(name, annualSalary, superRate, paymentPeriod) = inputRow

    val getValueForCycle: (Double => Double) = paymentPeriod.paymentCycle.getValue

    def round(value: Double): Int = Math.round(value).toInt

    val grossIncome = round(getValueForCycle(annualSalary))
    val incomeTax = round(getValueForCycle(TaxCalculator.calculateTax(annualSalary)))

    PaySlip(name, paymentPeriod, grossIncome, incomeTax, grossIncome - incomeTax, round(grossIncome * superRate))
  }
}
