package ShortestPath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class Node implements Comparable<Node> {

    private final String name;
    private Integer distance=Integer.MAX_VALUE;
    private List<Node> path=new LinkedList<>();
    private Map<Node,Integer> adjacentNodes=new HashMap<>();

    public Node(String a) {
        this.name=a;
    }

    public void addDestination(Node destination,int distance){
        adjacentNodes.put(destination,distance);
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance,o.distance);
    }
}
