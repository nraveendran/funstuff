def factorial(i: Int): Int = {
  if (i <= 1) {
    1
  } else {

    factorial(i - 1) * i

  }

}

def factorialAccumulated(i: Int): Int = {
  def fact(i: Int, accumulated: Int): Int = {
    if (i <= 1) {
      accumulated
    } else {
      fact(i - 1, i * accumulated)
    }
  }

  fact(i, 1)
}

println(factorialAccumulated(0))
println(factorialAccumulated(1))
println(factorialAccumulated(3))
