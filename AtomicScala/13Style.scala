//Scala allows you to alias an existing name to a new name using the type keyword
case class LongUnrulyNameFromSomeone()
type Short = LongUnrulyNameFromSomeone


class Simple(val s:String) {
  def getA() = s
  def getB = s
}

val simple = new Simple("Hi")
simple.getA()//"Hi"
simple.getA//"Hi"
simple.getB//"Hi"
//simple.getB()//Error

//Notice that neither method getA nor getB takes arguments.
//Parentheses have a stylistic meaning in the scala community. If calling a method modifies the internal
//state of the object, then you should leave the parentheses on in the method definition. This signals
//the reader that this is a mutating method. Ideally, when you call the method you also include the 
//parentheses to send the same message (though Scala doesn't require it).

//Conversely, if calling the method produces a result without changing the state of the object, the 
//convention is to leave the parentheses off the method definition, indicating to the reader that
//this method reads data from the object without mutating it.
