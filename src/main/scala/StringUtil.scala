object StringUtil {

  def joiner(stringsList: List[String], separator: String): String = {

    stringsList.mkString(separator)
  }

  def joiner(stringsList: List[String]): String = {
    joiner(stringsList, ",")
  }

  def toCollection(string: String) = {
    string.split(' ')

  }

}

//import StringUtil._

//println(joiner(List("String", "appendage")))
