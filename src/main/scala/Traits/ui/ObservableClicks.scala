package Traits.ui

import Traits.ui2.Clickable
import observer.Subject

/**
 * Created by nidhish on 3/21/15.
 */
trait ObservableClicks extends Clickable with Subject{

  abstract override def click() = {


    println("Observer clicks calling super")
    super.click()
    println("Letting observers know about the click")
    notifyObservers

  }
}
