package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object FindDigits {


  def findDigits(inputInteger: Int) = {

    println(split(inputInteger))
  }

  def split(n: Int) : Int = if (n == 0) 0 else {
    def array = (Stream.iterate(n)(_/10)takeWhile(_!=0)map(_%10)toArray) reverse

    var divisors = 0

    array.foreach(x => {
      if (x!=0 && n%x==0){
        divisors+=1
      }
    })
//    Stream.iterate(n)(_/10)takeWhile(_!=0) mkString(",")

     divisors
  }

/*
    128

    128 / 10  = 12+

    12 / 10 = 1

    128%10 = 8
    12%10 = 2
    1%10 = 1

 */

  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt

    for (i <- 1 to numberOfTests) {
      val inputInteger = StdIn.readInt()

      findDigits(inputInteger)
    }

  }


}

