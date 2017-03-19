package com.ruchira

import org.joda.time.{DateTime, Duration}
import org.joda.time.format.DateTimeFormat

sealed trait PaymentCycle {
  def perform(annualValue: Int): Double
}

case object Monthly extends PaymentCycle
{
  override def perform(annualValue: Int): Double = annualValue / 12
}

case object Fortnightly extends PaymentCycle
{
  override def perform(annualValue: Int): Double = annualValue / 26
}

case class PaymentPeriod(paymentCycle: PaymentCycle, displayString: String)
{
  override def toString: String = displayString
}

object PaymentPeriod
{
  val DATE_SEPARATOR_REGEX = "–|-"
  val DATE_FORMAT_PATTERNS = List("dd MMMM yyyy", "dd MMMM")

  def getPaymentCycle(startDate: DateTime, endDate: DateTime): PaymentCycle =
  {
    new Duration(startDate, endDate).getStandardDays match {
      case days if days > 27 && days < 32 => Monthly
      case days if days > 10 && days < 15 => Fortnightly
      case _ => throw new Error("Unable to determine payment cycle")
    }
  }

  def parse(inputString: String): PaymentPeriod =
  {

    def parseDate(dateString: String, dateFormats: List[String]): DateTime =
    {
      if(dateFormats.isEmpty)
      {
        throw new Error(s"Unable to parse date: ${dateString}")
      } else {
        try {
          DateTime.parse(dateString, DateTimeFormat.forPattern(dateFormats.head))
        }
        catch {
          case _: IllegalArgumentException => parseDate(dateString, dateFormats.tail)
        }
      }
    }

    val List(startDate, endDate) = inputString.split(DATE_SEPARATOR_REGEX).toList
      .map(dateString => parseDate(dateString.trim, DATE_FORMAT_PATTERNS))

    PaymentPeriod(paymentCycle = getPaymentCycle(startDate, endDate), inputString)
  }

}