package Google;

/*

Given the root to a binary tree,
implement :
- serialize(root), which serializes the tree into a string,
- deserialize(s), which de-serializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'

*/

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem2 {

    private static final String EMPTY_MARKER = "/";

    static String serialize(Node node) {

        if (node == null) {
            return EMPTY_MARKER + "-";
        }

        return node.value + "-" + serialize(node.left) + serialize(node.right);
    }

    static Node deserialize(String serializedNode) {

        List<String> nodeList = Arrays.asList(serializedNode.split("-"));
        Queue<String> nodeQueue = new LinkedList<>(nodeList);
        return deserialize(nodeQueue);
    }

    private static Node deserialize(Queue<String> serializedNodes) {

        if (serializedNodes.peek() != null) {

            String nodeValue = serializedNodes.poll();
            if (nodeValue.equals(EMPTY_MARKER)) {
                return null;
            }

            Node node = new Node(nodeValue);
            node.left = deserialize(serializedNodes);
            node.right = deserialize(serializedNodes);

            return node;
        }

        return null;
    }

    @Getter
    @EqualsAndHashCode
    static class Node {

        private String value;
        private Node left;
        private Node right;

        Node(String value) {
            this.value = value;
        }

        Node(String value, Node left) {
            this.value = value;
            this.left = left;
        }

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
