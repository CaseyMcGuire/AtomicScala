//A vector is a container - something that holds other objects. 
//A vector is part of the standard package and is thus available without any other imports.

val v1 = Vector(1, 3, 5, 7, 11, 13)

//iterative through vector
var result = ""
for(i <- v1){
  result += i + " "
}
print(result)

//reverse returns a new vector containing the elements in reverse order
val v2 = v1.reverse

val v3 = Vector(3,5,7,1,2,4)

//sorted returns a new vector containing the same elements in sorted order
val v4 = v3.sorted

//head returns the first element of a vector
v3.head//3

//tail returns the last element of a vector
v3.tail//4

//exercises
val v5 = Vector("The", "dog", "visited", "the", "firehouse")

//prints words reversed
for(i <- v5){
  println(i.reverse)
}

//prints words in reverse order
for(i <- v5.reverse){
  println(i)
}

