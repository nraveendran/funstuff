package com.mine

import scala.io.StdIn
import scala.util.Sorting

/**
 * Created by nidhish on 8/22/15.
 */
object ShortSticks {


  def findShortStickNumbers(sticks: Array[Int]): Unit = {


    Sorting.quickSort(sticks);


    var currentStickLength = -1

    var remainingSticks = sticks.length
    for (x <- 0 to sticks.length - 1) {
      if (sticks(x) != currentStickLength) {
        println(remainingSticks)
        currentStickLength = sticks(x)
      }
      remainingSticks -= 1
    }

    if (remainingSticks > 0) {
      println(remainingSticks)
    }

  }

  def main(args: Array[String]) {

    val numberOfDigits = StdIn.readInt




    val inputIntegers = StdIn.readLine().split(" ").map(_.toInt)

    findShortStickNumbers(inputIntegers)


  }


}

