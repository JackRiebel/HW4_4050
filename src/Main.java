import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try{
            File f = new File("graph.txt");
            Scanner fReader = new Scanner(f);
            String countStr = fReader.nextLine();
            int count = Integer.parseInt(countStr);
            ArrayList<String> data = new ArrayList<String>();
            while(fReader.hasNext()){
                data.add(fReader.nextLine());
            }
            Graph myGraph = new Graph(count);
            ArrayList<Edge> myEdges= new ArrayList<Edge>();
            for(int i = 0; i < data.size(); i++){
                String[] splitData = data.get(i).split("\\s+");
                int x = 0;
                if(splitData.length == 4){
                    x = 1;
                }
                int V1 = Integer.valueOf(splitData[0+x]);
                int V2 = Integer.parseInt(splitData[1+x]);
                float weight = Float.parseFloat(splitData[2+x]);
                Edge newEdge = new Edge(V1, V2, weight);
                myGraph.addEdge(newEdge);
            }
            myGraph.printAdjacencies();
            Prims(myGraph);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found\n");
        }
   }
   //Prints the edges of the MST of graph g
    public static void Prims(Graph g){
        System.out.println("\n\n\nMinimum Spanning Tree using Prim's Algorithm\n--------------------------------------------");
        int size = g.getSize();
        int[] isKnown = new int[size+1];
        float[] D = new float[size+1];
        //Array D holds the current lengths
        for(int i = 1; i < size+1; i++) {
            D[i] = 9999999;
        }
        //Starts with arbitrary vertex 1
        D[1] = 0;
        isKnown[1] = 1;
        Heap myHeap = new Heap(D,size);
        //Extract every value from the min heap
        while(myHeap.min_key() != -1){
            //Pulls the current min from priority queue.
            int currentV = myHeap.min_id();
            isKnown[currentV] = 1;
            float dist = myHeap.key(myHeap.findId(currentV));
            myHeap.delete_min();
            //Finding edges of current vertex.
            List<Edge> currentEdges = g.getAdjacencies(currentV);
            Edge theEdge = null;
            for(int i = 0; i < currentEdges.size(); i++){
                Edge itrEdge = currentEdges.get(i);
                if(itrEdge.getLength() == dist){
                    //If the current edge is the edge that connects current V to MST.
                    theEdge = itrEdge;
                    theEdge.printInfo();
                }
                else{
                    //Updating the priority queue with new edges.
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