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

import static org.assertj.core.api.Assertions.assertThat;

class Test2 {

    @Test
    void serializeDeserialize_shouldReturnValue() {

        Problem2.Node root = new Problem2.Node("root", new Problem2.Node("left", new Problem2.Node("left.left")), new Problem2.Node("right"));
        assertThat(Problem2.deserialize(Problem2.serialize(root)).getLeft().getLeft().getValue()).isEqualTo("left.left");
    }

    @Test
    void serializeDeserialize_shouldReturnValueNullChild_whenOnlyRootNode() {

        Problem2.Node root = new Problem2.Node("root");

        String serializedRoot = Problem2.serialize(root);
        assertThat(serializedRoot).isEqualTo("root-/-/-");

        Problem2.Node deserializedNode = Problem2.deserialize(serializedRoot);
        assertThat(deserializedNode.getLeft()).isNull();
        assertThat(deserializedNode.getRight()).isNull();
    }

    @Test
    void serializeDeserialize_shouldReturnLeftValue_whenRootAndLeftChild() {

        Problem2.Node left = new Problem2.Node("left");
        Problem2.Node root = new Problem2.Node("root", left);

        String serializedNode = Problem2.serialize(root);
        assertThat(serializedNode).isEqualTo("root-left-/-/-/-");

        Problem2.Node deserializedNode = Problem2.deserialize(serializedNode);
        assertThat(deserializedNode.getLeft()).isEqualTo(left);
        assertThat(deserializedNode.getRight()).isNull();
    }
}
