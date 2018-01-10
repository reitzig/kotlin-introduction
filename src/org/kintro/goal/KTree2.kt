package org.kintro.goal

import org.kintro.goal.KTree2.*

/* Continuation of KTree.kt
 *
 * Step 1: Make children optional; show examples
 * Step 2: Add default parameters; show examples
 * Step 3: Demonstrate how navigating the tree is now more noisy.
 */

sealed class KTree2<T: Any> {
    abstract var value: T
    abstract fun <U> flatMap(f: (T) -> U) : List<U>

    data class Node<T: Any>(override var value: T, var left: KTree2<T>? = null, var right: KTree2<T>? = null) : KTree2<T>() {
        override fun toString(): String {
            return "($value, $left, $right)"
        }

        override fun <U> flatMap(f: (T) -> U): List<U> {
            // do pre-order
            return listOf(f(value)) +
                    (left?.flatMap(f) ?: emptyList()) +
                    (right?.flatMap(f) ?: emptyList())
        }
    }

    data class Leaf<T: Any>(override var value: T) : KTree2<T>() {
        override fun toString(): String {
            return value.toString()
        }

        override fun <U> flatMap(f: (T) -> U): List<U> {
            return listOf(f(value))
        }
    }
}

fun main(args: Array<String>) {
    val pseudoLeaf = Node(7, Leaf(3), null)
    print(pseudoLeaf)

    val pseudoLeaf2 = Node(7, Leaf(3))
    print(pseudoLeaf2)

    val leftist = Node(7, left = Leaf(3))
    print(leftist)
    val rightist = Node(7, right = Leaf(3))
    print(rightist)

    //println(rightist.right.flatMap { 1 })
}