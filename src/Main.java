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
            System.out.println(count);
            ArrayList<String> data = new ArrayList<String>();
            while(fReader.hasNext()){
                data.add(fReader.nextLine());
            }
            for(int i = 0; i < 22; i++){
                System.out.println(data.get(i));
            }
            Graph myGraph = new Graph(count);
            ArrayList<Edge> myEdges= new ArrayList<Edge>();
            for(int i = 0; i < count; i++){
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
            myGraph.Prims(myGraph);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found\n");
        }
   }
}