package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object FunnyString {


  def main(args: Array[String]) {

    val numTestCases = StdIn.readInt

    for (i <- 1 to numTestCases) {
      val input = StdIn.readLine().toCharArray
      findFunnyString(input)
    }
  }


  def findFunnyString(input: Array[Char]): Unit = {
    val length = input.length
    for (x <- 1 to length - 1) {

      if (math.abs(input(x) - input(x - 1)) != math.abs(input(length - x) - input(length - x - 1))) {
        println("Not Funny")
        return
      }
    }
    println("Funny")
  }


}

