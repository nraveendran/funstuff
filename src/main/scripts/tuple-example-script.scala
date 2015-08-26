def tupleator(x1:Any,x2:Any,x3:Any)=(x1,x2,x3)

val t = tupleator("World",'!',0x22)

println("the whole tuple: " + t)
println("the first item: " + t._1)

println("the second item: " + t._2)
println("the third item: " + t._3)

val (t1,t2,t3) = tupleator("Hello",1,2.3)
println("t1="+t1 +" t2=" +t2+  " t3="+ t3)
