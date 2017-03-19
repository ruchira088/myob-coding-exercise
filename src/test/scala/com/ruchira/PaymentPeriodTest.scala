package com.ruchira

import org.scalatest.FunSpec

class PaymentPeriodTest extends FunSpec
{
  describe("PaymentPeriod")
  {
    val TEST_VALUES = List(
      ("01 March – 31 March", Monthly),
      ("01 January - 14 January", Fortnightly),
      ("15 December 2016 - 14 January 2017", Monthly),
      ("01 February - 28 February", Monthly),
      ("20 March - 03 April", Fortnightly)
    )

    it("parse(String): PaymentPeriod")
    {
      TEST_VALUES.foreach(entry =>
      {
        val(input, output) = entry
        assertResult(output)(PaymentPeriod.parse(input).paymentCycle)
      })
    }
  }
}
