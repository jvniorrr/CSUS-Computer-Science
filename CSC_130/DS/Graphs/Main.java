package Graphs;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        System.out.println("Number of Verts: " + g.V());
        System.out.println("Number of Edges: " + g.E());

        for (int i=0; i<g.V(); i++) {
            System.out.println(g.adjString(i));
        }

        System.out.println("1 and 5 are adjacent? " + g.isAdjacent(1, 5));
        System.out.println("1 and 3 are adjacent? " + g.isAdjacent(1, 3));

        System.out.println(g.BFS(1));
        System.out.println(g.DFS(1));

    }
}
