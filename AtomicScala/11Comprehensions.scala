//In Scala, comprehensions combine generators, filters, and definitions
//This is an example of a generator
//for(n <- v)

//return a vector with elements that are greater than 5 and even
def evenGT5(v:Vector[Int]):Vector[Int] = {
  var result = Vector[Int]()
  for {
    n <- v
    if n > 5
    if n % 2 == 0
  } result = result :+ n
  result
}

val v = Vector(1,2,3,5,6,7,8,10,13,14,17)
println(evenGT5(v))//6 8 10 14

//notice: each of the two if statements filter elements out of the vector
//the +: operator creates a new vector by taking an existing one(but not changing it) and combining
//it with the element to the right of the operator

//now lets do a similar method using the yield keyword
def yielding(v:Vector[Int]):Vector[Int] = {
  val result = for {
    n <- v
    if n < 10
    if n % 2 != 0
  } yield n
  result
}
println(yielding(v))//1 3 5 7

//using yield, we can build the container in place and thus avoid creating it piece by piece
//yield always fills a container. How does scala know what kind of container to create? It infers
//the type from the container that the comprehension is traversing. v is a vector so yield creates
//Vector[Int]
//now we can create the entire Vector at once and use a val

//This also works
def yielding2(v:Vector[Int]):Vector[Int] = {
  for {
    n <- v
    if n < 10
    isOdd = (n % 2 != 0)
    if(isOdd)
  } yield n
}

//notice you don't need to add var or val in the declaration of isOdd
//yields can also have more complex statements
def yielding3(v:Vector[Int]):Vector[Int] = {
  for {
    n <- v
    if n < 10
    isOdd = (n % 2 != 0)
    if(isOdd)
  } yield {
    val u = n * 10
    u + 2
  }
}

println(yielding3(v))
//note that only in the comprehension can you get away with not using val or var

//You can only have one yield expression connected with a comprehension but you can have nested
//comprehensions

def yielding4(v:Vector[Int]) = {
  for {
    n <- v
    if n < 10
    isOdd = (n % 2 != 0)
    if(isOdd)
  } yield {
    for(u <- Range(0, n))
    yield u
  }
}

val v2 = Vector(1,2,3,5,6,7,8,10,13,14,17)
println(yielding4(v))
//Here, we let type inference determine the return type of yielding4
//Each yield produces a vector, so the end result is a Vector of Vectors


