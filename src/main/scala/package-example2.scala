package com {

package example {

package pkg1 {


class Class1 {
  def m = "m11"
}

class Class2 {
  def m = "m12"
}

}

package pkg2 {


class Class21 {

  def m = "m21"

  def makeClass11 = {
    new pkg1.Class1
  }

  def makeClass12 = {
    new pkg1.Class2
  }
}

}

}

}
