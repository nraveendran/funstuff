package com.mine

import scala.io.StdIn

/*

if a < b

The sequence is

ia + nb-1b-ib
ia+1a + nb-2b-ib

Difference is
a - b

First of the sequence is

0a + n-1b

 */
object MansaStonesBetter {


  def calculateAndPrintPossibleFinalValues(numberOfStones: Int, aValue: Int, bValue: Int) = {


    var firstSet = scala.collection.mutable.ArrayBuffer[Int]()
    var currentValue = math.min(aValue, bValue) * (numberOfStones - 1)
    var difference = math.abs(aValue - bValue)
    firstSet += currentValue;
    for (i <- 1 to numberOfStones - 1) {

      firstSet += currentValue + difference
      currentValue += difference

    }


    println(firstSet.mkString(" "))


  }


  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt



    for (i <- 1 to numberOfTests) {
      val numberOfStones = StdIn.readInt
      val aValue = StdIn.readInt
      val bValue = StdIn.readInt

      calculateAndPrintPossibleFinalValues(numberOfStones, aValue, bValue)

    }


  }
}


