//package com.mine
//
//import scala.collection.BitSet
//import scala.collection.mutable.ArrayBuffer
//import scala.io.StdIn
//
///**
// * Created by nidhish on 8/22/15.
// */
//object TeamsTopics {
//
//
//  def main(args: Array[String]) {
//
//
//    val firstLine = StdIn.readLine.split(" ").map(_.toInt)
//
//    val numPeople = firstLine(0)
//    val numSubjects = firstLine(1)
//
//
//    var matrix = new ArrayBuffer[BitSet]()
//
//    for (_ <- 1 to numPeople) {
//
//      val x = StdIn.readLine()
//      var i = 0
//      var myBitSet = BitSet.empty
//      x.toStream.foreach(aChar => {
//        i += 1
//        if (aChar == '1') {
//          myBitSet += i
//
//        }
//
//      })
//
//      matrix += myBitSet
//
//
//    }
//
//    for (i <- 1 to numPeople) {
//      val firstSet = matrix(i)
//
//
////      for (j <- i + 1 to numPeople) {
////        val secondSet = matrix(j)
////        (firstSet & secondSet).
////      }
//
//    }
//
//    println("herllo")
//
//  }
//
//  def convert(bitSet: BitSet) {
//    var value = 0
//    for ( i <- 0 to bitSet.size) {
//      value += if (bitSet(i) == (1 << i)) {
//        1<<i
//      }  ;
//    }
//    return value;
//  }
//
//
//}
