package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Prims_Algorithm_MST {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        int sum = spanningTree(V, edges);
        System.out.println("The sum of all the edge weights: " + sum);
    }
    public static int spanningTree(int V, int[][] edges) {
        // code here
        // Prim's Algorithm
        // tc: O(E*logE) sc: O(V+E)
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int[] visited = new int[V];
        pq.add(new int[]{0, 0, -1}); // wt, node, parent
        // beware don't mark any node visited!! only add to PQ

        int sum = 0;
        List<int[]> mst = new ArrayList<>(); // gets you the MST

        while(!pq.isEmpty()){
            int[] tuple = pq.poll();
            int node = tuple[1];
            int currWt = tuple[0];
            int parent = tuple[2];

            if(visited[node]==1) continue; // imp, Skip if already visited

            visited[node] = 1;
            sum += currWt;
            if(parent != -1){ // Don't add the first node's dummy edge
                mst.add(new int[]{parent, node});
            }

            for(int[] lists: adj.get(node)){
                int neighbour = lists[0];
                int wt = lists[1];
                if(visited[neighbour] != 1){
                    pq.add(new int[]{wt, neighbour, node});
                }
            }
        }
        System.out.println("MST is: ");
        for(int i=0; i<mst.size(); i++){
            System.out.print(Arrays.toString(mst.get(i)));
        }
        System.out.println();
        return sum;
    }
}
