import java.util.Calendar

def isFridayTheThirteenth(cal: Calendar): Boolean = {

  val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
  val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH)

  (dayOfWeek == Calendar.FRIDAY) && (dayOfMonth == 13)
}

while (!isFridayTheThirteenth(Calendar.getInstance())) {
  println("Waiting for Freddy")
  Thread.sleep(2000)
}
