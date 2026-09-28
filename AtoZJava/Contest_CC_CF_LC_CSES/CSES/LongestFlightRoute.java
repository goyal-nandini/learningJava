package Contest_CC_CF_LC_CSES.CSES;

/*lesson:
* don't panic u see 1e9 or 2e9 see what you are storing!
* don't put long everywhere as u see 1e9 or 1e5 but ALWAYS ask: what is the Value i am storing?!
* QUICK rule:
| Situation                   | Use    |
| --------------------------- | ------ |
| Counting nodes / indices    | `int`  |
| Large sums / multiplication | `long` |
| DP with big weights         | `long` |
*
* Constraints:
n ≤ 1e5
m ≤ 2e5
👉 These fit easily in int
int limit ≈ 2 × 10⁹
So no issue!
*
| Type   | Bits | Range     |
| ------ | ---- | --------- |
| `int`  | 32   | ±2 × 10⁹  |
| `long` | 64   | ±9 × 10¹⁸ |

* i learned most imp revised:
* Longest path in DAG
* Topological sort (Kahn)
* DP on graph [its storing the count of visited cities till node n]
* Path reconstruction

* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class LongestFlightRoute {
    public static void main(String[] args) {
        FastReader7 fr = new FastReader7();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int m = fr.nextInt();

        int[][] directEdges = new int[m][2];
        for(int i=0; i<m; i++){
            directEdges[i][0] = fr.nextInt();
            directEdges[i][1] = fr.nextInt();
        }

        // building adj list of this input
        ArrayList<Integer>[] adj = new ArrayList[n+1]; // 1-based
        for(int i=1; i<=n; i++){ // build adj from 1
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            int u = directEdges[i][0];
            int v = directEdges[i][1];

            adj[u].add(v); // directed edge only
        }

        // topological sort
        int[] indegree = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            for(int v: adj[i]){ // ATTENTION and be careful!
                indegree[v]++;
            }
        }
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] parent = new int[n+1]; // tells how to reach
        int[] dp = new int[n+1]; // tells how long
        Arrays.fill(dp, Integer.MIN_VALUE); // initialized with -inf, means not reachable from 1
        // dp[i] = 1; means There is a valid path from 1 → i with length 1
        dp[1] = 1; // can reach from city 1 to city 1, start node

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigh: adj[node]){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
                // we need longest path so u should have a check for reaching longest path only to reach neighbor
                // also check if the node is reachable from 1 or not? like we have to go from node 1 to node n so this
                // neigh is a route node so we have to make sure that the curr node [might be a neighor of other] is
                // reachable so far! -> neigh is just a neighbor — it becomes part of route only if dp improves
                if(dp[node]!=Integer.MIN_VALUE && dp[node]+1 > dp[neigh]){ // only best path should be stored, say
                    // dp[neigh] = 4 and now new path is having
                    // dp[node] = 1 so dp[neigh] = 2, so why update dp[neigh]? okay! that's why need condition,
                    // Only update if new path is longer than existing one
                    dp[neigh] = dp[node]+1;
                    parent[neigh] = node;
                }
            }
        }

        if(dp[n] == Integer.MIN_VALUE){
            out.println("IMPOSSIBLE");
            out.flush();   // 🔥 IMPORTANT PLSS be carefull!!
            return;
        }

        int maxCities = dp[n];
        List<Integer> route = new ArrayList<>();
        int curr = n;
        while(curr != 0){
            route.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(route);

        out.println(maxCities);
        for(int r: route) out.print(r + " ");

        out.flush();

    }
}
class FastReader7{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader7(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        while(tokenizer == null || !tokenizer.hasMoreElements()){
            try{
                String line = reader.readLine();
                if(line == null) return null;
                tokenizer = new StringTokenizer(line);
            } catch (IOException e){
                return null;
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }
    public Long nextLong(){
        return Long.parseLong(next());
    }
}
