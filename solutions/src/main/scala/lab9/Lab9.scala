package scalatraining.lab9

import collection.mutable.{Set, HashSet}

/**
 * Lab 9: Learn about pattern matching and case classes.
 */
object Lab9 {
  sealed abstract trait Tree
  case class Leaf(value: String) extends Tree
  case class Branch(left: Tree, right: Tree) extends Tree

  /**
   * Should traverse the whole tree by using recursive pattern matching.
   * Should return a scala Set with all Leaf values aggregated.
   */
  def aggregateLeafValues(tree: Tree): Set[String] = {
    val allValues = new HashSet[String]
    def aggregate(tree: Tree, accumulator: Set[String]): Unit = tree match {
      case Leaf(value) =>
        accumulator += value
      case Branch(left: Tree, right: Tree) =>
        aggregate(left, accumulator)
        aggregate(right, accumulator)
    }
    aggregate(tree, allValues)
    allValues
  }
}