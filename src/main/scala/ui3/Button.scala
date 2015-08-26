package ui3

import Traits.ui2.Clickable

class Button(val label: String) extends Widget with Clickable{
  override def draw: Unit = {
    println("Draw a butting")
  }

  override def click(): Unit = {

  }

  override def toString():String = {

    "button with label =" + label + " " + super.toString
  }

//  override def toString: String = "button with label =" + label + " " + super.toString
}
