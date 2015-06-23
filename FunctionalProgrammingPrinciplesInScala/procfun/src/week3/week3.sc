object week3 {
  println("Welcome to the Scala worksheet")
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

object Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	override def toString = "."
	def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def incl(x: Int): IntSet =
		if(x < elem) left contains x
		else if(x > elem) right contains x
		else true
	
	override def toString = "{" + left + elem + right + "}"
	def union(other: IntSet): IntSet =
		((left union right) union other) incl elem
}