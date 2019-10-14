package Google;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Node<T> {

    private T value;
    private Node left;
    private Node right;

    Node(T value) {
        this.value = value;
    }

    Node(T value, Node left) {
        this.value = value;
        this.left = left;
    }

    Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
