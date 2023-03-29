import Heaps.IHeap;
import Heaps.MaxHeap;

public class Main {
    public static void main(String[] args) {
        IHeap<Integer> heap = new MaxHeap<Integer>(10);
//        9, 12, 7, 2, 5, 1, 6
        Integer [] data = {9, 12, 7, 2, 5, 1, 6};
        heap.buildHeap(data);
        heap.print();
    }

}
