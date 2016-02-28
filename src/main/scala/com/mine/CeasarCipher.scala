package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object CeasarCipher {


  def main(args: Array[String]) {

    StdIn.readInt

    //    for (i <- 1 to lengthOfString) {
    val input = StdIn.readLine().toCharArray

    val offset = StdIn.readInt()

    val output = input.map(x => findOffsetChar(x, offset))
    //
    print(new String(output).toString)


  }


  def findOffsetChar(y: Char, offset: Int): Char = {
    var x = y.toInt
    if (x >= 'A' && x <= 'Z') {
      x += offset
      if (x > 'Z') {
        x = ((x - 'Z' - 1) % 26 + 'A')
      }
    } else if (x >= 'a' && x <= 'z') {
      x += offset
      if (x > 'z') {
        x = (x - 'z' - 1) % 26 + 'a'
      }
    }
    x.toChar

  }
}

