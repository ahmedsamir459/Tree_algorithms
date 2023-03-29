
class RB_Node<T extends Comparable<T>> {

    public static final int BLACK = 0;
    public static final int RED = 1;

    public T key;

    RB_Node<T> parent;
    RB_Node<T> left;
    RB_Node<T> right;

    public int numLeft = 0;

    public int numRight = 0;

    public int color;

    RB_Node() {
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }


    RB_Node(T key) {
        this();
        this.key = key;
    }
}

