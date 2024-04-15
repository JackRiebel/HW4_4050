import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int V;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        this.adjacencyList = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Other methods of the Graph class...
}
