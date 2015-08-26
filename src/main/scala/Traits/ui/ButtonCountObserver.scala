package Traits.ui

import observer.Subject


class ButtonCountObserver {

  var count: Int = 0;
  def receiveUpdate(subject: Any) = { count = count +1 }

}
