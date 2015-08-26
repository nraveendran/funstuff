package ui


abstract class Widget {


  class Properties {

    import scala.collection.immutable.HashMap

    private var propertyMap: Map[String, Any] = new HashMap

    def size = propertyMap.size

    def get(property: String) = propertyMap.get(property).get

    def put(property: String, value: Any) = {

      propertyMap = propertyMap.updated(property, value)
    }


  }

  val properties = new Properties

}
