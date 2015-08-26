val dogBreeds = List("Bugle","Naadan Patti", "Yorkshire Terrier", "Scottish Terrier","Doberman")

for {breed <- dogBreeds
     upperCaseBreed = breed.toUpperCase()
    } {println(upperCaseBreed)}

