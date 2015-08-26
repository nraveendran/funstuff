package Traits.ui

import ui.ButtonWithCallBacks


class RadioButtonWithCallbacks(on: Boolean, label: String, callbackList: List[() => Unit]) extends ButtonWithCallBacks(label, callbackList) {

  def this(on: Boolean, label: String, clickedCallback: () => Unit) = {
    this(on, label, List(clickedCallback))
  }


  def this(on: Boolean, label: String) = {
    this(on, label, Nil)
  }
}
