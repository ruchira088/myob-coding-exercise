package com.ruchira

import org.scalatest.FunSpec
import com.ruchira.TaxCalculator.calculateTax

class TaxCalculatorTest extends FunSpec
{
  describe("TaxCalculator")
  {
    it("calculateTax(Double): Double")
    {
      assertResult(11047)(Math.round(calculateTax(60000)))
      assertResult(24947)(Math.round(calculateTax(100000)))
      assertResult(0)(calculateTax(18200))
      assertResult(0.19)(calculateTax(18201))
      assertResult(54547)(Math.round(calculateTax(180000)))
    }
  }

}
