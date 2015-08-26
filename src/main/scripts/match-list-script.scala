val willWork = List(1,3,33,90)
val willNotWork = List(4,18,52)
val emptyList = List()

def processList(l:List[Any]): Unit = l match {
	case head :: tail =>
		print(head+" ");
		processList(tail)
	case Nil => println("")

}

for (l <- List(willWork,willNotWork,emptyList)){

	print("List: ")
	processList(l)
}


