package Trees.DPonTrees;

// can stick with one stack use, just mentioned as i came across in subordinates problem.

import java.util.*;

public class IterativeDFS_twoStacks_flavor2 {
    public static void main(String[] args) {
        int n = 7;
        int[] a = {1, 2, 2, 4, 4, 1}; // parents of nodes 2..7

        // undirected adj
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int child = i + 2;
            int parent = a[i];
            adj[parent].add(child);
            adj[child].add(parent);  // both directions
        }

        int[] size = dfs(1, n, adj);
        System.out.println("size of subtree of each node: ");
        for (int i = 1; i <= n; i++) System.out.println("Node " + i + " → " + size[i]);
    }
    static int[] dfs(int root, int n, List<Integer>[] adj) {
        int[] size   = new int[n + 1];
        int[] parent = new int[n + 1];

        Deque<Integer> stack = new ArrayDeque<>();  // for traversal
        Deque<Integer> order = new ArrayDeque<>();  // stores post-order

        parent[root] = -1;
        stack.push(root);

        // phase 1: build post-order sequence
        while (!stack.isEmpty()) {
            int node = stack.pop();
            order.push(node);  // push to order stack
            for (int child : adj[node]) {
                if (child == parent[node]) continue;  // skip parent edge
                parent[child] = node;
                stack.push(child);
            }
        }

        // phase 2: process in post-order
        while (!order.isEmpty()) {
            int node = order.pop();
            size[node] = 1;
            for (int child : adj[node]) {
                if (child == parent[node]) continue;  // skip parent edge
                size[node] += size[child];
            }
        }

        return size;
    }

    private static void dfs_twoStacks_undirectedADJ(ArrayList<Integer>[] adj){
        // directed adj list
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> order = new ArrayDeque<>();
        int[] dp = new int[adj.length]; // can be any number of nodes
        stack.push(1);

        while(!stack.isEmpty()){
            int node = stack.pop();
            order.push(node);
            for(int child : adj[node]){
                stack.push(child);
            }
        }

        // post-order processing
        while(!order.isEmpty()){
            int node = order.pop();
            dp[node] = 1;
            for(int child : adj[node]){
                dp[node] += dp[child];
            }
        }
    }
}
