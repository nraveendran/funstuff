/**
 * Created by nidhish on 2/16/15.
 */
package shapes {


import scala.actors.Actor


class Point(val x: Double, y: Double) {


  override def toString = "Point (" + x + "," + y + ")";


}

abstract class Shape() {
  def draw(): Unit
}

class Circle(val center: Point, val radius: Double) extends Shape {
  override def draw(): Unit = println("Circle draw " + this)

  override def toString: String = "Circle (" + center + ") radius " + radius;
}

class Rectangle(val leftCorner: Point, val height: Double, val length: Double) extends Shape {
  override def draw(): Unit = println("Draw rectangle " + this);

  override def toString: String = "Rectangle (" + leftCorner + ") height (" + height + ") length (" + length + ")";
}

class Triangle(val point1: Point, val point2: Point, val point3: Point) extends Shape {
  override def draw(): Unit = println("Drawing triangle " + this);

  override def toString() = "Triangle (" + point1 + ")  (" + point2 + ")  (" + point3 + ")";
}


}
