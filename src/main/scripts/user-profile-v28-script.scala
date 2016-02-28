object OptionalUserProfileInfo {
  val unknownLocation = "US"
  val unknownAge: Int = -1
  val unknownWebsite = "unknown"
}

class OptionalUserProfileInfo(

                               val location: String = OptionalUserProfileInfo.unknownLocation,
                               val unknownAge: Int = OptionalUserProfileInfo.unknownAge,
                               val unknownWebsite: String = OptionalUserProfileInfo.unknownWebsite

                               )

println(new OptionalUserProfileInfo)
