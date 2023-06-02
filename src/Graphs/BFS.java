package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS <T extends Comparable<T>>{
    private final Vertex<T> root;
    public BFS(Vertex<T> root){
        this.root=root;
    }
    public void bfs(){
        Queue<Vertex<T>> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Vertex<T> current=queue.poll();
            if (!current.isVisited()){
                current.setVisited(true);
                work(current);
                queue.addAll(current.getNeighbours());
            }
        }
    }
    private void work(Vertex<T> root){
        System.out.println(root.toString());
    }

}
