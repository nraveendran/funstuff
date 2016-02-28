val list = List(1, 1.0, "Somebody", true)

for (item <- list) {

  item match {

    case i: Int => println("got Integer " + i)
    case d: Double => println("got Double " + d)
    case s: String => println("got String " + s)
    case other => println("Don't know what this type is " + other)

  }

}
