package Heaps;

public class MinHeap <T extends Comparable<T>> extends Heap<T>{
    public MinHeap(int size) {
        super(size);
    }

    @Override
    protected void fixup() {
        int index = this.position;
        int parent = (index - 1) / 2;
        while (index >0 && heap[index].compareTo(heap[parent])<0) {
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
                if(child+1<=data.length-1&&heap[child].compareTo(heap[child+1])<0){
                    child++;
                }
                if(heap[index].compareTo(heap[child])>0){
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
        int smallest = position;
        if (left<size()&&heap[left].compareTo(heap[smallest])<0){
            smallest=left;
        }
        if (right<size()&&heap[right].compareTo(heap[smallest])<0){
            smallest=right;
        }
        if(smallest!=position){
            swap(position,smallest);
            fixDown(smallest);
        }
    }

}
