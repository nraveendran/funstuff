package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object MansaStones {


  def calculateAndPrintPossibleFinalValues(numberOfStones: Int, aValue: Int, bValue: Int) = {



    var firstSet = scala.collection.mutable.ArrayBuffer[Int]()
    for (i <- 0 to numberOfStones -1) {

      firstSet += (i*aValue+(numberOfStones-1-i)*bValue)


    }


    println(firstSet.mkString(" "))



  }


  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt



    for (i <- 1 to numberOfTests) {
      val numberOfStones = StdIn.readInt
      val aValue = StdIn.readInt
      val bValue = StdIn.readInt

      val startValue = math.max(aValue,bValue)
      val endValue = math.min(bValue,aValue)
      calculateAndPrintPossibleFinalValues(numberOfStones, startValue, endValue)

    }

  }

}


