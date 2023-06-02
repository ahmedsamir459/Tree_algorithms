package Graphs;

public class DFS <T extends Comparable<T>>{
    private final Vertex<T> root;
    public DFS(Vertex<T> root){
        this.root=root;
    }
    public void dfs(){
        dfs(root);
    }
    private void dfs(Vertex<T> root){
        root.setVisited(true);
        work(root);
        root.getNeighbours().stream().filter(vertex -> !vertex.isVisited()).forEach(this::dfs);
    }
    private void work(Vertex<T> root){
        System.out.println(root.toString());
    }
}
