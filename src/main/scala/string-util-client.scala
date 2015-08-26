import StringUtil._

object StringUtilClient{
  
	def main(args:Array[String]) = {
	
		println("Im am x")
		args foreach {
			s => toCollection(s).foreach(x=> println(x))
		}

	}
  
}
