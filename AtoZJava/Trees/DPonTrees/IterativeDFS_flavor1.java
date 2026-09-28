package Trees.DPonTrees;

//Simple Traversal (just visit nodes)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class IterativeDFS_flavor1 {
    public static void main(String[] args) {
        int n = 7; // no of nodes
        // for each node we have given its parent 1-based, starting from node 2, node 1 is the root
// child nodes     2, 3, 4, 5, 6, 7
        int[] a = {1, 2, 2, 4, 4, 1}; // parent of each node

        // building adj list:
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            adj[a[i]].add(i+2); // parent nodes -> child nodes [directed]
        }
        // note: Your adj is built directed (parent → child only). A child has no way to reach its parent through
        // adj. So processed[] alone is enough to avoid revisiting — visited[] is doing nothing extra.

        System.out.println("simple node printing of the tree: ");
        dfs(1, adj);
    }
    static void dfs(int root, ArrayList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(root);
        visited[root] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");  // process here

            for (int child : adj[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    stack.push(child);
                }
            }
        }
    }
}
