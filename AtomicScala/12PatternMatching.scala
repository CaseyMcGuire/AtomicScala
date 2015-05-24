//We've seen pattern matching with values. You can also match against the type of a value. 

def acceptAnything(x:Any):String = {
  x match {
    case s:String => "A String: " + s
    case i:Int if(i < 20) => s"An Int Less than 20: $i"
    case p:Person => s"A Person ${p.name}"
    case _ => "I don't know what that is!"
  }
}

println(acceptAnything(5))

case class Person(name:String)
val bob = Person("Bob")

println(acceptAnything(bob))

//A new type that we haven't seen before is Any, which matches against any type

//Although you've seen that case classes are generally useful, they were originally designed for use 
//with pattern matching, and are well suited for the task, and are well suited for that task.

case class Passenger(
  first:String, last:String
)
case class Train(
  travelers:Vector[Passenger],
  line:String
)
case class Bus(
  passengers:Vector[Passenger],
  capacity:Int
)

def travel(transport:Any):String = {
  transport match {
    case Train(travelers, line) => s"Train line $line $travelers"
    case Bus(travelers, seats) => s"Bus size $seats $travelers"
    case Passenger => "Walking along"
    case what => s"$what is in limbo!"
  }
}
