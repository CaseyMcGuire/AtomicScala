//Use an Array if length is fixed, and ArrayBuffer if length can vary
//Don't use new when supplying initial values
//Use () to access elements
//Use for (elem <- arr) to traverse elements
//Use for(elem <- arr if ...) ... yield... to transform into a new array
//Scala and Java Arrays are interoperable

//In Java, int[] arr = new int[10];
//In Scala,
val arr = new Array[Int](10)

//In Java, int[] arr2 = new int[]{1,2};
//In Scala, 
val arr2 = Array(1,2)//Note: no new!

//The equivalent of ArrayList in Java is scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()
//or new ArrayBuffer[Int]

b += 1
//(1)

b += (1,2,3,5)
//(1,1,2,3,5)

b ++= Array(9, 13, 21)
//(1,1,2,3,5,8,13,21)
//you can append any collection with ++= operator

b.trimEnd(5)
//(1,1,2)
//removes the last 5 elements

//You can also insert and remove elements
b.insert(2,6)
//(1,1,6,2)
b.insert(2,7,8,9)
//(1,1,7,8,9,6,2)
//not this inserts elements starting at index 2

b.remove(2)
//(1,1,8,9,6,2)

b.remove(2,3)
//(1,1,2)
//Note this doesn't remove a *range* it removes the 3 elements starting at index 2

//To transform arrays, you can use for comprehensions
val a = Array(2,3,5,7,11)
val result = for(elem <- a) yield 2 * elem

//Notes these are equivalent
a.filter(_ % 2 == 0).map(2 * _)
a filter { _ % 2 == 0 } map { 2 * _ }

//To create a multidimensional array in scala, use the ofDim method
val matrix = Array.ofDim[Double](3,4)
//To access, use matrix(row)(column)


