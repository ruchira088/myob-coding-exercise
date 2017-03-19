package com.ruchira

object TaxCalculator
{
  case class TaxBracket(lowerLimit: Double, percentage: Double)

  val taxBrackets: List[TaxBracket] = List(
    TaxBracket(180000, 45),
    TaxBracket(80000, 37),
    TaxBracket(37000, 32.5),
    TaxBracket(18200, 19),
    TaxBracket(0, 0)
  )

  def calculateTax(amount: Double): Double =
  {
    case class TaxStep(taxAmount: Double, remainingAmount: Double)

    val TaxStep(totalTax, _) = taxBrackets.foldLeft(TaxStep(0, amount))((taxStep, taxBracket) =>
    {
      if (taxStep.remainingAmount > taxBracket.lowerLimit)
      {
        val tax = (taxStep.remainingAmount - taxBracket.lowerLimit) * taxBracket.percentage / 100
        TaxStep(taxStep.taxAmount + tax, taxBracket.lowerLimit)
      }
      else
      {
        taxStep
      }
    })

    totalTax
  }
}
