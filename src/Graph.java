import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    //# of vertices
    private int V;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        this.adjacencyList = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }
    //Adds an edge to the adjacencyList of both vertices attached to the given edge.
    public void addEdge(Edge newEdge){
        int V1 = newEdge.getV1();
        int V2 = newEdge.getV2();
        this.adjacencyList.get(V1).add(newEdge);
        this.adjacencyList.get(V2).add(newEdge);
    }
    public int getSize(){
        return V;
    }
    public void printAdjacencies(){
        System.out.println("\n\nAdjacency List:\n-------------");
        for(int i = 1; i <= V; i++){
            System.out.println("\nVertex " + i + ":");
            List<Edge> currentEdges = adjacencyList.get(i);
            for(int j = 0; j < currentEdges.size(); j++){
                System.out.println("Connected to Vertex " + currentEdges.get(j).findOtherV(i) + " with weight " + currentEdges.get(j).getLength());
            }
        }
    }
    public List<Edge> getAdjacencies(int vertex){
        return this.adjacencyList.get(vertex);
    }
}
