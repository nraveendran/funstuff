package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object BeastsDecentNumber {


  def calcualateDecentNumber(numberOfDigits: Int) = {

    var remainingNumberOfDigits = numberOfDigits

    var decentNumber = ""

    while (remainingNumberOfDigits > 0) {
      if (remainingNumberOfDigits % 3 != 0) {

        remainingNumberOfDigits = remainingNumberOfDigits - 5

        if (remainingNumberOfDigits >= 0) {

          decentNumber += "3" * 5
        }
        else {

          decentNumber = "1-"

        }
      } else {

        decentNumber += "5" * remainingNumberOfDigits

        remainingNumberOfDigits = 0
      }

    }

    println(decentNumber.reverse)

  }

  def main(args: Array[String]) {

    val numberOfInput = StdIn.readInt

    for (i <- 1 to numberOfInput) {
      val currentBeastNumber = StdIn.readInt()

      calcualateDecentNumber(currentBeastNumber)
    }

  }


}

//25

// 25 * 24 * 23