package ui

import Traits.ui2.Clickable

class Button(val label: String) extends Widget with Clickable {

  def click() = {

    //implement appearance

    println("Smile if you got clicked")

  }

}
