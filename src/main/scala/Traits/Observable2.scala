package Traits

/**
 * Created by nidhish on 4/5/15.
 */

trait AbstractObserverSubject {
  type Observer

  private var observers = List[Observer]()

  def addObserver(observer: Observer) = observers ::= observer

  def notifyObservers = {
    observers.foreach(notify(_))
  }

  def notify(observer: Observer)
}


trait ObserverSubjectForReceiveUpdateObservers extends AbstractObserverSubject {

  type Observer = {def receiveUpdate(something: Any)}

  override def notify(observer: Observer): Unit = {
    observer.receiveUpdate(this)
  }
}

trait SubjectForFunctionalObservers extends AbstractObserverSubject {
  type Observer = (AbstractObserverSubject) => Unit

  override def notify(observer: Observer): Unit = {
    observer(this)
  }
}






