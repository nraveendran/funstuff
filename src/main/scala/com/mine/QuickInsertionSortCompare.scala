package com.mine

import scala.io.StdIn


object QuickInsertionSortCompare {

  var quickSortCount = 0

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
        quickSortCount += 1
      }
      //            println(elementArray.mkString(" "))
      //      println("left margin index " + leftMarginIndex)
      //      println("right margin index " + rightMarginIndex)
    }

    val temp = elementArray(leftMarginIndex +1)
    elementArray(leftMarginIndex + 1) = elementArray(pivotIndex)
    elementArray(pivotIndex) = temp



    quickSortCount += 1
//    println(elementArray.mkString(" "))
    //    println("Pivot value is " + elementArray(leftMarginIndex-1))
    //    println(elementArray.slice(arrStartIndex, arrEndIndex+1).mkString(" "))
    //        println("left margin index " + leftMarginIndex)
    //        println("right margin index " + rightMarginIndex)

    leftMarginIndex+1

  }


  def insertionSortStep(elementArray: Array[Int], index: Int): Int = {

    val lastElement = elementArray(index)
    var currentIndex = index;

    var done = false
    var moves = 0

    while (currentIndex - 1 >= 0 && !done) {

      if (elementArray(currentIndex - 1) > lastElement) {
        elementArray(currentIndex) = elementArray(currentIndex - 1)
        currentIndex -= 1
        moves += 1
        //        println(elementArray.mkString(" "))
      } else {
        done = true
      }

    }
    //    moves+=1
    elementArray(currentIndex) = lastElement
    //    println(elementArray.mkString(" "))

    moves
  }
  
  
  def main(args: Array[String]) {


    val numElements = StdIn.readLine().toInt


    val elementArray = StdIn.readLine.split(" ").map(_.toInt)


    quickSort(elementArray.clone(), 0, numElements - 1);


    var moves = 0

    for (index <- 1 to numElements - 1)
      moves += insertionSortStep(elementArray, index);

    println(moves - quickSortCount)


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
