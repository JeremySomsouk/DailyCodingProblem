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

import org.junit.jupiter.api.Test;

import static Google.Problem2.deserialize;
import static Google.Problem2.serialize;
import static org.assertj.core.api.Assertions.assertThat;

class Test2 {

    @Test
    void serializeDeserialize_shouldReturnValue() {

        Node root = new Node<>("root", new Node("left", new Node("left.left")), new Node("right"));
        assertThat(deserialize(serialize(root)).getLeft().getLeft().getValue()).isEqualTo("left.left");
    }

    @Test
    void serializeDeserialize_shouldReturnValueNullChild_whenOnlyRootNode() {

        Node root = new Node<>("root");

        String serializedRoot = serialize(root);
        assertThat(serializedRoot).isEqualTo("root-/-/-");

        Node deserializedNode = deserialize(serializedRoot);
        assertThat(deserializedNode.getLeft()).isNull();
        assertThat(deserializedNode.getRight()).isNull();
    }

    @Test
    void serializeDeserialize_shouldReturnLeftValue_whenRootAndLeftChild() {

        Node left = new Node<>("left");
        Node root = new Node<>("root", left);

        String serializedNode = serialize(root);
        assertThat(serializedNode).isEqualTo("root-left-/-/-/-");

        Node deserializedNode = deserialize(serializedNode);
        assertThat(deserializedNode.getLeft()).isEqualTo(left);
        assertThat(deserializedNode.getRight()).isNull();
    }
}
