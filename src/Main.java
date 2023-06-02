import Graphs.BFS;
import Graphs.DFS;
import Graphs.Vertex;
import Heaps.IHeap;
import Heaps.MaxHeap;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(9);
        heap.buildHeap(new Integer[]{7, 2, 6, 4, 5, 3, 1, 8, 9});
        for (int i = 0; i < 9; i++)
        System.out.println(heap.remove());

//        System.out.println(Arrays.toString(heap.heap));
    }

}
