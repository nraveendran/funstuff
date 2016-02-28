package com.mine

import scala.io.StdIn


object QuickSortPartitioning {

  var count = 0

  def quickSortPartition(elementArray: Array[Int], arrStartIndex: Int, arrEndIndex: Int) = {


    val pivotIndex = arrEndIndex
    val pivot = elementArray(pivotIndex)
    var leftMarginIndex = arrStartIndex - 1
    //    var rightMarginIndex = arrStartIndex + 1

    for (currentIndex <- arrStartIndex to arrEndIndex - 1) {

      if (elementArray(currentIndex) < pivot) {
        //        rightMarginIndex += 1

        leftMarginIndex += 1
        val temp = elementArray(leftMarginIndex)
        elementArray(leftMarginIndex) = elementArray(currentIndex)
        elementArray(currentIndex) = temp

        //        rightMarginIndex += 1
        count += 1
      }
      //            println(elementArray.mkString(" "))
      //      println("left margin index " + leftMarginIndex)
      //      println("right margin index " + rightMarginIndex)
    }

    val temp = elementArray(leftMarginIndex +1)
    elementArray(leftMarginIndex + 1) = elementArray(pivotIndex)
    elementArray(pivotIndex) = temp



    count += 1
    println(elementArray.mkString(" "))
    //    println("Pivot value is " + elementArray(leftMarginIndex-1))
    //    println(elementArray.slice(arrStartIndex, arrEndIndex+1).mkString(" "))
    //        println("left margin index " + leftMarginIndex)
    //        println("right margin index " + rightMarginIndex)

    leftMarginIndex+1

  }

  def main(args: Array[String]) {


    val numElements = StdIn.readLine().toInt


    val elementArray = StdIn.readLine.split(" ").map(_.toInt)





    quickSort(elementArray, 0, numElements - 1);

//    println("Total count is " + count)


  }


  def quickSort(elementArray: Array[Int], arrStartIndex: Int, arrEndIndex: Int): Unit = {

    val leftMarginIndex = quickSortPartition(elementArray, arrStartIndex, arrEndIndex)
    if (leftMarginIndex - 1 - arrStartIndex > 0) {
      quickSort(elementArray, arrStartIndex, leftMarginIndex - 1)
    }

    if (arrEndIndex - (leftMarginIndex + 1) > 0) {
      quickSort(elementArray, leftMarginIndex + 1, arrEndIndex)
    }



    //    println(elementArray.slice(arrStartIndex, arrEndIndex+1).mkString(" "))

  }

}

/*
cloudera-cdh5.list

*/
