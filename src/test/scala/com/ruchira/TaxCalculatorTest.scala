package com.ruchira

import org.scalatest.FunSpec
import com.ruchira.Utils.testRunner

class TaxCalculatorTest extends FunSpec
{
  describe("TaxCalculator")
  {
    it("calculateTax(Double): Double")
    {
      val TEST_VALUES: List[(Double, Double)] = List(
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

      testRunner(TEST_VALUES, TaxCalculator.calculateTax)
    }
  }

}
