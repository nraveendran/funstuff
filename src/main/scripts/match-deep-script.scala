case class Person(name:String, age:Int)

var alice:Person = new Person("Alice",22)
var bob:Person = new Person("Bob",25)
var charlie:Person = new Person("Charlie",28)


for (person <- List(alice,bob,charlie)){

    person match {
    
	    case Person("Alice",22) => println("Hello Alice")
	    case Person("Bob",25) =>  println("Hello Bob")
	    case Person(name,age) => println("who are you? " +age + " year old "+ name)
    
    }
}
