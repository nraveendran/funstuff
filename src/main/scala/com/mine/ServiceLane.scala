package com.mine

import scala.collection.immutable.Range.Inclusive
import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object ServiceLane {


  def findLargestVehicle(serviceLineWidthArray: Array[Int], startStopExitRange: Inclusive) = {

    var maxWidth = 3


    startStopExitRange.toStream.takeWhile(_ => maxWidth != 1).foreach(x => {

      if (serviceLineWidthArray(x) < maxWidth) {

        maxWidth = serviceLineWidthArray(x)

      }

    })

    println(maxWidth)
  }

  def main(args: Array[String]) {

    val numberOfTestsAndArrayLength = createTupleUsingFirstSecondElements(StdIn.readLine().split(" "))

    val serviceLineWidthArray = StdIn.readLine().split(" ").map(_.toInt)



    for (i <- 1 to numberOfTestsAndArrayLength._1) {
      val startStopExit = StdIn.readLine().split(" ")

      val startStopExitRange = createRangeUsingFirstSecondElements(startStopExit)

      findLargestVehicle(serviceLineWidthArray, startStopExitRange)

    }

  }


  def createTupleUsingFirstSecondElements(inputIntegers: Array[String]) = {
    inputIntegers match {

      case Array(first: String, second: String, _*) => (first.toInt, second.toInt)

    }
  }

  def createRangeUsingFirstSecondElements(inputIntegers: Array[String]) = {
    inputIntegers match {

      case Array(first: String, second: String, _*) => (first.toInt to second.toInt)

    }

  }

}

