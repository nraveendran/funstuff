package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object ChocolateFeast {


  def createTupleUsingFirstSecondElements(inputIntegers: Array[String]): (Int, Int, Int) = {
    inputIntegers match {
      case Array(totalMoneyTimHas: String, pricePerChocolate: String, numWrappersPerChocolate: String, _*) => (totalMoneyTimHas.toInt, pricePerChocolate.toInt, numWrappersPerChocolate.toInt)
    }
  }

  def findNumChocolatesTimCanEat(value: (Int, Int, Int)) = {

    //6,2,2

    val totalMoneyTimHas = value._1
    val pricePerChocolate = value._2
    val numWrappersPerChocolate = value._3

    var numChocolatesTimCanEat = totalMoneyTimHas / pricePerChocolate //6/2 = 3
    var remainingWrappers = numChocolatesTimCanEat


    var chocolatesTimCanBuyWithWrapper = 0

    while (remainingWrappers >= numWrappersPerChocolate) {

      chocolatesTimCanBuyWithWrapper = remainingWrappers / numWrappersPerChocolate // 3/2 = 1 , 6/2 =3 , 7/2 = 3
      remainingWrappers = remainingWrappers % numWrappersPerChocolate + chocolatesTimCanBuyWithWrapper // 1 + 1 =2, 3 +
      numChocolatesTimCanEat += chocolatesTimCanBuyWithWrapper
    }



    println(numChocolatesTimCanEat)

  }

  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt



    for (i <- 1 to numberOfTests) {
      val inputIntegers = StdIn.readLine().split(" ")



      val x = createTupleUsingFirstSecondElements(inputIntegers)

      findNumChocolatesTimCanEat(x)


    }


  }


}

