import lombok.Data;
import lombok.NonNull;

import java.awt.*;

@Data
public class Node<T extends Comparable<T>> {
    private T data;
    private int height = 1;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private Color color = Color.RED;

    public Node(T data) {
        this.data = data;
    }

    public boolean isLeftChild() {
        return parent != null && parent.getLeft() == this;
    }
    public void flipColor() {
       setColor(getColor() == Color.RED ? Color.BLACK : Color.RED);
    }

    public boolean hasRedChild() {
        return (left != null && left.getColor() == Color.RED) || (right != null && right.getColor() == Color.RED);
    }
}
