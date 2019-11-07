package org.kintro.goal

import org.junit.jupiter.api.DisplayName
import org.kintro.goal.KTree2.Leaf
import org.kintro.goal.KTree2.Node
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("KTree")
class KTree2Test {
    @Test
    fun `should handle null children`() {
        // Given
        val pseudoLeaf = Node(7, Leaf(3), null)
        // Then
        assertEquals("(7, 3, null)", "$pseudoLeaf")

        // Given
        val pseudoLeaf2 = Node(7, Leaf(3))
        // Then
        assertEquals("(7, 3, null)", "$pseudoLeaf2")

        // Given
        val leftist = Node(7, left = Leaf(3))
        val rightist = Node(7, right = Leaf(3))
        // Then
        assertEquals("(7, 3, null) - (7, null, 3)", "$leftist - $rightist")
        assertEquals(listOf(1), rightist.right?.flatMap { 1 })
        assertEquals(null, rightist.left?.flatMap { 1 })
        assertEquals(listOf(), rightist.left?.flatMap { 1 } ?: listOf())
    }
}
