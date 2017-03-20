package com.ruchira

import org.scalatest.FunSpec
import com.ruchira.Utils.testRunner

class InputParserTest extends FunSpec
{
  describe("InputParser")
  {
    it("parseInput(List[String]): List[InputRow]")
    {
      val EXPECTED_INPUT_ROW = InputRow(Name("John", "Smith"), 105000, 0.095, PaymentPeriod(Monthly, "15 March - 14 April"))

      val TEST_VALUES: List[List[String]] = List(
        List(
          "Input (first name, last name, annual salary, super rate (%), payment start date):",
          "John,Smith,105000,9.5%,15 March - 14 April"
        ),
        List(
          "Input (first name, annual salary, super rate (%), payment start date, last name):",
          "John,105000,9.5%,15 March - 14 April,Smith"
        ),
        List(
          "Input (annual salary, first name, super rate (%), payment start date, last name):",
          "105000,John,9.5%,15 March - 14 April,Smith"
        ),
        List(
          "Input (super rate (%), annual salary, first name, payment start date, last name):",
          "9.5%,105000,John,15 March - 14 April,Smith"
        ),
        List(
          "Input (payment start date, super rate (%), annual salary, first name, last name):",
          "15 March - 14 April,9.5%,105000,John,Smith"
        )
      )

      testRunner(
        TEST_VALUES.map((_, EXPECTED_INPUT_ROW)),
        (inputLines: List[String]) => InputParser.parseInput(inputLines).head
      )
    }
  }

}
