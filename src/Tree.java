public interface Tree <T extends Comparable <T> > {
    Tree<T> insert(T data);
    void remove(T data);
    void traverse();
    T getMin();
    T getMax();
    boolean contains(T data);
    boolean isEmpty();
    int size();
    int height();
    void clear();
}
