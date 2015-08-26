package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object UtopianTree {


  def calcualateHeight(numberOfCycles: Int) = {
    var startHeight = 1
    var isSpring = true

    for (_ <- 1 to numberOfCycles) {
      if (isSpring) {
        startHeight *= 2
        isSpring = false
      } else {

        startHeight += 1
        isSpring = true

      }

    }

    println(startHeight)
  }

  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt

    for (i <- 1 to numberOfTests) {
      val numberOfCycles = StdIn.readInt()

      calcualateHeight(numberOfCycles)
    }

  }


}

//25

// 25 * 24 * 23