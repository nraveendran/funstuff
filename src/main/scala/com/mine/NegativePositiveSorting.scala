//package com.mine
//
//import scala.io.StdIn
//
///*
//Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a special way.
//After that,the negative integers should in the front,and the positive integers should in the back.Also the relative position should not be changed.
//eg. -1 1 3 -2 2 ans: -1 -2 1 3 2.
//o(n)time complexity and o(1) space complexity is perfect.
//1
//-1 1 3 -2 2
// */
//object NegativePositiveSorting {
//
//
//  def mergeArrays(startIndex: Int, endIndexFirstArray: Int, endIndex: Int, numbers: Array[Int]): Unit = {
//
//    var firstPositiveIndex = startIndex
//    (startIndex to endIndexFirstArray).toStream.takeWhile(x => numbers(x) < 0).foreach(_ => firstPositiveIndex += 1)
//
//    val lengthOfPositivePart = (endIndexFirstArray - firstPositiveIndex)
//    (0 to lengthOfPositivePart / 2).foreach(x => {
//      val temp = numbers(firstPositiveIndex + x)
//      numbers(firstPositiveIndex + x) = numbers(endIndexFirstArray - x)
//      numbers(endIndexFirstArray - x) = temp
//    })
//
//    var secondPositiveIndex = endIndexFirstArray+1
//    (endIndexFirstArray+1 to endIndex).toStream.takeWhile(x => numbers(x) < 0).foreach(_ => secondPositiveIndex += 1)
//
//
//    val lengthOfNegativePart = (endIndex - secondPositiveIndex)
//
//    (0 to lengthOfNegativePart / 2).foreach(x => {
//      val temp = numbers(secondPositiveIndex + x)
//      numbers(secondPositiveIndex + x) = numbers(endIndex - x)
//      numbers(endIndex - x) = temp
//    })
//
//
//
//
//  }
//
//  def sortDigits(numbers: Array[Int], startIndex: Int, endIndex: Int): Unit = {
//    while (startIndex < endIndex) {
//      sortDigits(numbers, startIndex, (startIndex + endIndex) / 2)
//      sortDigits(numbers, (startIndex + endIndex) / 2 + 1, endIndex)
//      mergeArrays(startIndex, (startIndex + endIndex) / 2, endIndex, numbers)
//    }
//
//
//    def main(args: Array[String]) {
//
//      val numberOfTests = StdIn.readInt
//
//      for (i <- 1 to numberOfTests) {
//        val inputIntegerArr = StdIn.readLine().split(" ").map(_.toInt)
//
//        sortDigits(inputIntegerArr, 0, inputIntegerArr.length - 1)
//      }
//
//    }
//
//
//  }
//
