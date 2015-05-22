//foreach is useful but it doesn't return anything
//There are methods that operate on sequences that return things like map and reduce

//map takes its argument - a function that takes a single argument and produces a result - and applies it
//to each element in the sequence. This is similar to foreach but map takes the return value from
//each call and stores it in a new sequence.

val v = Vector(1, 2, 3, 4)
v.map(n => n + 1)//produces a new Vector(2,3,4,5)

//reduce takes its arguments to combine all the elements of a sequence.

val v2 = Vector(1, 10, 100, 1000)
v2.reduce((sum, n) => sum + n)//returns 1111

(1 to 100).reduce((sum, n) => sum + n)

//exercises
//1) write a function that multiplies each value in a sequence by 11 and adds 10
val v3 = Vector(1,2,3,4)
val a = v3.map(n => n*11 + 10)
println(a)

//Use reduce to implement a method sumIt that takes a variable argument list and sums those arguments.
//sumIt(1,2,3) is 6
//sumIt(45,45,45,60) is 195

def sumIt(args:Int*) = {
  args.reduce((sum, n) => sum + n)
}

println(sumIt(1,2,3))
println(sumIt(45,45,45,60))
