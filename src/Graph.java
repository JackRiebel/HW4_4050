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
    public List<Edge> getAdjacencies(int vertex){
        return this.adjacencyList.get(vertex);
    }
    public void Prims(Graph g){
        int size = V;
        int[] isKnown = new int[size+1];
        float[] D = new float[size+1];
        for(int i = 1; i < size+1; i++) {
            D[i] = 9999999;
        }
        D[1] = 0;
        isKnown[1] = 1;
        Heap myHeap = new Heap(D,size);
        while(myHeap.min_key() != -1){
            int currentV = myHeap.min_id();
            isKnown[currentV] = 1;
            float dist = myHeap.key(myHeap.findId(currentV));
            myHeap.delete_min();
            List<Edge> currentEdges = this.adjacencyList.get(currentV);
            Edge theEdge = null;
            for(int i = 0; i < currentEdges.size(); i++){
                Edge itrEdge = currentEdges.get(i);
                if(itrEdge.getLength() == dist){
                    theEdge = itrEdge;
                    theEdge.printInfo();
                }
                else{
                    int otherV = itrEdge.findOtherV(currentV);
                    if(isKnown[otherV] == 0){
                        //If this is a new edge
                        if(itrEdge.getLength() < D[otherV]){
                            //If this edge provides a shorter path to the vertex, decrease that vertex's key in the heap.
                            D[otherV] = itrEdge.getLength();
                            myHeap.decrease_key(myHeap.findId(otherV), itrEdge.getLength());
                        }
                    }
                }
            }
        }
    }
}
