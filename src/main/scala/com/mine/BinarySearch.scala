package com.mine

import scala.io.StdIn

object BinarySearch {


  def binarySearch(valueToSearch: Int, arrayToSearch: Array[Int], startIndex: Int, endIndex: Int): Integer = {

    if (startIndex > endIndex) {
      return -1
    }

    val middleIndex = (startIndex + endIndex) / 2

    if (valueToSearch < arrayToSearch(middleIndex)) {
      return binarySearch(valueToSearch, arrayToSearch, startIndex, middleIndex)
    } else if (valueToSearch > arrayToSearch(middleIndex)) {
      return binarySearch(valueToSearch, arrayToSearch, middleIndex + 1, endIndex)
    } else if (valueToSearch == arrayToSearch(middleIndex)) {
      return middleIndex;
    }

    return -1

  }

  //0 1 2 5 3 3 0

  def main(args: Array[String]) {

    val valueToSearch = StdIn.readLine().toInt

    val numElements = StdIn.readLine().toInt


    val elementArray = StdIn.readLine.split(" ").map(_.toInt)


    println(binarySearch(valueToSearch, elementArray, 0, numElements - 1));

  }


}

