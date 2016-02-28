package com.mine

import java.text.SimpleDateFormat
import java.util.Date

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object FineCalculator {


  def main(args: Array[String]) {

    val actualReturnDateString = StdIn.readLine()
    val expectedReturnedDateString = StdIn.readLine()

    //    07:05:45PM

    val sdfFrom = new SimpleDateFormat("MM dd yyyy")


    val actualReturnDate: Date = sdfFrom.parse(actualReturnDateString)
    val expectedReturnDate: Date = sdfFrom.parse(expectedReturnedDateString)

    val actualReturnDateInLong = actualReturnDate.getTime
    val expectedReturnDateInLong = expectedReturnDate.getTime


    if (actualReturnDateInLong <= expectedReturnDateInLong) {
      println(0)
    } else {

    }


  }


}

