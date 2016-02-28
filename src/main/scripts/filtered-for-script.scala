val dogBreeds = List("Bugle", "Doberman", "Naadan patti", "Terrier", "Yorkshire Terrrier")

for {breed <- dogBreeds
     if (breed.contains("r"))
     if (!breed.equalsIgnoreCase("Terrier"))
} {
  println(breed)

}
