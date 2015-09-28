package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object AlternatingCharacters {


  def main(args: Array[String]) {

    val numTestCases = StdIn.readInt()

    for (i <- 1 to numTestCases) {
      val input = StdIn.readLine().toCharArray
      println(findAlternatingCharacters(input))
    }


  }


  def findAlternatingCharacters(input: Array[Char]): Int = {

    val length = input.length

    var currentChar = input(0)

    var numAlternatingChars = 0

    for (x <- 1 to length - 1) {
      if (currentChar == input(x)) numAlternatingChars += 1

      currentChar = input(x)
    }

    return numAlternatingChars

  }

}

