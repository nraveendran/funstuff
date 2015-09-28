package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object AnagramPalindrome {


  def main(args: Array[String]) {


    val input = StdIn.readLine().toCharArray
    if (isAnagramAPalindrome(input)) {
      println("YES")
    } else {
      println("NO")
    }


  }


  def isAnagramAPalindrome(input: Array[Char]): Boolean = {

    val length = input.length

    val alphabet = new Array[Int](26)

    for (j <- 0 to 25) {
      alphabet(j) = 0
    }

    for (x <- 0 to length - 1) {

      val charIndex = input(x).toLower - 'a'

      if (charIndex >= 0 && charIndex < 26) {
        alphabet(charIndex) += 1
      }

    }

    var numOddOccurrences = 0

    for (j <- 0 to 25) {
      numOddOccurrences += (alphabet(j) % 2)
    }

    if (numOddOccurrences == 0 || numOddOccurrences == 1) {
      return true
    } else {
      return false
    }


  }

}

