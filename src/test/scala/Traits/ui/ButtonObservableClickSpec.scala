package Traits.ui

import org.specs2.Specification
import ui.Button


object ButtonObservableClickSpec extends Specification {

  val button = new Button("Okay") with ObservableClicks

  val buttonCountObserver = new ButtonCountObserver

  button.addObserver(buttonCountObserver)

  def createObservableButton = {


    button == button

  }

  def clickThreeTimes = {

    for (i <- 1 to 3) {
      button.click()
    }

    buttonCountObserver.count mustEqual 3

  }

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createObservableButton
          when clicked 3 times                        $clickThreeTimes
                                                      """


}
