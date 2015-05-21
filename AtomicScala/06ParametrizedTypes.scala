//Scala has type inference and thus can often times figure out what type you're using. However, sometimes
//it can't and thus you must explicitly declare the type

val v1 = Vector(1,2,3)
val v2 = Vector("one", "two", "three")

//some but explicitly typed
val p1:Vector[Int] = Vector(1,2,3)
val p2:Vector[String] = Vector("one", "two", "three")

//works
def inferred(c1:Char, c2:Char, c3:Char) = {
  Vector(c1, c2, c3)
}

//doesn't work
def explicit1(c1:Char, c2:Char, c3:Char):Vector = {
  Vector(c1, c2, c3)
}

//works
def explicit2(c1:Char, c2:Char, c3:Char):Vector[Char] = {
  Vector(c1, c2, c3)
}

