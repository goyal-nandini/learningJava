package Trees.DPonTrees;
// TASK: say we have a adj list given/we can build it for a tree,
// we have process the subtree sizes for each node

// focus on recursive one, if u need itervative one for undirected adj list then have a look
// of how to extra use of parent array
//  parent nodes -> child nodes [directed, we build]
// if undirected tree input → track parent to skip parent edge
// if graph (cycles possible) → use visited[] instead

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RecursiveDFS {
    static int n = 7;
    static int[] a = {1, 2, 2, 4, 4, 1}; // parents of nodes 2..7

    // undirected adj (both directions) — works for both versions
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) {
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int child = i + 2;
            int parent = a[i];
            adj[parent].add(child);
            adj[child].add(parent);  // undirected
        }


        // --- Recursive ---
        int[] recSize = new int[n + 1];
        dfsRecursive(1, -1, recSize);
        System.out.print("Recursive:  ");
        for (int i = 1; i <= n; i++) System.out.print(recSize[i] + " ");
        System.out.println();

        // --- Iterative ---
        int[] iterSize = dfsIterative(1);
        System.out.print("Iterative:  ");
        for (int i = 1; i <= n; i++) System.out.print(iterSize[i] + " ");
        System.out.println();
    }

    // ✅ RECURSIVE — easy to read, use for reference
    static void dfsRecursive(int node, int parent, int[] size) {
        size[node] = 1;
        for (int child : adj[node]) {
            if (child == parent) continue;   // skip parent edge
            dfsRecursive(child, node, size);
            size[node] += size[child];       // post-order
        }
    }

    // ✅ ITERATIVE FLAVOR 2 — use in Java for large n
    static int[] dfsIterative(int root) {
        int[] size      = new int[n + 1];
        int[] parent    = new int[n + 1];
        boolean[] processed = new boolean[n + 1];

        Deque<Integer> st = new ArrayDeque<>();
        parent[root] = -1;
        st.push(root);

        while (!st.isEmpty()) {
            int node = st.peek();

            if (!processed[node]) {
                processed[node] = true;
                for (int child : adj[node]) {
                    if (child == parent[node]) continue;  // skip parent edge
                    parent[child] = node;
                    st.push(child);
                }
            } else {
                st.pop();
                size[node] = 1;
                for (int child : adj[node]) {
                    if (child == parent[node]) continue;  // skip parent edge
                    size[node] += size[child];            // post-order
                }
            }
        }
        return size;
    }
}
