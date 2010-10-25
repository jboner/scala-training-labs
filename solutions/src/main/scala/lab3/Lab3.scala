package scalatraining.lab3

object Lab3 {
  case class Person(age: Int, firstName: String, lastName: String)
  object Person {
    def sort(a: Person, b: Person) = a.age < b.age
  }

  /**
   * Start easy: Return the largest Int in the List (hint: use sort)
   */
  def maxElementInList(l: List[Int]): Int = {
    l.sortWith(_ > _).head                                                          
  }

  /**
   * Should return a tuple of two list:
   *   - List 1: the names (String) of all boys (younger than 18 y) sorted
   *   - List 1: the names (String) of all men (older than 18 y) sorted
   */
  def separateTheMenFromTheBoys(persons: List[Person]): Tuple2[List[String], List[String]] = {
    (persons.filter(person => person.age < 18).sortWith((arg1, arg2) => Person.sort(arg1, arg2)).map(person => person.firstName),
    persons.filter(_.age >= 18).sortWith(Person.sort _).map(_.firstName))
  }

  def sortPerson(a: Person, b: Person) = a.age < b.age
}