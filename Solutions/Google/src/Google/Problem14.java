package Google;

/*

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
Given the root to a binary tree, count the number of unival subtrees.
For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1

*/

class Problem4 {

    static int isUnival(Node<?> node) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node)) {
            return 1;
        }

        if (isNodeValueEqualToChildrenValues(node)
                && isSubTreeUnival(node.getLeft(), node.getValue())
                && isSubTreeUnival(node.getRight(), node.getValue())) {
            return 1 + isUnival(node.getLeft()) + isUnival(node.getRight());
        }

        return isUnival(node.getLeft()) + isUnival(node.getRight());
    }

    private static boolean isNodeValueEqualToChildrenValues(Node<?> node) {
        return node.getValue().equals(node.getLeft().getValue())
                && node.getValue().equals(node.getRight().getValue());
    }

    private static <T> boolean isSubTreeUnival(Node<T> node, T parentValue) {
        return (isLeaf(node)) || (node.getLeft().getValue().equals(parentValue)
                && node.getRight().getValue().equals(parentValue)
                && isSubTreeUnival(node.getLeft(), parentValue)
                && isSubTreeUnival(node.getRight(), parentValue));
    }

    private static boolean isLeaf(Node<?> node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
