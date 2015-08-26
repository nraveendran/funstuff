import com.mine.DiagonalDifference
import org.scalatest.FunSuite

class ExampleSuite extends FunSuite {

  var twoDimArray: Seq[Array[Int]] = null

  /*
    1  2 4
    3  4 5
    4  5 6

    1+4+6 = 11
    4+4+4 = 12

    11-12 = -1

   */

  test("diagonal difference with a negative value") {

    twoDimArray = List(Array(1, 2, 4), Array(3, 4, 5), Array(4, 5, 6))
    val diagonalDifference = new DiagonalDifference

    assert(diagonalDifference.findDiagonalDifference(twoDimArray, 3) === 1)
  }


}