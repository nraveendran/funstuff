package Traits.ui


import org.specs2.mutable._
import ui.ButtonWithCallBacks


object ButtonCallbackSpec extends Specification {

  "A ButtonWithCallback" should {
    "not be constructable with a null callback list" in {
      val nullList: List[() => Unit] = null
      val errorMessage =
        "requirement failed: Callback list can't be null!"
      new ButtonWithCallBacks("button1", nullList) must throwA(
        new IllegalArgumentException(errorMessage))

    }
  }


}
