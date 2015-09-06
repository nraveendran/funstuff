package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object CavityMap {


  def main(args: Array[String]) {

    val numRows = StdIn.readInt



    val twoDimArray = for (_ <- 1 to numRows) yield StdIn.readLine().map(_.toString.toInt).toArray

    if (numRows > 2) {

      for (row <- 1 to numRows - 2) {
        for (column <- 1 to numRows - 2) {

          val current = twoDimArray(row)(column)
          val sorroundMap = List(current - twoDimArray(row - 1)(column), current - twoDimArray(row)(column - 1),
            current - twoDimArray(row)(column + 1), current - twoDimArray(row + 1)(column))



          val y = for {x <- sorroundMap; if isNotCavity(current, x)} yield x

          if (y.isEmpty) {
            twoDimArray(row)(column) = -1
          }


        }
      }
    }

    twoDimArray.foreach(onedArray => {
      onedArray.foreach(x => {
        if (x == -1) print('X') else print(x)
      })
      println()
    })
  }

  def isNotCavity(current: Int, x: Int): Boolean = {
    (x <= 0 || x > current)
  }

}


/*
4
1112
1912
1892
1234

1112
1-112
1892
1234

if x> 0 = higher depth
if x > current = lower depth

*/
