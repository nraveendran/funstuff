package com.mine

/**
 * Created by nidhish on 8/22/15.
 */
object ValidateBinarySearchTree {


  def main(args: Array[String]) {


    val rootTree = new CustomTree

    rootTree.data = 10


  }


}

class CustomTree {

  var left: CustomTree = null
  var right: CustomTree = null
  var data: Integer = 0

}

//3
//abcdde
//baccd
//eeabg

