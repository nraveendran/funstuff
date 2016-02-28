package com.mine

import scala.io.StdIn


object SherlockValidString {


  def findAnagramMatchingChars(allChars: Array[Char]): Boolean = {

    val alphabet = Array.fill[Integer](26)(0)



    val strLength = allChars.length


    for (i <- 0 to strLength - 1) {
      val alphabetIndex = allChars(i) - 'a';
      alphabet(alphabetIndex) += 1
    }


    var oneSet = 0;
    var secondSet = 0;
    var lastSet = 0;

    for (x <- alphabet) {

      if (x > 0) {

        if (x == 1) {
          oneSet += 1
        } else {

          if (secondSet != 0 && x != secondSet) {
            return false;
          } else {
            secondSet = x
          }
        }
      }

    }

    if (secondSet != 0 && oneSet > 1) {
      return false;
    }

    return true;

  }

  def main(args: Array[String]) {

    //    val numTest = StdIn.readInt()


    //    for (i <- 1 to numTest) {

    val inputCharArray = StdIn.readLine().toCharArray

    println(if (findAnagramMatchingChars(inputCharArray)) {
      "YES"
    } else {
      "NO"
    })

    //    }


  }


}

/*
hfchdkkbfifgbgebfaahijchgeeeiagkadjfcbekbdaifchkjfejckbiiihegacfbchdihkgbkbddgaefhkdgccjejjaajgijdkd
abccdd
aabbcd
bccdd
bbcccddd
bbccc
*/
