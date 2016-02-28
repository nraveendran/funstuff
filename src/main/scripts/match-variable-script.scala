import scala.util.Random

val randomInt = new Random().nextInt(10)

randomInt match {

  case 7 => println("Something good")
  case otherNumber => println("cmon now " + otherNumber)

}
