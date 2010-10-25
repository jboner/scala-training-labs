package scalatraining.lab2

object Lab2 {
  def firstElementInList[T](l: List[T]): T = {
    //buildin
      l.head
  }

  def lastElementInList[T](l: List[T]): T = {
    //buildin: l.last
     //almost buildin: l.reverse.head

    //custom version: pattern match
     def myLast1[T](l: List[T]) : T = {
       l match {
          case head :: Nil => head
          case _ :: tail => myLast1(tail)
          case _ => error("last on empty list")
       }
     }

    //custom version2: using fold
    def myLast2[T](l:List[T]): T = {
      l.foldLeft(l.headOption){(a,b) => Some(b)}.getOrElse(error("last on empty list"))
    }
     myLast1(l)
  }

  def concatLists(list1: List[String], list2: List[String]): List[String] = {
    list1 ::: list2
  }

  def sortList(list: List[String]):List[String] = {
    list.sortWith(_ < _)
  }
  
  def elementExists(theList: List[String], elementToSearchFor: String): Boolean = {
    theList.exists(_ == elementToSearchFor)
  }

  def oddElements(listOfInts: List[Int]): List[Int] = {
    listOfInts.filter(_ % 2 != 0)
  }
}


