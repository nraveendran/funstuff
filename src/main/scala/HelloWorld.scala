import java.text.DateFormat._
import java.util.{Date, Locale}

/**
 * Created by nidhish on 2/4/15.
 */


object HelloWorld {
  def main(args: Array[String]) {
    println("Hello, world!")

    val now = new Date
    getDateInstance(LONG, Locale.FRANCE)

  }
}


