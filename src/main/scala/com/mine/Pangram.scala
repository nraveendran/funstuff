package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object Pangram {


  def main(args: Array[String]) {


    val input = StdIn.readLine().toCharArray
    findPangram(input)

  }


  def findPangram(input: Array[Char]): Unit = {

    val expected = (1 << (1 + 'Z' - 'A')) - 1

    var testable = 0

    val length = input.length
    for (x <- 0 to length - 1) {

      val i: Int = input(x).toLower - 'a'
      if (i >= 0 && i <= 26) {
        testable |= (1 << i)
        if (testable == expected) {
          println("pangram")
          return
        }
      }

    }

    println("not pangram")

  }

}

