package graphs;
// kaam aagya na kia hua kaam first time use hua LC 547 first official striver sheet problem, abhi
// aage aage dekho use hoga too ALL thE bEst
/*
       0
      / \
     1   2
    /     \
   3       4
*/
import java.util.*;
public class bfs_dfs_onAdjMat {
    public static void main(String[] args) {
        int V = 5;
        int[][] adj = new int[V][V];

        // undirected edges
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);

        System.out.print("BFS: ");
        bfs(adj, 0);
        System.out.println();
        System.out.print("DFS: ");
        dfs(adj, new boolean[V], 0);
    }

    // helper to add undirected edge
    static void addEdge(int[][] adj, int u, int v) {

        adj[u][v] = 1;
        adj[v][u] = 1; // want directed edge, no reverse edge!! be carefull
        // acc to que only
    }

    public static void bfs(int[][] adj, int start) {

        int V = adj.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(node + " ");

            // scan row
            for (int v = 0; v < V; v++) {

                if (adj[node][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    static void dfs(int[][] adj, boolean[] visited, int node) {

        visited[node] = true;
        System.out.print(node + " ");

        int V = adj.length;

        // scan row
        for (int v = 0; v < V; v++) {

            if (adj[node][v] == 1 && !visited[v]) {
                dfs(adj, visited, v);
            }
        }
    }
}
