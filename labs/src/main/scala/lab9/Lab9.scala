package scalatraining.lab9

import collection.mutable.{Set, HashSet}

/**
 * Lab 9: Learn about pattern matching and case classes.
 * <p/>
 * Your job is to:
 *   - Create the case class hierarchy for the tree (Tree, Leaf, Branch)
 *   - Traverse the whole tree by using recursive pattern matching.
 *   - Return a scala Set with all Leaf values aggregated.
 */
object Lab9 {
  sealed abstract trait Tree

  def aggregateLeafValues(tree: Tree): Set[String] = {
    val allValues = new HashSet[String]

    // Hint: use a nested method here
    
    allValues
  }
}