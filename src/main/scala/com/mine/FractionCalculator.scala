package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object FractionCalculator {

  var totalPositiveNumbers = 0.0
  var totalNegativeNumbers = 0.0
  var totalZeroes = 0.0

  def main(args: Array[String]) {

    val totalNumberOfIntegers = StdIn.readInt().toFloat

    val arrayOfInts = StdIn.readLine().split(" ").map(_.toInt)

    arrayOfInts.foreach(x =>  {

      math.signum(x) match {
        case 1.0 => totalPositiveNumbers += 1;
        case -1.0 => totalNegativeNumbers += 1;
        case _ => totalZeroes += 1
      }
    })

//    println(BigDecimal(totalPositiveNumbers / totalNumberOfIntegers).setScale(3, BigDecimal.RoundingMode.HALF_UP))
//    println(BigDecimal(totalNegativeNumbers / totalNumberOfIntegers).setScale(3, BigDecimal.RoundingMode.HALF_UP))
//    println(BigDecimal(totalZeroes / totalNumberOfIntegers).setScale(3, BigDecimal.RoundingMode.HALF_UP))
//
    println("%.3f".format(totalPositiveNumbers / totalNumberOfIntegers))
    println("%.3f".format(totalNegativeNumbers / totalNumberOfIntegers))
    println("%.3f".format(totalZeroes / totalNumberOfIntegers))


  }


}

