package scalatraining.lab3

import collection.mutable.ListBuffer

object Lab3 {
  case class Person(age: Int, firstName: String, lastName: String)
  object Person {
    def sort(a: Person, b: Person) = a.age < b.age
  }

  /**
   * Start easy: Return the largest Int in the List (hint: use sort)
   */
  def maxElementInList(l: List[Int]): Int = {
    error("fix me")
  }

  /**
   * Should return a tuple of two list:
   *   - List 1: the names (String) of all boys (younger than 18 y) sorted
   *   - List 1: the names (String) of all men (older than 18 y) sorted
   */
  def separateTheMenFromTheBoys(persons: List[Person]): Tuple2[List[String], List[String]] = {
    var boys: ListBuffer[Person] = new ListBuffer[Person]()
    var men: ListBuffer[Person] = new ListBuffer[Person]()
    var validBoyNames: ListBuffer[String] = new ListBuffer[String]()
    var validMenNames: ListBuffer[String] = new ListBuffer[String]()

    for (person <- persons) {
      if (person.age < 18) {
        boys += person
      } else {
        men += person
      }
    }
    //TODO can this be made even more imperative?
    var sortedBoys = boys.toList.sortWith(Person.sort _)
    var sortedMen = men.toList.sortWith(Person.sort _)
    
    for (boy <- sortedBoys) {
      validBoyNames += boy.firstName
    }
    for (man <- sortedMen) {
      validMenNames += man.firstName
    }
    (validBoyNames.toList, validMenNames.toList)
  }
}