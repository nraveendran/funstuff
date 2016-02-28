package Traits.ui2

import ui.Widget


class Button(val label: String) extends Widget with Clickable {

  override def click(): Unit = {
    println("Clicking on " + this)
  }
}
