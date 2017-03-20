package com.ruchira

import java.io.{File, PrintWriter}

import com.ruchira.InputParser._

import scala.io.Source

object Main
{
  def main(args: Array[String]): Unit =
  {
    val output = List(PaySlip.HEADER) ++ parseInput(readInput("input.csv")).map(PaySlip.createPaySlip)

    writeToFile("output.csv", output.mkString("\n"))
  }

  /**
    * Reads the content of a file
    */
  def readInput(fileName: String): List[String] =
    Source.fromFile(fileName).getLines().toList

  /**
    * Writes to a file
    */
  def writeToFile(fileName: String, contents: String): Unit = {
    val filePath = new File(fileName) getAbsolutePath

    new PrintWriter(filePath) {
      write(contents)
      close()
    }
  }
}
