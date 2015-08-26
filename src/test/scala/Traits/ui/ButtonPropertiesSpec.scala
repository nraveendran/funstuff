package Traits.ui

import org.specs2.Specification
import ui.Button


object ButtonPropertiesSpec extends Specification {

  val button = new Button("Okay")



  def createObservableButton = {
    button.properties.put("color","black")
    button.properties.put("size","large")
    button == button

  }

  def verifyProperties = {

    button.properties.get("color") mustEqual "black"
    button.properties.get("size") mustEqual "large"


  }

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createObservableButton
          the properties are verified                 $verifyProperties
                                                      """



}
