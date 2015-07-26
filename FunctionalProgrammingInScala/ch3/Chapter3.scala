
//Functional linked list

//List datatype parametrized by type A
//traits in Scala are like Java interfaces that also may have concrete method implementations
//sealed means all implementations of this trait must be in this file
//The +A means that A is a covariant of List. That is, if X is a subtype of Y, then List[X] is a subtype of
//List[Y]
sealed trait List[+A] 
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

//Data types in Scala often have companion objects with the same name that contain convenience functions for working
//on the datatype. Companion objects are merely a convention and aren't strictly required.
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  //For data types in Scala, its a common idiom to have an apply method that can be used to create an instance of
  //the data type with the passed elements.
  def apply[A](as: A*): List[A] = //this is Scala's variadic function notation
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  //3.2
  //Implement the function tail for removing the first element of a List.
  //We'll visit what to do if the head of the list is Nil in the next chapter
  def tail[A](lst: List[A]):List[A] = lst match {
    case Nil => Nil
    case Cons(_,xs) => xs
  }

  //3.3
  //Implement the function setHead for replacing the first element of a List with a different value.
  def setHead[A](newHead: A, lst: List[A]): List[A] = lst match {
    case Nil => Cons(newHead, Nil)
    case Cons(_,xs) => Cons(newHead, xs)
  }

  //3.4
  //Generalize tail to the function drop, which removes the first n elements from a list.
  def drop[A](l: List[A], n: Int): List[A] =
    if (n == 0) l
    else drop(tail(l), n - 1)

  //3.5
  //Implement dropWhile, which removes elements from the List prefix as long as they match a predicate
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    def dropWhile(l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(x,xs) => if (f(x)) dropWhile(xs) else xs

    }
    dropWhile(l)
  }




}

