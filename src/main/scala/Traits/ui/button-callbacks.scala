package ui

class ButtonWithCallBacks(val label: String, val callBackList: List[() => Unit]) extends Widget {

  require(callBackList != null, "Callback list can't be null!")

  def this(label: String, clickedCallBack: () => Unit) {

    this(label, List(clickedCallBack))
  }

  def this(label: String) {
    this(label, Nil)
    println("warning: no callbacks")

  }

  def click() = {

    callBackList.foreach(

      f => f()

    )

  }


}
