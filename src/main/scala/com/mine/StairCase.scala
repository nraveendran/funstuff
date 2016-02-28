package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object StairCase {


  def main(args: Array[String]) {

    val numSteps = StdIn.readInt()



    //    for (currentStep <- numSteps to 1 by -1) {
    //      for (i <- 1 to currentStep - 1) {
    //        print(" ")
    //      }
    //      for (i <- currentStep to numSteps) {
    //        print("#")
    //      }
    //      println
    //    }

    for (currentStep <- 1 to numSteps) {
      println(" " * (numSteps - currentStep) + "#" * currentStep)
    }


  }


}

