package org.kintro.goal

import org.junit.jupiter.api.DisplayName
import org.kintro.goal.KTree.Leaf
import org.kintro.goal.KTree.Node
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@DisplayName("KTree")
class KTreeTest {
    @Test
    fun `should construct correctly`() {
        // Given
        val example = Node(77,
            Node(42,
                Leaf(7),
                Leaf(11)
            ),
            Leaf(13)
        )

        // Then
        assertEquals(77, example.value)
        assertEquals(42, example.left.value)
        val left = example.left  // Need to "fix" so smart-cast can work!
        assertTrue(left is Node)
        assertEquals(7, left.left.value)
        assertEquals(11, left.right.value)

    }

    @Test
    fun `should print correctly`() {
        // Given
        val example = Node(77,
            Node(42,
                Leaf(7),
                Leaf(11)
            ),
            Leaf(13)
        )

        // Then
        assertEquals("(77, (42, 7, 11), 13)", "$example")
    }

    @Test
    fun `should compare correctly`() {
        // Given
        val exampleA = Node(77, Leaf(7), Leaf(3))
        val exampleB = Node(77, Leaf(7), Leaf(3))
        val exampleC = Node(77, Leaf(6), Leaf(3))

        // Then
        assertTrue(exampleA == exampleB)
        assertTrue(exampleB == exampleA)
        assertTrue(exampleA != exampleC)
    }

    @Test
    fun `should distinguish inner nodes`() {
        // Given
        val example = Node(77,
            Node(42,
                Leaf(7),
                Leaf(11)
            ),
            Leaf(13)
        )

        // Then
        assertTrue(isInner(example))
        assertTrue(isInner(example.left))
        assertFalse(isInner(example.right))
    }

    @Test
    fun `should sequentialize correctly`() {
        // Given
        val example = Node(77,
            Node(42,
                Leaf(7),
                Leaf(11)
            ),
            Leaf(13)
        )

        // When
        val exampleSeq = example.flatMap { "$it" }

        // Then
        assertEquals(listOf("77", "42", "7", "11", "13"), exampleSeq) // pre-order!

        // And when
        val exampleSum = example.flatMap { it.toDouble() / 2 }.sum()

        // Then
        assertEquals(75.0, exampleSum)
    }

    @Test
    fun `should determine size correctly`() {
        // Given
        val example = Node(77,
            Node(42,
                Leaf(7),
                Leaf(11)
            ),
            Leaf(13)
        )

        // Then
        assertEquals(5, example.size)
    }

    @Test
    fun `should allow null leaves`() {
        // Given
        val example = Node<Int?>(77, Leaf(42), Leaf(null))

        // Then
        assertEquals("(77, 42, null)", "$example")
    }
}
