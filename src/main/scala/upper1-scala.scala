object Upper {
  def main(args: Array[String]) {
    args.map(_.toUpperCase).foreach(printf("%S ", _))
    println(" ")
  }

  // (strings: String*) = {
  //    //    strings.map((s: String) => s.toUpperCase());
  //
  //  }
}


//println(Upper.upper("A","First","Scala","Program"))
