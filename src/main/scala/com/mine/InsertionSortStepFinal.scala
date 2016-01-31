package com.mine

import scala.io.StdIn


object InsertionSortStepFinal {


  def insertionSortStep(elementArray: Array[Int], index: Int) : Int = {

    val lastElement = elementArray(index)
    var currentIndex = index;

    var done = false
    var moves = 0

    while (currentIndex - 1 >= 0 && !done) {

      if (elementArray(currentIndex - 1) > lastElement) {
        elementArray(currentIndex) = elementArray(currentIndex - 1)
        currentIndex -= 1
        moves+=1
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

    var moves = 0

    for (index <- 1 to numElements - 1)
      moves+=insertionSortStep(elementArray, index);


    println(moves)
  }


}

/*
6
1 4 3 5 6 2

*/
