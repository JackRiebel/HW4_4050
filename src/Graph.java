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
    public void addEdge(Edge newEdge){
        int V1 = newEdge.getV1();
        int V2 = newEdge.getV2();
        this.adjacencyList.get(V1).add(newEdge);
        this.adjacencyList.get(V2).add(newEdge);
    }
    public Edge[] findEdges(int V){
        return null;
    }
    public void Prims(Graph g){
        int size = V;
        float totalWeight = 0;
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
            System.out.println("\n\nCurrent Vertex: " + currentV + ". Length = " + dist + ".");
            List<Edge> currentEdges = this.adjacencyList.get(currentV);
            Edge theEdge = null;
            for(int i = 0; i < currentEdges.size(); i++){
                Edge itrEdge = currentEdges.get(i);
                //System.out.println("Current Edge: (" + itrEdge.getV1() + ", " + itrEdge.getV2() + "). len = " + itrEdge.getLength());
                if(itrEdge.getLength() == dist){
                    theEdge = itrEdge;
                    totalWeight = totalWeight + theEdge.getLength();
                    theEdge.printInfo();
                }
                else{
                    int otherV = itrEdge.findOtherV(currentV);
                    if(isKnown[otherV] == 0){
                        if(itrEdge.getLength() < D[otherV]){
                            D[otherV] = itrEdge.getLength();
                            //System.out.println("D[" + otherV + "]: " + D[otherV] + "\nitrEdge.getLength(): " + itrEdge.getLength());
                            //System.out.println("myheap.findId(otherV) = " + myHeap.findId(otherV));
                            myHeap.decrease_key(myHeap.findId(otherV), itrEdge.getLength());
                        }
                    }
                }
            }
        }
        System.out.println(totalWeight);
    }



    // Other methods of the Graph class...
}
