import java.io.*;
import java.util.*;
public class Main {
    private int V;
    private LinkedList<Integer> MyLL[];
    public Main(int v)
    {
        V = v;
        MyLL = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            MyLL[i] = new LinkedList();
    }
    void addEdge(int v, int w)
    {
        MyLL[v].add(w);
    }
    void DFS_Detail(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = MyLL[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFS_Detail(n, visited);
        }
    }


    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFS_Detail(v, visited);
    }
    public static void main(String args[])
    {
        Main Mygraph = new Main(11);
        Mygraph.addEdge(1, 2);
        Mygraph.addEdge(1, 3);
        Mygraph.addEdge(2, 3);
        Mygraph.addEdge(2, 4);
        Mygraph.addEdge(2, 6);
        Mygraph.addEdge(3, 4);
        Mygraph.addEdge(3, 8);
        Mygraph.addEdge(4, 5);
        Mygraph.addEdge(5, 6);
        Mygraph.addEdge(5, 7);
        Mygraph.addEdge(5, 3);
        Mygraph.addEdge(6, 2);
        Mygraph.addEdge(6, 7);
        Mygraph.addEdge(6, 8);
        Mygraph.addEdge(6, 9);
        Mygraph.addEdge(7, 4);
        Mygraph.addEdge(7, 8);
        Mygraph.addEdge(8, 9);
        Mygraph.addEdge(8, 10);
        Mygraph.addEdge(9, 10);
        for(int i=0; i<=6;i++) {
            System.out.println("\n Path with starting from vertex " +i );
            Mygraph.DFS(i);
        }

        Graph1<Integer> g = new Graph1<Integer>();
        g.addEdge(1, 2, true);
        g.addEdge(2, 3,true);
        g.addEdge(3, 4,true);
        g.addEdge(3, 9,true);
        g.addEdge(4, 5,true);
        g.addEdge(4, 7,true);
        g.addEdge(9, 10,true);
        g.addEdge(9, 12,true);
        g.addEdge(10, 11,true);
        g.addEdge(12, 13,true);
        g.addEdge(13, 14,true);
        g.addEdge(5, 6,true);
        g.addEdge(7, 8,true);
        g.addEdge(6, 14,true);
        g.addEdge(8, 14,true);
        g.addEdge(11, 14,true);
        g.addEdge(14, 15,true);
        g.addEdge(14, 3,true);


    }
}