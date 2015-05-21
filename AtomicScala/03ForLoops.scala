var result = ""

//0 1 2 3 4 5 6 7 8 9
for(i <- 0 to 9){
  result += i + " "
}

//0 1 2 3 4 5 6 7 8 9
for(i <- 0 until 10){
  result += i + " "
}

//0 1 2 3 4 5 6 7 8 9
for(i <- Range(0,10)){
  result += i + " "
}

//0 1 2 3 4 5 6 7 8 9 10
for(i <- Range(0, 10).inclusive){
  result += i + " "
}

//0 2 4 6 8 10 12 14 16 18
for(i <- Range(0,20,2)){
  result += i + " "
}



