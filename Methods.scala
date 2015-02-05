
println(getSquare(2))
println(getSquareDouble(2.0))
println(isArg1GreaterThanArg2(1,2))
println(getMe("HeLlO WOrLD"))
println(addStrings("Hello", "world"))
println(manyTimesString("abc", 4))

//Return the square of the passed parameter
def getSquare(x:Int):Int = {
  x*x
}

def getSquareDouble(x:Double):Double = {
  x*x
}

def isArg1GreaterThanArg2(first:Int, second:Int):Boolean = {
  first > second
}

def getMe(str:String):String = {
  str.toLowerCase
}

def addStrings(str1:String, str2:String):String = {
  str1 + str2
}

def manyTimesString(str:String, numTimesToDuplicate:Int):String = {
  if(numTimesToDuplicate == 0) ""
  else str + manyTimesString(str, numTimesToDuplicate - 1)
}
