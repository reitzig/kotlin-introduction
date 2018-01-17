package org.kintro.prepared;

/*
 * For reference, a Java implementation of binary trees.
 * Note the boilerplate.
 *
 * Note that the `J` and `K` prefix are not by convention; we only use
 * them here to see clearly which type is implemented in which language.
 */

public final class JTree<T> {
    private T value;
    private JTree<T> left;
    private JTree<T> right;

    public JTree(T value, JTree<T> left, JTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public JTree getLeft() {
        return left;
    }

    public void setLeft(JTree<T> left) {
        this.left = left;
    }

    public JTree getRight() {
        return right;
    }

    public void setRight(JTree<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        if (this.left == null && this.right == null) {
            return this.value.toString();
        }

        String left = "_";
        if (this.left != null) {
            left = this.left.toString();
        }
        String right = "_";
        if (this.right != null) {
            right = this.right.toString();
        }

        return "(" + this.value + ", " + left + ", " + right + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof JTree)) {
            return false;
        } else {
            JTree other = (JTree) obj;
            return value.equals(other.value)
                    && left.equals(other.left)
                    && right.equals(other.right);
        }
    }
}
