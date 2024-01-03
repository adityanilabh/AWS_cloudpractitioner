import java.util.*;
class Graph{
     List<List<Integer>>Edge;
     Graph(int size){
           Edge= new ArrayList<>(size);
           for(int index=0;index<size;index++)
           {
               Edge.add(new ArrayList<>());
           }
     }
     public void insert(int u,int v)
     {
        Integer U=u;
        Integer V=v;
        Edge.get(U-1).add(V);
     }
    public void print()
    {
         for(int i=0;i<Edge.size();i++)
         {
              if(!Edge.get(i).isEmpty())
              {
                System.out.print((i+1)+"->");
              for(int j : Edge.get(i))
              {
                  System.out.print(" "+j);
              }
              }
              System.out.println();
         }
    }
}
class directedGraphImpl{
    public static void main(String[] args)
    {
Graph g= new Graph(6);
       g.insert(1,3);
       g.insert(3,2);
       g.insert(1,4);
       g.print();
    }
       
}

