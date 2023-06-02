package ShortestPath;

import java.util.*;
import java.util.stream.Stream;

public class ShortestPath {
    static public void dijkstra(Node source){
        source.setDistance(0);
        Set<Node> settledNodes=new HashSet<>();
        Queue<Node> unsettledNodes=new PriorityQueue<>(Collections.singleton(source));
        while(!unsettledNodes.isEmpty()){
            Node currentNode=unsettledNodes.poll();
            currentNode.getAdjacentNodes()
                            .entrySet().stream()
                            .filter(nodeIntegerEntry -> !settledNodes.contains(nodeIntegerEntry.getKey()))
                                    .forEach(entry->{
                                        Node adjacentNode=entry.getKey();
                                        Integer newDistance=currentNode.getDistance()+ entry.getValue();
                                        if (newDistance<adjacentNode.getDistance()){
                                            adjacentNode.setDistance(newDistance);
                                            adjacentNode.setPath(Stream.concat(currentNode.getPath().stream(),Stream.of(currentNode)).toList());
                                        }
                                        unsettledNodes.add(adjacentNode);
                                    });
            settledNodes.add(currentNode);
        }

    }
}
