val dogBreedList = List("Bugle","Naadan Patti","Scottish Terrier","Yorkshire Terrier", "Doberman")

val filteredDogBreedList = 
	for {breed <- dogBreedList
	     
	     if (!breed.contains("Terrier"))
	     
	} yield breed


println(filteredDogBreedList)
