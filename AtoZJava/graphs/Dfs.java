package graphs;
/* Adj List, it use!!
       0
      / \
     1   2
     |   |
     3   4

 */
import java.util.*;
public class Dfs {
    public static void main(String[] args) {
        // Number of vertices
        int V = 5;

        // Adjacency list
        List<Integer>[] adj = new ArrayList[V]; // just pinned  b/c of this line only, rest logic is DONE
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2));
        adj[1].addAll(Arrays.asList(0, 3));
        adj[2].addAll(Arrays.asList(0, 4));
        adj[3].add(1);
        adj[4].add(2);

        // be mindful while doing these que, o/w with ups-downs in mindset will create unnecessary
        // doubts compilation!! (me)
        // 0-based graph given

        // tc: O(V + 2E) (if needed, refer bfs gfg code)
        // sc: O(3n) dfs list as o/p array and recursion stack space and visited array

        // recursion used!!
        List<Integer> dfs = new ArrayList<>();
        int[] visited = new int[V]; // int[] arrays are initialized to 0 by default in Java.
        int node = 0; // starting node, // Run DFS from node 0
        dfs(adj, dfs, visited, node);

        // Print traversal
        for (int x : dfs) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void dfs(List<Integer>[] adj,
                           List<Integer> dfs,
                           int[] visited, int node){
        visited[node] = 1;
        dfs.add(node);

        List<Integer> neighboursList = adj[node];
        int size = neighboursList.size();
        for(int i=0; i < size; i++){
            int neighbour = adj[node].get(i); // get that particular neighbour of that node
            if(visited[neighbour] != 1){ // check for visitedness for the same
                dfs(adj, dfs, visited, neighbour); // then go for its own neighbours
                // (that's the dfs, going to its depth)
            }

        }

        //⭐ else use enchanced for loop - much cleaner code!!
    }
}
