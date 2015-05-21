//Everything in scala is an object. Although objects often contain only ordinary methods and data, you
//can also pass methods- in the form of objects- as arguments to other methods. To accomplish this, 
//the methods are packaged using function objects, often called simply functions.

def show(n:Int):Unit = { println("> " + n) }
val v = Vector(1, 2, 3, 4)
v.foreach(show)

//when we pass show as if it were a function, Scala automatically converts it to a function object. This
//is called lifting.

//If you're only going to use this method once, you can also use a lambda, also known as an anonymous 
//function. An anonymous function is defined using the => symbol, often called the rocket. 

v.foreach(n => println("> " + n ))

var s = ""
val duck = "Duck".toVector

duck.foreach(n => s = s + n + ":")
println(s)

//if you need more than one argument, you can use parentheses for the argument list

val v2 = Vector(19, 1, 7, 3, 2, 14)
v2.sortWith((i, j) => j < i)//19, 14, 7, 3, 2, 1

//a function with zero arguments can also be anonymous
class Later(val f: () => Unit) {
  def call():Unit = { f() }
}

val c1 = new Later(() => println("now"))
c1.call()//prints "now"

//You can also assign anononymous functions to vars and vals
val later1 = () => println("now")
val later2 = () => println("now")

later1()
later2()


