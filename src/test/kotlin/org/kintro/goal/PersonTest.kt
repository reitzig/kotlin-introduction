package org.kintro.goal

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.kintro.goal.KTree.Leaf
import org.kintro.goal.KTree.Node
import org.kintro.prepared.JPerson
import kotlin.test.Test
import kotlin.test.assertEquals

/*
 * Example to show how to use Java from Kotlin
 *
 * Step 0: Show JPerson
 * Step 1: Instantiate JPerson.
 * Step 2: Show synthesized property.
 *         Show what happens if a setter is removed or made inaccessible.
 * Step 3: Extend JPerson
 * Step 4: Show gotcha of platform type: can pass name = null.
 *         Show fixes (@NotNull resp. @Nullable in JPerson).
 * Optional: Show example for KTree<JPerson>
 * Optional: Show "equivalent" KPerson; show bytecode and decompiled Java!
 */

val JPerson.isOld: Boolean
    get() = this.age >= 30

@DisplayName("JPerson")
class JPersonTest {
    @Test
    fun `should judge age correctly`() {
        fun ageStatement(p: JPerson) : String =
            "${p.name} is${if (p.isOld) "" else " not"} old"

        // Given
        val john = JPerson("John Doe", 37, false)

        // Then
        assertEquals("John Doe is old", ageStatement(john))

        // And when
        john.age = 29

        // Then
        assertEquals("John Doe is not old", ageStatement(john))
    }

    @Test
    fun `should hide nulls`() {
        // Given
        val incognito = JPerson(null, 99, true)

        // Then
        assertThrows<NullPointerException> { incognito.name.length }
    }

    @Test
    fun `should let itself be arranged in a tree`() {
        // Given
        val personTree = Node(
            JPerson("John", 71, false),
            Leaf(JPerson("Mary", 28, true)),
            Leaf(JPerson("Jane", 33, true))
        )

        // Then
        assertEquals(44.0, personTree.flatMap { it.age }.average())
    }
}
