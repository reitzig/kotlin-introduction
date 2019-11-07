package org.kintro.prepared;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("JTree")
class JTreeTest {
    @Test
    void should_construct_correctly() {
        // Given
        var example = new JTree<>(77,
            new JTree<>(42,
                new JTree<>(7,
                    null,
                    null),
                new JTree<>(11,
                    null,
                    null)),
            new JTree<>(13,
                null,
                null));

        // Then
        assertEquals(77, example.getValue());
        assertEquals(42, example.getLeft().getValue());
        assertEquals(7, example.getLeft().getLeft().getValue());
        assertEquals(11, example.getLeft().getRight().getValue());
        assertEquals(13, example.getRight().getValue());
        assertNull(example.getRight().getRight());
        assertNull(example.getRight().getLeft());
    }

    @Test
    void should_print_correctly() {
        // Given
        var example = new JTree<>(77,
            new JTree<>(42,
                new JTree<>(7,
                    null,
                    null),
                new JTree<>(11,
                    null,
                    null)),
            new JTree<>(13,
                null,
                null));

        // When
        var printExample = example.toString();

        // Then
        assertEquals("(77, (42, 7, 11), 13)", printExample);
    }

    @Test
    void should_compare_correctly() {
        // Given
        var exampleA =  new JTree<>(42,
            new JTree<>(7,
                null,
                null),
            null);
        var exampleB =  new JTree<>(42,
            new JTree<>(7,
                null,
                null),
            null);
        var exampleC =  new JTree<>(42,
            new JTree<>(7,
                null,
                new JTree<>(2,
                    null,
                    null)),
            null);

        // Then
        assertEquals(exampleA, exampleB);
        assertEquals(exampleB, exampleA);
        assertNotEquals(exampleA, exampleC);
        assertNotEquals(exampleB, exampleC);
    }
}
