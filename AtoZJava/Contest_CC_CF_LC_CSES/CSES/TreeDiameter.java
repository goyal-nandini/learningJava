package Contest_CC_CF_LC_CSES.CSES;

// TODO:

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class TreeDiameter {
    public static void main(String[] args) {
        FastReader5 fr = new FastReader5();
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
        int ans = solve(1, adj);
        out.println(ans);
        out.flush();
    }

    private static int solve(int root, ArrayList<Integer>[] adj){
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

                }
            }
        }
        return -1;
    }

}
class FastReader5 {
    StreamTokenizer st;
    public FastReader5() {
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


