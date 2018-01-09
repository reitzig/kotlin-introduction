package org.kintro.goal;

import kotlin.jvm.functions.Function1;

import java.util.List;

import static org.kintro.goal.KTree.*;

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

public class TreeTest {
    public static void main(String[] args) {
        KTree<Integer> example = new Node<>(77,
                new Leaf<>(17),
                new Leaf<>(11));

        System.out.println(example);
        System.out.println(example.getValue());

        List<Integer> numbers = example.flatMap(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {
                return integer + 1;
            }
        });
        System.out.println(numbers);

        System.out.println(KTreeKt.isInner(example));

        //System.out.println(KTreeKt.isInner(null));

        // Note: This works because T = Integer! is valid.
        //KTree<Integer> nullTest = new Leaf<>(null);
        //System.out.println(nullTest.flatMap(i -> i+1));
    }
}
