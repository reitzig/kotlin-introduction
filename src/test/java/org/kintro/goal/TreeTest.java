package org.kintro.goal;

import kotlin.jvm.functions.Function1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.kintro.goal.KTree.Leaf;
import static org.kintro.goal.KTree.Node;

/*
 * Example to show how to call Kotlin from Java.
 *
 * Step 1: Instantiate a KTree; note the static import.
 * Step 2: Access value via synthesized getter.
 * Step 3: Call higher-order function; note quick-fix towards Java lambda.
 * Step 4: Show how to call top-level functions.
 *         Mention that the synthesized class can be renamed.
 * Step 5: Pass null value to non-null parameter.
 * Optional: Show gotcha: can pass null for generic parameter!
 */

@DisplayName("KTree")
class TreeTest {
    @Test
    void should_have_getters_and_setters() {
        // Given
        KTree<Integer> example = new Node<>(77,
            new Leaf<>(17),
            new Leaf<>(11));

        // Then
        assertEquals(77, example.getValue());
        assertEquals(11, ((Node)example).getRight().getValue());

        // And when
        example.setValue(42);

        // Then
        assertEquals(42, example.getValue());
    }

    @Test
    void should_expose_top_level_functions() {
        // Given
        KTree<Integer> example = new Node<>(77,
            new Leaf<>(17),
            new Leaf<>(11));

        // Then
        assertTrue(KTreeKt.isInner(example)); // static import! JvmName!
    }

    @Test
    void should_swallow_java_functions() {
        // Given
        KTree<Integer> example = new Node<>(77,
            new Leaf<>(17),
            new Leaf<>(11));

        // When
        List<Integer> numbers = example.flatMap(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {
                return integer + 1;
            }
        });

        // Then
        assertEquals(List.of(78, 18, 12), numbers);
    }

    @Test
    void should_prevent_nulls() {
        // Given
        KTree<Integer> example = new Node<>(77,
            new Leaf<>(17),
            new Leaf<>(11));

        // Then
        assertThrows(IllegalArgumentException.class, () -> ((Node)example).setRight(null));

        // And
        assertThrows(IllegalArgumentException.class, () -> KTreeKt.isInner(null));
    }

    @Test
    void should_be_tricked_into_npes() {
        // Given
        KTree<Integer> example = new Leaf<>(77); // Note: This works because T = Integer! is valid.

        // Then
        assertDoesNotThrow(() -> example.setValue(null));

        // But
        assertThrows(NullPointerException.class, () -> example.flatMap(i -> i+1));

        // BUT: can change <T> to <T: Any> --> null checks generated and compiler warnings!
    }
}
