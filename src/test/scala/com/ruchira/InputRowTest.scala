package com.ruchira

import org.scalatest.FunSpec

class InputRowTest extends FunSpec
{
  describe("InputRow")
  {
    it("parse(String): InputRow")
    {
      print(InputRow.parse("David,Rudd,60050,9%,01 March - 31 March"))
    }
  }
}
