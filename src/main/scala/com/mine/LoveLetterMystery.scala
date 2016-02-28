package com.mine

import scala.io.StdIn


object LoveLetterMystery {


  def findNumberOfReductions(firstCharArray: Array[Char]): Integer = {

    var totalReductions = 0
    val endIndex = firstCharArray.length - 1
    for (index <- 0 to (firstCharArray.length / 2) - 1) {
      totalReductions += Math.abs(firstCharArray(index) - firstCharArray(endIndex - index))
    }


    totalReductions

  }

  def main(args: Array[String]) {

    val numTest = StdIn.readInt()





    for (i <- 1 to numTest) {

      val firstCharArray = StdIn.readLine().toCharArray


      println(findNumberOfReductions(firstCharArray))

    }


  }


}


/*
2
hello
world
hi
world
*/
