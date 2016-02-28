package com.mine

import java.text.SimpleDateFormat

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object HourFormatter {


  def main(args: Array[String]) {

    val dateString = StdIn.readLine()

    //    07:05:45PM

    val sdfFrom = new SimpleDateFormat("hh:mm:ssa")
    val sdfTo = new SimpleDateFormat("HH:mm:ss")

    println(sdfTo.format(sdfFrom.parse(dateString)))


  }


}

