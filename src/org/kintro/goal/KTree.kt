package org.kintro.goal

import org.kintro.goal.KTree.*

/*
 * Main example.
 *
 * Step 1: Implement minimal sealed+data classes.
 *         Show example value and print.
 * Step 2: Show automatically meaningful `==`.
 * Step 3: Show that `when` over `KTree` is exhaustive.
 * Step 4: Implement `flatMap` as higher-order function.
 *         Show example usage.
 * Step 5: Implement `KTree.size` in terms of flatMap.
 * Optional: Show that `Leaf(null)` works (--> Nothing? type inferred)
 * Step 6: Demonstrate that we _can_ create `KTree<Int?>`, and how to prevent with `T: Any`
 * Optional: Why did `value.toString()` work even with `T: Any?`? -- extension methods on `Any?`
 * Step 7: Demonstrate that `KTree<Int>` can't take null values; have to set both children.
 *
 * --> KTree2.kt
 */

sealed class KTree<T> {
    abstract var value: T
    abstract fun <U> flatMap(f: (T) -> U) : List<U>

    val size: Int
        get() = flatMap { true }.size

    data class Node<T>(override var value: T, var left: KTree<T>, var right: KTree<T>) : KTree<T>() {
        override fun toString(): String {
            return "($value, $left, $right)"
        }

        override fun <U> flatMap(f: (T) -> U): List<U> {
            // do pre-order
            return listOf(f(value)) + left.flatMap(f) + right.flatMap(f)
        }
    }

    data class Leaf<T>(override var value: T) : KTree<T>() {
        override fun toString(): String {
            return value.toString()
        }

        override fun <U> flatMap(f: (T) -> U): List<U> {
            return listOf(f(value))
        }
    }
}

fun <T> isInner(t: KTree<T>) : Boolean {
    return when ( t ) {
        is Node -> true
        is Leaf -> false
        else -> false
    }
}

fun main(args: Array<String>) {
    val example = Node(77,
            Node(42,
                    Leaf(7),
                    Leaf(11)),
            Leaf(13)
    )

    println(example)

    println(Leaf(42) == Leaf(42))
    println(Leaf(42) == Leaf(43))

    val halves = example.flatMap { it.toDouble()/2 }
    println(halves)
    println(halves.fold(0.0, { acc: Double, fl: Double -> acc + fl }))

    println(example.size)

    val nullLeaf = Leaf(null)
    println(nullLeaf)
    //val nulled = Leaf<Int>(null)
}