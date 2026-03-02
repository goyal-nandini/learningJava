package Trees;
/*## 🧠 Kruskal's vs Prim's Algorithm

| Aspect                | Kruskal's                 | Prim's |
|---------------------- |---------------------------|-------------------------------|
| **Approach**          | Edge-based (greedy)       | Vertex-based (greedy) |
| **Data Structure**    | Disjoint Set (Union-Find) | Priority Queue (Min Heap) |
| **Best for**          | Sparse graphs (few edges) | Dense graphs (many edges) |
| **Time**              | O(E log E)                | O(E log V) |
| **Easier?**           | Easier with DSU!          | Slightly more complex |*/

import java.util.*;

public class Kruskal_algorithm_MST {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int sum = kruskalsMST(V, edges);
        System.out.println("The sum of all the edge weights: " + sum);

    }
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        // tc: O(ElogE+E*α(V))
        // sc: O(V)
        int sum = 0;
        int edgesAdded = 0;
        List<int[]> mst = new ArrayList<>();
        // 1. sort edges by weights, for greedy picking up of weights
        Arrays.sort(edges, (a, b) -> a[2]-b[2]);

        // 2. apply disjoint set, DSU prevents cycles by checking if nodes are already connected!
        DisjointSet set = new DisjointSet(V); // all nodes

        // 3. process each edges
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            // different component
            if(set.find(u) != set.find(v)) { // not from same group
                set.union(u, v); // merge them
                mst.add(new int[]{u, v});
                sum += w;
                edgesAdded++;

                // if somewhere we got, V-1 edges, then break from there!!
                if(edgesAdded == V-1) break;
            }
        }
        System.out.println("MST is: ");
        for(int i=0; i<mst.size(); i++){
            System.out.print(Arrays.toString(mst.get(i)));
        }
        System.out.println();
        return sum;


    }
    static class DisjointSet {
        int[] parent;
        int[] rank;

        private DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        private void union(int u, int v) {
            int root_u = find(u);
            int root_v = find(v);

            if (root_u == root_v) return;

            if (rank[root_u] < rank[root_v]) {
                parent[root_u] = root_v;
            } else if (rank[root_v] < rank[root_u]) {
                parent[root_v] = root_u;
            } else {
                parent[root_u] = root_v;
                rank[root_v]++;
            }
        }
    }


}
