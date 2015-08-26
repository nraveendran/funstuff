package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object Factorial {


  def factorial(number: Int):BigInt = {

    if (number==1){
      1
    }else{
      number * factorial(number-1)
    }

  }

  def main(args: Array[String]) {

    val inputNumber = StdIn.readInt

    println(factorial(inputNumber))



  }


}

//25

// 25 * 24 * 23