def worldCapitals: Map[String, String] = Map(
  "USA" -> "Washington",
  "India" -> "New delhi",
  "France" -> "Paris"
)

println(worldCapitals.get("USA"))
println(worldCapitals.get("India"))
println(worldCapitals.get("France"))
println(worldCapitals.get("UK"))

println(worldCapitals.get("USA").get)
println(worldCapitals.get("India").get)
println(worldCapitals.get("France").get)
println(worldCapitals.get("UK").getOrElse("Not found"))
