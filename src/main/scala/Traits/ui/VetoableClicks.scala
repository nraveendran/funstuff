package Traits.ui

import Traits.ui2.Clickable

trait VetoableClicks extends Clickable{

  var maxAllowedClicks = 1

  var clicks = 0

  abstract override def click: Unit = {

    if (clicks < maxAllowedClicks){
      println("vetoable clicks calling super")
      super.click
      println("allow clicks")
      clicks += 1
    }else{
      println("Vetoing the click");
    }

  }
}
