package com.mine

import scala.io.StdIn


object GemStones {


  def main(args: Array[String]) {

    val numRocks = StdIn.readInt()
    var inputStr = StdIn.readLine()

    if (numRocks == 1) {
      println(0)
      return
    }


    var input = inputStr.toCharArray
    var finalStatus = findRocks(input)
    var currentStatus = 0

    for (i <- 2 to numRocks) {
      inputStr = StdIn.readLine()
      input = inputStr.toCharArray

      currentStatus = findRocks(input)

      finalStatus &= currentStatus

    }

    val numGems = Integer.bitCount(finalStatus)

    println(numGems)

  }


  def findRocks(input: Array[Char]): Int = {

    val length = input.length

    var i = 0;

    for (x <- 0 to length - 1) {

      i |= 1 << input(x).toLower - 'a'

    }

    i
  }

}

//3
//abcdde
//baccd
//eeabg

