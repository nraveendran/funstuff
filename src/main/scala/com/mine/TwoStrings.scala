package com.mine

import scala.io.StdIn


object TwoStrings {


  def hasCommonCharacter(firstCharArray: Array[Char], secondCharArray: Array[Char]): Boolean = {

    val alphabet = Array.fill[Integer](26)(0)

    for (x <- firstCharArray) {
      val alphabetIndex = x - 'a';
      alphabet(alphabetIndex) += 1
    }

    for (x <- secondCharArray) {
      val alphabetIndex = x - 'a';
      if
      (alphabet(alphabetIndex) > 0) {
        return true
      }
    }


    false

  }

  def main(args: Array[String]) {

    val numTest = StdIn.readInt()





    for (i <- 1 to numTest) {

      val firstCharArray = StdIn.readLine().toCharArray
      val secondCharArray = StdIn.readLine().toCharArray

      println(if (hasCommonCharacter(firstCharArray, secondCharArray)) {
        "YES"
      } else {
        "NO"
      })

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
