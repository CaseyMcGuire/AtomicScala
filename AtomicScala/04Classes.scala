//When you create an object, you typically want to pass information into that object to initialize it
//You can do this by adding class arguments

class ClassArg(a:Int){
  println(f)
  def f():Int = { a * 10 }
}

val ca = new ClassArg(19)
ca.f()//190
//ca.a //error

//the new expression *requires* an argument
//notice that a can't be accessed outside the method body. In order to access it, you must set it to a
//var or a val

class ClassArg2(var a:Int)
class ClassArg3(val a:Int)

//now you can see a outside of either class. However, you can only change a in instances of ClassArg2, 
//not ClassArg3

//Your class can also have a variable number of arguments
class Sum(args:Int*){
  def result():Int = {
    var total = 0
    for(n <- args){
      total += n
    }
    total
  }
}

new Sum(1,2,3,4).result() // 10
new Sum(1,2).result() // 3

//When creating an instance of a class that has an argument list, you can specify the argument names

class Color(red:Int, blue:Int, green:Int)
new Color(red = 80, blue = 9, green = 100)
new Color(80, 9, green = 100)

//these are useful for code readability and for setting specific values in class definitions with
//default arguments

class Color2(red:Int = 100, blue:Int = 100, green:Int = 100)
new Color2(20)//red is 20
new Color2(20, 17)//red is 20, blue is 17
new Color2(blue = 20)

//named and default arguments work with variable argument lists. However, the variable argument list must
//appear last. Alos, the variable argument list itself cannot support default arguments

class Family(mom:String, dad:String, kids:String*)

new Family(mom="Mom", dad="Dad")//works
//new Family(dad="Dad", mom="Mom")//doesn't work

//methods in classes can also be overloaded
class Overloading1 {
  def f():Int = { 88 }
  def f(n:Int):Int = { n + 2 }
}

//auxilary constructors

//To create an overloaded construct you define a method (with a distinct argument list) called this
//constructor overloaded has a special constraint: all auxilary constructors must first call the primary
//constructor, which is the constructor produced by the class argument list together with the class body.
class GardenGnome(val height:Double, val weight:Double, val happy:Boolean){
  var painted = true

  def magic(level:Int):String = {
    "Poof!" + level
  }

  //note: you don't need equal sign here but you can add it if you want
  def this(height:Double) {
    this(height, 100.0, true)
  }

  def this(name:String) = {
    this(15.0)
  }
}

//case classes
//case class TypeName(arg1:Type, arg2:Type, ...)

//a case class automatically creates all the class arguments as if you've put the val keyword in front of
//each of one in an ordinary class. If you want one to be a var, just put var in front of it

//YOu also don't need to put the new keyword in front of case classes


