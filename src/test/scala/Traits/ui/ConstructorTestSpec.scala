package Traits.ui

import Traits.ui2.ConstructorTest
import org.junit.runner.RunWith
import org.specs2.Specification
import org.specs2.runner.JUnitRunner


@RunWith(classOf[JUnitRunner])
class ConstructorTestSpec extends Specification {

  var constructorTest = new ConstructorTest

  def createConstructorTest = {

    constructorTest != null

  }

  def is = s2"""
  This is a specification for the 'Hello world' string
    Given a new observable button                     $createConstructorTest
                                                      """


}
