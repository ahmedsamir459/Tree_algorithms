import java.awt.color.ICC_Profile;

public interface ITree<T extends Comparable <T> > {
    ITree<T> insert(T data);
    void remove(T data);
    void traverse();
    T getMin();
    T getMax();
    boolean contains(T data);
    boolean isEmpty();
    int size();
    int height();
    void clear();

    Node<T> getRoot();
}
