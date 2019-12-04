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

import org.junit.jupiter.api.Test;

import static Google.Problem4.isUnival;
import static org.assertj.core.api.Assertions.assertThat;

class Test4 {

    @Test
    void isUnival_shouldReturnFive_whenValidIntegerValues() {

        Node root = new Node<>(0, new Node<>(1), new Node<>(0, new Node<>(1, new Node<>(1), new Node<>(1)), new Node<>(0)));
        assertThat(isUnival(root)).isEqualTo(5);
    }

    @Test
    void isUnival_shouldReturnFive_whenValidStringValues() {

        Node root = new Node<>("0", new Node<>("1"), new Node<>("0", new Node<>("1", new Node<>("1"), new Node<>("1")), new Node<>("0")));
        assertThat(isUnival(root)).isEqualTo(5);
    }

    @Test
    void isUnival_shouldReturnOne_whenOneValueInput() {

        Node root = new Node<>(1);
        assertThat(isUnival(root)).isEqualTo(1);
    }

    @Test
    void isUnival_shouldReturnThree_whenThreeSameInput() {

        Node root = new Node<>(1, new Node<>(1), new Node<>(1));
        assertThat(isUnival(root)).isEqualTo(3);
    }

    @Test
    void isUnival_shouldReturnZero_whenNullInput() {

        assertThat(isUnival(null)).isEqualTo(0);
    }
}
