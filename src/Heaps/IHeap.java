package Heaps;

public interface IHeap <T extends Comparable<T>>{
    IHeap<T> insert(T data);
    IHeap<T>buildHeap(T[] data);
    T remove();
    T peek();
    boolean isEmpty();
    int size();
    void sort();
    void clear();
    void print();
}
