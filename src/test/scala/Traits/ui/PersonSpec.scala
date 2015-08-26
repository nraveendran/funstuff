package Traits.ui

import org.junit.runner.RunWith
import org.specs2.Specification
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class PersonSpec extends Specification {


  def validateNameAndAge = {

    val person = new Person("Mickey mouse", 109)

    println(person)
    person.name mustEqual "Mickey mouse"
    person.age mustEqual 109

  }

  def validatePersonNoAge = {

    val person = new Person("Donald Duck")

    println(person)
    person.name mustEqual "Donald Duck"
    person.age mustEqual 0

  }

  def validatePersonNoNameNoAge = {

    val person = new Person

    println(person)
    person.name mustEqual "nobody"
    person.age mustEqual 0
  }

  def is = s2"""
    Given a new person, his name and age are validated                      $validateNameAndAge
    Given a new person with only name, his age is 0                         $validatePersonNoAge
    Given a new person with no name, his age is 0                           $validatePersonNoNameNoAge
                                                      """


}
