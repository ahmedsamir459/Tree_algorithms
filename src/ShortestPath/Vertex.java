package ShortestPath;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Vertex <T>{
    private final T data;
    private boolean visited;
    private Map<Vertex<T>,Integer> neighbours=new HashMap<>();
}
