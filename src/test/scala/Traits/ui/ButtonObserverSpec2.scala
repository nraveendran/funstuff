package Traits.ui

import Traits.{AbstractObserverSubject, SubjectForFunctionalObservers, ObserverSubjectForReceiveUpdateObservers}
import org.specs2.Specification
import ui.Button


class ButtonObserverSpec2 extends Specification {

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createObservableButton
          a button count observer added               $addButtonCountObserver
          when clicked 3 times                        $clickThreeTimes
                                                      """

  var buttonObserver  = new ButtonCountObserver


//
//  var observableButton = new Button("Okay") with ObserverSubjectForReceiveUpdateObservers{
//    override def click(): Unit = {
//      println("clicking on a nice button")
//      super.click()
//      println("notifying all observers")
//      notifyObservers
//
//    }
//  }

  var anotherObservableButton = new Button("another button ") with SubjectForFunctionalObservers{

    val count = 0;
    override def click(): Unit = {
      println("clicking on a nice button")
      super.click()
      println("notifying all observers")
      notifyObservers
    }
  }

  def createObservableButton = anotherObservableButton should not be empty



  var count  = 0

  def someMethod(subject: AbstractObserverSubject)
  = {
     count += 1

  }


  def addButtonCountObserver = {

    anotherObservableButton.addObserver((anotherObservableButton) => count += 1)
    buttonObserver should not be empty
  }
//
  def clickThreeTimes = {

   for (i <- 1 to 3) anotherObservableButton.click()
   count must be_== (3)
  }

}

