import lombok.Data;
import lombok.NonNull;

import java.awt.*;

@Data
public class Node<T extends Comparable<T>> {
    @NonNull
    private T data;
    private int height = 1;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private Color color = Color.RED;
    public boolean isLeftChild() {
        return parent != null && parent.getLeft() == this;
    }
    public void flipColor() {
       setColor(getColor() == Color.RED ? Color.BLACK : Color.RED);
    }

}
