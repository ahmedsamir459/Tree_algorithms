import Heaps.IHeap;
import Heaps.MaxHeap;
import Trees.AvlTree;
import Trees.ITree;
import Trees.Node;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Trees.BInarySearchTree.printTree;

public class Main {
    public static void main(String[] args) {
        IHeap<Integer> heap = new MaxHeap<Integer>(10);
//        9, 12, 7, 2, 5, 1, 6
        Integer [] data = {9, 12, 7, 2, 5, 1, 6};
        heap.buildHeap(data);
        heap.print();
    }

}
