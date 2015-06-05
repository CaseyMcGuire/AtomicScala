//if-else blocks are expressions in Scala. 
//Every expression has a type.

//This expression has type Int because both branches return Int
if(1 > 0) 1 else -1

//If the expression is mixed type, it will evaluate to the common supertype of both branches.

//This expression evaluates to the type Any
if(1 > 0) "positive" else -1

//If you have an if statement without a corresponding else block, then type is Unit

//In Scala, a { } block contains a sequence of expressions and the result is also an expression. The
//value of the block is the value of the last expression.

//Scala has no break or continue statements to break out of a loop. What tod if you need a break?
//1. Use a Boolean controll variable instead
//2. Use nested functions - you can return from the middle of a function
//3. Use the break method in the Breaks object

import scala.util.control.Breaks._
breakable {
  for(...) {
    if(...) break;//exits the breakable block
  }
}

//You can have multiple generators of the form variable <- expression

//prints 11 12 13 21 22 23 31 32 33
for(i <- i to 3; j <- 1 to 3) print((10 * i + j) + " ")

//Each generator can have a guard, a Boolean condition preceded by if:
//prints 12 13 21 23 31 32
for(i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")

//prints 13 22 23 31 32 33
for(i <- i to 3; from = 4 -i; j <- from to 3) print((10 * i + j) + " ")



//When the body of the for loop starts with a yield, the the loop constructs a collection of values, one
//for each iteration
for(i <- 1 to 10) yield i % 3
//Yields Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
//This type of loop is called a for comprehension

for(c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
//yields "HIeflmlmop"
for(i <- 0 to 1; c <- "Hello") yield (c + i).toChar
//Yields Vector('H', 'e','l','l','o','I','f','m','m','p')

//Scala has functions in addition to methods. A method operates on an object, but a function doesn't.
//C++ has functions but in Java you have to imitate them with static methods

//There is nothing wrong with using the return in named functions but it will become a problem when 
//you start using anonymous functions. Think of return as a kind of break statement for functions, and
//only use it when you want that breakout functionality

//With a recursive function, you must specify the return type.

//You can provide default arguments for functions that are used when you don't specify explicit values
//example)
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
//If you supply fewer arguments that there are parameters, the defaults are applied from the end.
//You can mix unnamed and named arguments, provided teh unnamed ones come first:
decorate("Hello", right = "]<<<")

//sometimes it is convenient to implemenet a function that can take a variable number of arguments. The
//following example shows the syntax:
def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}

//if you already have a sequence of values, you cannot pass it directly to such a function
val s = sum(1 to 5)//Error

//The remedy is to tell the compiler that you want the parameter to be considered an argument sequence
val s = sum(1 to 5: _*)

//When you call a Java Method with variable arguments, you need to convert any primitive types by hand
val str = MessageFormat.format("The answer to {0} is {1}", "everything", 42.asInstanceOf[AnyReff])

//Scala has a special notation for a function that returns no value. IF the function body is enclosed in
//braces without a preceding = symbol, then the return type is Unit. Such a function is called a
//procedure. A procedure returns no value, and you only call it for its side effect. 

//When a val is declared as lazy, its initialization is deferred until it is accessed for the first time.

lazy val words = scala.io.Source.fromFile("word").mkString

//If the program never accessed words, the file is never opened.

//evaluated as soon as words is defined
val words = scala.io.Source.fromFile("word").mkString

//evaluated the first time words is used
lazy val words = scala.io.Source.fromFile("word").mkString

//evaluated every time words is used
def words = scala.io.Source.fromFile("word").mkString

//Scala has no checked exceptions
