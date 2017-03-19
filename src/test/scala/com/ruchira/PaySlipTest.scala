package com.ruchira

import org.scalatest.FunSpec

class PaySlipTest extends FunSpec
{
  describe("PaySlip")
  {
    it("createPaySlip(InputRow): PaySlip")
    {
      val TEST_VALUES = List(
        (InputRow(Name("David", "Rudd"), 60050, 0.09, PaymentPeriod(Monthly, "01 March – 31 March")),
          "David Rudd,01 March – 31 March,5004,922,4082,450"),
        (InputRow(Name("Ryan", "Chen"), 120000, 0.1, PaymentPeriod(Monthly, "01 March – 31 March")),
          "Ryan Chen,01 March – 31 March,10000,2696,7304,1000"),
        (InputRow(Name("Adam", "Ant"), 52000, 0.12, PaymentPeriod(Fortnightly, "01 January - 14 January")),
          "Adam Ant,01 January - 14 January,2000,325,1675,240"),
        (InputRow(Name("Bob", "Bat"), 100000, 0.01, PaymentPeriod(Fortnightly, "01 March - 14 March")),
          "Bob Bat,01 March - 14 March,3846,960,2886,38")
      )

      TEST_VALUES.foreach(entry =>
      {
        val (input, output) = entry
        assertResult(output)(PaySlip.createPaySlip(input).toString)
      })
    }
  }
}
