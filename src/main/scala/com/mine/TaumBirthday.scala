package com.mine

import scala.io.StdIn

/**
 * Created by nidhish on 8/22/15.
 */
object TaumBirthday {


  def main(args: Array[String]) {

    val numberOfTests = StdIn.readInt



    for (i <- 1 to numberOfTests) {


      val numberGifts = StdIn.readLine.split(" ").map(_.toLong) match {
        case Array(numBlackgifts: Long, numWhitegifts: Long, _*) => (numBlackgifts, numWhitegifts)
      }




      val giftPrices = StdIn.readLine.split(" ").map(_.toLong) match {
        case Array(blackGiftPrice: Long, whiteGiftPrice: Long, giftConversionPrice: Long, _*) => (blackGiftPrice, whiteGiftPrice, giftConversionPrice)
      }

      var blackGiftPrice = giftPrices._1
      var whiteGiftPrice = giftPrices._2
      val giftConversionPrice = giftPrices._3


      if (blackGiftPrice > whiteGiftPrice) {
        if (whiteGiftPrice + giftConversionPrice < blackGiftPrice) {
          blackGiftPrice = whiteGiftPrice + giftConversionPrice
        }
      } else {
        if (blackGiftPrice + giftConversionPrice < whiteGiftPrice) {
          whiteGiftPrice = blackGiftPrice + giftConversionPrice
        }
      }


      println(numberGifts._1 * blackGiftPrice + numberGifts._2 * whiteGiftPrice)


    }

  }

}


