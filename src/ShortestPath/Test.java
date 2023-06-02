package ShortestPath;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Node nodeA=new Node("A");
        Node nodeB=new Node("B");
        Node nodeC=new Node("C");
        Node nodeD=new Node("D");
        Node nodeE=new Node("E");
        Node nodeF=new Node("F");
        nodeA.addDestination(nodeB,2);
        nodeA.addDestination(nodeC,4);
        nodeB.addDestination(nodeC,3);
        nodeB.addDestination(nodeD,1);
        nodeB.addDestination(nodeE,5);
        nodeC.addDestination(nodeD,2);
        nodeD.addDestination(nodeE,1);
        nodeE.addDestination(nodeF,2);
        nodeD.addDestination(nodeF,4);
        ShortestPath.dijkstra(nodeA);
        printPath(List.of(nodeA,nodeB,nodeC,nodeD,nodeE,nodeF));
    }

    private static void printPath(List<Node> node){
        node.forEach(n->{
            String path=n.getPath().stream().map(Node::getName).collect(Collectors.joining(" -> "));
            System.out.println(path.isBlank()
                    ?"%s : %s".formatted(n.getName(),n.getDistance()):
                    "%s -> %s : %s".formatted(path,n.getName(),n.getDistance()));
        });
    }
}
