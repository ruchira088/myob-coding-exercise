package com.ruchira

import org.scalatest.FunSpec
import com.ruchira.Utils.testRunner

class InputRowTest extends FunSpec
{
  describe("InputRow")
  {
    it("parse(String): InputRow")
    {
      val TEST_VALUES = List(
        ("David,Rudd,60050,9%,01 March - 31 March",
          InputRow(Name("David", "Rudd"), 60050, 0.09, PaymentPeriod(Monthly, "01 March - 31 March"))),
        ("Ryan,Chen,120000,10%,01 March – 31 March",
          InputRow(Name("Ryan", "Chen"), 120000, 0.1, PaymentPeriod(Monthly, "01 March – 31 March"))),
        ("Adam,Ant,50000,12%,01 January - 14 January",
          InputRow(Name("Adam", "Ant"), 50000, 0.12, PaymentPeriod(Fortnightly, "01 January - 14 January")))
      )

      testRunner(TEST_VALUES, (input: String) => InputRow.parse(input))
    }
  }
}
