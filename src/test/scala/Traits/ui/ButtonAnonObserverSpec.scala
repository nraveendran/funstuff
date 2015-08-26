package Traits.ui

import observer.Subject
import org.junit.runner.RunWith
import org.specs2.Specification
import org.specs2.runner.JUnitRunner
import ui.Button


@RunWith(classOf[JUnitRunner])
class ButtonAnonObserverSpec extends Specification {

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createObservableButton
          a button count observer added               $addButtonCountObserver
          when clicked 3 times                        $clickThreeTimes
                                                      """


  println("I am in ButtonObserverSpec")

  var buttonObserver = new ButtonCountObserver

  var observableButton = new Button("Okay") with Subject {

    override def click() = {
      super.click()
      notifyObservers
    }
  }

  def createObservableButton = observableButton should not be empty


  def addButtonCountObserver = {
    observableButton.addObserver(buttonObserver)
    buttonObserver should not be empty
  }

  def clickThreeTimes = {

    for (i <- 1 to 3) observableButton.click()
    buttonObserver.count must be_==(4)
  }

}
