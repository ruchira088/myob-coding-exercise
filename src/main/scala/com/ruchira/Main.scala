package com.ruchira

import java.io.{File, PrintWriter}

import com.ruchira.InputParser._

import scala.io.Source

object Main
{
  def main(args: Array[String]): Unit =
  {
    val output = List(PaySlip.header) ++ parseInput(readInput("input.csv")).map(PaySlip.createPaySlip)

    writeToFile("output.csv", output.mkString("\n"))
  }

  def readInput(fileName: String): List[String] =
    Source.fromFile(fileName).getLines().toList

  def writeToFile(fileName: String, contents: String): Unit = {
    val filePath = new File(fileName) getAbsolutePath

    new PrintWriter(filePath) {
      write(contents)
      close()
    }
  }
}
