import java.util.Calendar

	val thentime = null
	val nowtime = Calendar.getInstance()

	try 
	{
		throw new RuntimeException("message")
		nowtime.compareTo(thentime)
	}catch {

		case e:NullPointerException => println("It's a null pointer")
		case unKnown: Throwable => println("unknown exception" + unKnown)
	} finally {
		
		println("Exit normal")
	
	}


