package Traits.ui

/**
 * Created by nidhish on 3/22/15.
 */
class Person(val name: String, val age: Int) {
  override def toString: String = {

    return "Name is " + name + " and age is " + age

  }

  def this(name: String) = {
    this(name, 0)
  }

  def this() = {
    this("nobody", 0)
  }
}
