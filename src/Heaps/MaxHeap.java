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
        for (int i = (data.length - 1) / 2; i >= 0; i--) {
            int index = i;
            int child= 2 * i + 1;
            while(child<=data.length-1){
                if(child+1<=data.length-1&&heap[child].compareTo(heap[child+1])>0){
                    child++;
                }
                if(heap[index].compareTo(heap[child])<0){
                    swap(index,child);
                    index=child;
                    child=2*index+1;
                }else{
                    break;
                }
            }
        }
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
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ints : richer) {
            graph[ints[1]].add(ints[0]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(graph, quiet, ans, i);
        }
        return ans;

    }

    private void dfs(List<Integer>[] graph, int[] quiet, int[] ans, int i) {
        if (ans[i] != -1) {
            return;
        }
        ans[i] = i;
        for (int j : graph[i]) {
            dfs(graph, quiet, ans, j);
            if (quiet[ans[j]] < quiet[ans[i]]) {
                ans[i] = ans[j];
            }
        }
    }
}
