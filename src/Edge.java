public class Edge {
    private int V1;
    private int V2;
    private float length;

    public Edge(int vert1, int vert2, float dist){
        V1 = vert1;
        V2 = vert2;
        length = dist;
    }
    public float getLength(){
        return length;
    }
    public int getV1(){
        return V1;
    }
    public int getV2(){
        return V2;
    }
    public int findOtherV(int vert){
        if(vert == V1){
            return V2;
        }
        else{
            return V1;
        }
    }
    public void printInfo(){
        System.out.println("(" + V1 + ", " + V2 + "). Weight = " + length);
    }
    public void Prims(Graph g){

    }
}
