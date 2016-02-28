def countTo(n: Int): Unit = {

  def count(i: Int): Unit = {
    println(i)
    if (i < n) {
      count(i + 1)
    }

  }
  count(1)

}

countTo(5)
