package recfun
import common._

object Main {
  def main(args: Array[String]) {
    
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
    //println(countChange(10, List(5, 10)))
    //println(countChange(5, List(1,2)))
    println(pascal(0,0))
    
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def pascal(prevRow: List[Int], curRow:Int):Int = {
      if(curRow == r) prevRow(c)
      else pascal(getNextRow(prevRow), curRow + 1)
    }
    
    /**
     * Give a row in pascal's triangle, returns the next row
     */
    def getNextRow(row: List[Int]):List[Int] = {
    		def getRow(index:Int):List[Int] = {
           if(index == row.length) List(1)
           else if(index == 0) 1 :: getRow(index + 1)
           else (row(index) + row(index - 1)) :: getRow(index  +1)
        }
        getRow(0)
    }
    pascal(List(1), 0)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance(index:Int, stack:List[Char]):Boolean = {
      if(index == chars.length) stack.isEmpty
      else{
        val curChar = chars(index)
        if(curChar != '(' && curChar != ')') balance(index+1, stack)
        else if(curChar == ')' && stack.isEmpty) false
        else if(curChar == ')') balance(index+1, stack.tail)
        else balance(index + 1, '('::stack)
      }
     }
    balance(0, List())
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def getNumWays(curAmount:Int, curCoins:List[Int]):Int = {
      if(curAmount == 0) 1
      else if(curAmount < 0) 0
      else recurse(curAmount, curCoins)
    }
    
    def recurse(curAmount: Int, curCoins:List[Int]):Int = {
      if(curCoins.isEmpty) 0
      else getNumWays(curAmount - curCoins.head, curCoins) + recurse(curAmount, curCoins.tail)
    }
    recurse(money, coins)
  }
  
}
