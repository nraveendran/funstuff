trait AbstractT2 {

  println("In abstract t2")
  val value: Int
  val postIntValue: Int
  println("AbstractT2 has value " + value + " inverse " + inverse)
  val inverse = 1.0 / value


}


val c2c = new {
  // Only initializations are allowed in pre-init. blocks.
  //  println("In c2c:")
  val value = 10
  //  val inverse = 1.0/value
} with AbstractT2 {
  val postIntValue = 20
  println("value after initialization is " + value)

}



println("Value from anon is " + c2c.value + " and inverse is " + c2c.inverse)

println("value for post int value is " + c2c.postIntValue)