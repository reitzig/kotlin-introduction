package org.kintro.goal

import org.kintro.goal.KTree.Leaf
import org.kintro.goal.KTree.Node
import org.kintro.prepared.JPerson

/*
 * Example to show how to use Java from Kotlin
 *
 * Step 0: Show JPerson
 * Step 1: Instantiate JPerson.
 * Step 2: Show synthesized property.
 * Step 3: Extend JPerson
 * Step 4: Show gotcha of platform type: can pass name = null.
 *         Show fixes (@NotNull resp. @Nullable in JPerson).
 * Optional: Show example for KTree<JPerson>
 * Optional: Show "equivalent" KPerson
 */

val JPerson.isOld: Boolean
    get() = this.age >= 30

fun main(args: Array<String>) {
    val john = JPerson("John Doe", 37, false)

    println("${john.name} (${john.age}, ${if (john.isFemale) "f" else "m"})")

    println("${john.name} is${if (john.isOld) "" else " not"} old")
    john.age = 29
    println("${john.name} is${if (john.isOld) "" else " not"} old")

    val incognito = JPerson(null, 99, true)
    println(incognito.name.length)

    val personTree = Node(
        JPerson("John", 37, false),
        Leaf(JPerson("Mary", 28, true)),
        Leaf(JPerson("Jane", 71, true))
    )
    println(personTree.flatMap { it.name })
}