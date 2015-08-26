package com.mine

import scala.io.StdIn

object DiagonalDifference {

  def main(args: Array[String]) {

    val numberOfRowsCols = StdIn.readInt()

    val twoDimArray : Seq[Array[Int]] =
      for (_ <- 1 to numberOfRowsCols)
        yield StdIn.readLine.split(" ").map(_.toInt)


    val diagonalDifference = new DiagonalDifference

    println(diagonalDifference.findDiagonalDifference(twoDimArray,numberOfRowsCols))





  }
}

class DiagonalDifference {

  def findDiagonalDifference(twoDimArray:Seq[Array[Int]],numberOfRowsCols:Int) ={


    var leftToRightDiagonal = 0
    var rightToLeftDiagonal = 0

    for (i <- 0 to numberOfRowsCols-1){

      leftToRightDiagonal += twoDimArray(i)(i)
      rightToLeftDiagonal += twoDimArray(numberOfRowsCols-1-i)(i)
    }

    math.abs(rightToLeftDiagonal - leftToRightDiagonal)
  }

}