package Graphs;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
public class Vertex <T extends Comparable<T>> {
    private final T data;
    private boolean visited;
    @ToString.Exclude
    private List<Vertex<T>> neighbours=new LinkedList<>();

}

