package com.ruchira

import org.scalatest.FunSpec
import com.ruchira.TaxCalculator.calculateTax

class TaxCalculatorTest extends FunSpec
{
  describe("TaxCalculator")
  {
    it("calculateTax(Double): Double")
    {
      val TEST_VALUES = List(
        (60000, 11047),
        (100000, 24947),
        (18200, 0),
        (18201, 0.19),
        (180000, 54547),
        (180001, 54547.45),
        (37000, 3572),
        (80000, 17547),
        (1000000, 423547)
      )

      TEST_VALUES.foreach(value =>
      {
        val(income, tax) = value
        assertResult(tax)(calculateTax(income))
      })
    }
  }

}
