package com.mine

import scala.io.StdIn


object AnagramMatcher {


  def findAnagramMatchingChars(allChars: Array[Char]): Integer = {

    val alphabet = Array.fill[Integer](26)(0)


    if (allChars.length % 2 != 0) {
      return -1
    }

    val strLength = allChars.length / 2

    for (i <- strLength to allChars.length - 1) {
      val alphabetIndex = allChars(i) - 'a';
      alphabet(alphabetIndex) += 1
    }

    for (i <- 0 to strLength - 1) {
      val alphabetIndex = allChars(i) - 'a';
      alphabet(alphabetIndex) -= 1
    }


    var missingNumbers = 0

    for (x <- alphabet) {
      if (x > 0) {
        missingNumbers += x
      }
    }



    if (missingNumbers >= 0) {
      missingNumbers
    } else {
      -1
    }

  }

  def main(args: Array[String]) {

    val numTest = StdIn.readInt()





    for (i <- 1 to numTest) {

      val inputCharArray = StdIn.readLine().toCharArray

      println(findAnagramMatchingChars(inputCharArray))

    }


  }


}

/*
6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx
*/
