package com.mine

import scala.io.StdIn


object InsertionSortStep {


  def insertionSortStep(elementArray: Array[Int]) = {

    val lastElement = elementArray(elementArray.length - 1)
    var currentIndex = elementArray.length - 1;

    var done = false

    while (currentIndex - 1 >= 0 && !done) {

      if (elementArray(currentIndex - 1) > lastElement) {
        elementArray(currentIndex) = elementArray(currentIndex - 1)
        currentIndex -= 1
        println(elementArray.mkString(" "))
      } else {
        done = true
      }

    }

    elementArray(currentIndex) = lastElement
    println(elementArray.mkString(" "))

  }

  def main(args: Array[String]) {


    val numElements = StdIn.readLine().toInt


    val elementArray = StdIn.readLine.split(" ").map(_.toInt)


    insertionSortStep(elementArray);


  }


}

/*
5
2 4 6 8 3

2 3 4 5 6 7 8 9 10 11
2 3 4 5 6 7 8 9 9 10
2 3 4 5 6 7 8 8 9 10
2 3 4 5 6 7 7 8 9 10
2 3 4 5 6 6 7 8 9 10
2 3 4 5 5 6 7 8 9 10
2 3 4 4 5 6 7 8 9 10
2 3 3 4 5 6 7 8 9 10
2 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10

*/
