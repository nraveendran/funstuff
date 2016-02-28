package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object BiggerisGreater {


  def main(args: Array[String]) {

    val numTestCases = StdIn.readInt()

    for (i <- 1 to numTestCases) {
            val input = StdIn.readLine().toCharArray
//      val input = StdIn.readLine.split(" ").map(_.toInt)
      val inputString = input.mkString
      val output = findLexicographicHigherPermutation(input)

      if (output.equals(inputString)){
        println("no answer")
      }else{
        println(output)
      }
    }


  }

  //  https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
  //0 1 2 5 3 3 0
  def findLexicographicHigherPermutation(input: Array[Char]): String = {

    val lastIndex = input.length - 1;
    var rightIndex = input.length - 1;

    while (rightIndex >0   && ( input(rightIndex - 1) >= input(rightIndex) )) {
      rightIndex -= 1
    }

    if (rightIndex <= 0) {
      "no answer"
    } else {
      val pivotIndex = rightIndex - 1
      var nextMaxValueIndex = pivotIndex

      var nextMaxValue = Integer.MAX_VALUE
      val pivotValue = input(pivotIndex)
      for (i <- pivotIndex + 1 to lastIndex) {
        if (input(i) > pivotValue && input(i) <= nextMaxValue) {
          nextMaxValue = input(i)
          nextMaxValueIndex = i
        }
      }

      var temp = input(pivotIndex)
      input(pivotIndex) = input(nextMaxValueIndex)
      input(nextMaxValueIndex) = temp


      for (i <- 0 to ((lastIndex - pivotIndex ) / 2)-1) {
        temp = input(pivotIndex + 1 + i)
        input(pivotIndex + 1 + i) = input(lastIndex - i)
        input(lastIndex - i) = temp
      }

      input.mkString
    }


  }

}

