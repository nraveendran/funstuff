var bools = List("true","false","something")

for (bool <- bools){
 
	println(bool)

	bool match {
	
		case "true" => println("Truth right here")
		case "false" => println("False kingdom")
		case _  =>  println("don't know you")
	
	}

}
