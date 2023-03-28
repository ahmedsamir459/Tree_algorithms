package Heaps;

public abstract class Heap <T extends Comparable<T>> implements IHeap<T> {
    protected T[] heap;
    protected int position=-1;
    protected int size;
    protected abstract void fixup();
    protected abstract void fixDown(int position);
    public Heap(int size) {
        heap = (T[]) new Comparable[size];
    }
    @Override
    public IHeap<T> insert(T data) {
        if(position==heap.length-1) {
            resize();
        }
        heap[++position]=data;
        size++;
        fixup();
        return this;
    }
    private void resize() {
        T[] temp = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 0, temp, 0, heap.length);
        heap = temp;
    }
    protected void swap(int position, int parent) {
        T temp = heap[position];
        heap[position] = heap[parent];
        heap[parent] = temp;
    }
    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T data = heap[0];
        heap[0] = heap[position--];
        size--;
        fixDown(0);
        return data;
    }
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }
    @Override
    public boolean isEmpty() {
        return heap.length == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void sort() {
    }
    @Override
    public void clear() {
        heap = (T[]) new Comparable[10];
        position = -1;
    }
    @Override
    public void print() {
        for (int i = 0; i <= position; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
