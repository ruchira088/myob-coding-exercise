package com.ruchira

import org.scalatest.Assertions.assertResult

object Utils
{
  def testRunner[A, B](testValues: List[(A, B)], function: A => B): Unit =
  {
    testValues.foreach(value =>
    {
      val (input, output) = value

      assertResult(output)(function(input))
    })
  }

}
