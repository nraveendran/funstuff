package com.mine

import scala.io.Source

/**
 * Created by nidhish on 8/22/15.
 */
object BiggerisGreaterFromFile {


  def main(args: Array[String]) {

    var count = 0
    for (line <- Source.fromFile("/home/nidhish/otherprojects/funstuff/src/test/scala/resources/inputoutput.txt").getLines()) {

      val lines = line.split("\t")
      val input = lines(0)
      val expectedOutput = lines(1)
      var output = findLexicographicHigherPermutation(input.toCharArray)

      if (output.equals(input)) {
        output = "no answer"
      }


      if (!output.equals(expectedOutput)){
          println(input + " " + output + " " + expectedOutput)
      }else{
        count+=1
      }




    }
    //      println(line)
    //            StdIn.readLine().toCharArray
    ////      val input = StdIn.readLine.split(" ").map(_.toInt)
    //      val inputString = input.mkString
    //      val output = findLexicographicHigherPermutation(input)
    //
    //      if (output.equals(inputString)){
    //        println("no answer")
    //      }else{
    //        println(output)
    //      }
    //    }


    println(" " + count + " Suceeded ")

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

