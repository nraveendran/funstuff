def makeList(strings: String*) = {
  if (strings.length == 0) {
    List(0)
  } else {

    strings.toList;
  }

}

val list: List[Any] = makeList()
println(list)
