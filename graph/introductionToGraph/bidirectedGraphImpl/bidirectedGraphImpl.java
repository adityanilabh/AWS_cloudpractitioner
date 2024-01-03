import java.util.*;
class Graph{
    List<List<Integer>>Edge;
    final int size;
    Graph(int size)
    {
        Edge= new ArrayList<>(size);
        this.size=size;
        for(int index=0;index<size;index++)
        {
            Edge.add(new ArrayList<>());
        }
    }
    public void insert(int vertex1, int vertex2)
    {
        Integer vertexInt=vertex1,vertexInt2=vertex2;
        // if vertex is empty
        if(Edge.get(vertexInt).isEmpty())
        {
              Edge.get(vertexInt).add(vertexInt2);
              Edge.get(vertexInt2).add(vertexInt);
        }
        //check if vertex is already present 
        else
        {
            int flag=0;
            for(Integer j: Edge.get(vertexInt))
            {
                Integer data= j;
                if(data==vertexInt2)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
               Edge.get(vertexInt).add(vertexInt2);
               Edge.get(vertexInt2).add(vertexInt);
            }
            
        }
    }

    public void print()
    {
        for(int index=0;index<size;index++)
        {
            if(!Edge.get(index).isEmpty())
            {
                System.out.print((index)+" ->");
                for(int i: Edge.get(index))
                {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
}
class bidirectedGraph{
    public static void main(String[] args)
    {
            Graph g= new Graph(7);
            g.insert(2,3);
            g.insert(3,4);
            g.insert(5,6);
            g.insert(6,5);
            g.print();
    }
}