package Traits.ui

import org.specs2.Specification
import ui.ObservableButton


class ButtonObserverSpec extends Specification {

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createObservableButton
          a button count observer added               $addButtonCountObserver
          when clicked 3 times                        $clickThreeTimes
                                                      """

  var buttonObserver = new ButtonCountObserver


  var observableButton = new ObservableButton("Okay")

  def createObservableButton = observableButton should not be empty


  def addButtonCountObserver = {
    observableButton.addObserver(buttonObserver)
    buttonObserver should not be empty
  }

  //
  def clickThreeTimes = {

    for (i <- 1 to 3) observableButton.click()
    buttonObserver.count must be_==(3)
  }

}

