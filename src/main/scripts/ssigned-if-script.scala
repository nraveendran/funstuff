var file = new java.io.File("/home/nidhish/otherprojects/funstuff/src/ssigned-if-script.scala")

var newArray = Array(1, 2, 3)

var outputFile = if (file.exists())
  file.getAbsolutePath()
} else {
  file.createNewFile()
  file.getAbsolutePath()
}

println(outputFile)
