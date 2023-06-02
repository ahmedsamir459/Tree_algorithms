package Heaps;

import javafx.scene.layout.Priority;

import java.util.*;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
    public MaxHeap(int size) {
        super(size);
    }

    @Override
    protected void fixup() {
        int index = position;
        int parent = (position - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parent]) > 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }
    @Override
    public IHeap<T> buildHeap(T[] data) {
        heap = data;
        size = data.length;
        for(int i = data.length / 2-1; i >= 0; i--) {
            T root = heap[i];
            position = 2 * i + 1;
            while (position < data.length) {
                if (position + 1 < data.length && heap[position].compareTo(heap[position + 1]) < 0) {
                    position++;
                }
               if(root.compareTo(heap[position])>0){
                   break;
               }
                heap[(position - 1) / 2] = heap[position];
                position = 2 * position + 1;
            }
            heap[(position - 1) / 2] = root;
        }
        position = data.length-1;
        return this;
    }

    @Override
    protected void fixDown(int position) {

        int left = 2 * position + 1;
        int right = 2 * position + 2;
        int largest = position;
        if (left < size() && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }
        if (right < size() && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }
        if (largest != position) {
            swap(position, largest);
            position = largest;
            fixDown(position);
        }
    }
    public T[] getHeap(){
        return heap;
    }
}
