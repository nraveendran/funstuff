trait t1{

  println(" in t1 X=" + x)
  val x=1
  println(" in t1 X=" + x)

}

trait t2{

  println(" in t2 Y=" + y)
  val y="T2"
  println(" in t2 Y=" + y)

}

class B12{

  println(" in base12 b=" + b)
  val b="Base 12"
  println(" in base12 b=" + b)

}

class c12 extends B12 with t1 with t2 {

  println( " in C12: c = " + c )
  val c="C12"
  println( " in C12: c = " + c )

}

println("Creating c12")
new c12
println("After creating c12")