package org.kintro.prepared;

/*
 * For reference, short examples of JTree.
 */

public class JMain {
    public static void main(String[] args) {
        JTree<Integer> example = new JTree<>(77,
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

        System.out.println(example);

        System.out.println(new JTree<>(null, null, null));
    }
}
