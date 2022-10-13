package Graphs;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Queue;

public class Graph {

    // Fields
    private int[][] g; // Use Adjacency Matrix; v^2
    private int v; // Number of verts
    private int e; // Number of edges

    // Constructor
    public Graph(int v) {
        g = new int[v][v];
        this.v = v;
        e = 0;
    }

    // Methods
    public int V() {
        return v;
    }

    public int E() {
        return e;
    }

    public void addEdge(int v1, int v2) {
        g[v1][v2] = 1;
        g[v2][v1] = 1; // since dealing with undirected graphs, thus being symmetric
        e++;

    }

    public boolean isAdjacent(int v1, int v2) {
        return g[v1][v2] == 1;
    }

    public boolean isConnected(int v1, int v2) {
        int[] bfs = BFStoArray(v1);
        for (int i = 0; i < bfs.length; i++) {
            if (bfs[i] == v2)
                return true;
        }
        return false;
    }

    public int[] adj(int v) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < this.v; i++) {
            if (g[v][i] == 1)
                al.add(i);
        }
        int[] ret = new int[al.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = al.get(i);

        return ret;
    }

    public String adjString(int v) {
        int[] a = adj(v);
        String ret = "Verts adjacent to " + v + ": ";
        for (int i = 0; i < a.length; i++)
            ret += a[i] + " ";

        return ret;
    }

    /* Helper function that can be used later by isConnected as well */

    private int[] BFStoArray(int v) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        boolean[] visited = new boolean[this.v];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(v);
        visited[v] = true;
        int visit;

        while (!q.isEmpty()) {
            visit = q.remove();
            al.add(visit);
            for (int i = 0; i < this.v; i++) {
                if (isAdjacent(visit, i) && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        int[] ret = new int[al.size()];

        for (int i = 0; i < ret.length; i++)

            ret[i] = al.get(i);

        return ret;

    }

    public String BFS(int v) {

        String ret = "BFS for Vert #" + v + ": ";

        int[] bfs = BFStoArray(v);

        for (int i = 0; i < bfs.length; i++)

            ret += bfs[i] + " ";

        return ret;

    }

    /* Initiator (wrapper) method for recursive call */

    public String DFS(int v) {

        boolean[] visited = new boolean[this.v];

        String ret = DFS(v, visited, "DFS for Vert #" + v + ": ");

        return ret;

    }

    /* Workhorse (helper) method for recursive call */

    private String DFS(int v, boolean[] visited, String str) {

        str += v + " ";

        visited[v] = true;

        for (int i = 0; i < this.v; i++) {

            if (isAdjacent(v, i) && !visited[i])

                str = DFS(i, visited, str);

        }

        return str;

    }

    /* Do following 2 methods for 5 EC points */
    /* This is for adding weighted edges */
    public void addWeightedEdge(int v1, int v2, int weight) {
        // TODO: remove when complete
    }

    public String shortestPath(int v1, int v2) {
        // TODO: remove when complete
        
        return null;    // Placeholder to prevent Java err; remove when complete.
    }

}