package Contest_CC_CF_LC_CSES.CSES;

import java.io.*;
import java.util.*;

public class TreeMatching {
    public static void main(String[] args) {
        FastReader3 fr = new FastReader3();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();

        int[][] edges = new int[n-1][2];
        for(int i=0; i<n-1; i++){
            edges[i][0] = fr.nextInt();
            edges[i][1] = fr.nextInt();
        }

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj[u].add(v);
            adj[v].add(u); // undirected adj, need parent tracking
        }
        int[] visited = new int[n+1]; // hey mann!! this is more of graph thing!!, can make it without this extra O(n)
        // space, this visited[] seems an overkill for trees
        int[][] dp = new int[n+1][2];
//        → You only need dp[n+1][2] because each node has two states:
//        dp[node][0]: max matching without using edge to parent
//        dp[node][1]: max matching using edge to parent
        int ans = solve(adj);
        out.println(ans);
        out.flush();
    }
    private static int solve(ArrayList<Integer>[] adj){
        // have to switch to iterative method
        int n = adj.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] processed = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);
        int[][] dp = new int[n+1][2];
        st.push(1);
        while(!st.isEmpty()){
            int node = st.peek();
            if(processed[node]!=1){
                processed[node] = 1;
                for(int child: adj[node]){
                    if(child == parent[node]) continue;
                    parent[child] = node;
                    st.push(child);
                }
            } else {
                st.pop();
                for(int child: adj[node]){
                    if(child == parent[node]) continue;
                    // do the actual work here now:
                    dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                }

                for(int child: adj[node]){
                    if(child == parent[node]) continue;
                    dp[node][1] = Math.max(dp[node][1], dp[node][0]
                    - Math.max(dp[child][0], dp[child][1]) + dp[child][0] + 1);
                }
            }
        }
        return Math.max(dp[1][0], dp[1][1]);


    }
    private static int solve__(int root, int parent, ArrayList<Integer>[] adj, int[][] dp){
        // build dp[root][0] fully
        for(int child: adj[root]){
            if(child == parent) continue; // skip parent edge
            solve__(child, root, adj, dp);
            dp[root][0] += Math.max(dp[child][0], dp[child][1]); // need += as = will overwrite in every iteration

//            this here is not correct as dp[root][0] is not built fully and we are doing stuff on dp[root][1] so need
//            another loop for this dp[root][1]
//            dp[root][1] = dp[root][0] - Math.max(dp[child][0], dp[child][1]) + dp[child][0] + 1;
        }

        // now computing dp[root][1] using complete dp[root][0]
        for(int child: adj[root]){
            if(child == parent) continue;
            dp[root][1] = Math.max(dp[root][1], dp[root][0] -
                    Math.max(dp[child][0], dp[child][1]) +
                    dp[child][0] + 1);
        }
        return Math.max(dp[root][0], dp[root][1]);
    }

    private static int solve_(int root, int[] visited, ArrayList<Integer>[] adj, int[][] dp){

        // build dp[root][0] fully
        for(int child: adj[root]){
            if(visited[child]==1) continue; // skip, already visited node/parent
            solve_(child, visited, adj, dp);
            dp[root][0] += Math.max(dp[child][0], dp[child][1]); // need += as = will overwrite in every iteration

//            this here is not correct as dp[root][0] is not built fully and we are doing stuff on dp[root][1] so need
//            another loop for this dp[root][1]
//            dp[root][1] = dp[root][0] - Math.max(dp[child][0], dp[child][1]) + dp[child][0] + 1;
        }

        // now computing dp[root][1] using complete dp[root][0]
        for(int child: adj[root]){
            dp[root][1] = dp[root][0] -
                    Math.max(dp[child][0], dp[child][1]) +
                    dp[child][0] + 1;
        }
        return Math.max(dp[root][0], dp[root][1]);
    }
}

class FastReader3 {
    StreamTokenizer st;
    public FastReader3() {
        st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
    }
    int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {}
        return (int) st.nval;
    }
    long nextLong() {
        try {
            st.nextToken();
        } catch (IOException e) {} return (long) st.nval;
    }
}
