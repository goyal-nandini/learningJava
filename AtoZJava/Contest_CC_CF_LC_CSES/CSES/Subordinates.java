package Contest_CC_CF_LC_CSES.CSES;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Subordinates {
    public static void main(String[] args) {
        FastReader1 fr = new FastReader1();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int[] a = new int[n-1];

        // total no of emp, storing emp 2 to n, emp 1 is the boss itself
        for(int i=0; i<n-1; i++){ // size of a is n-1
            a[i] = fr.nextInt();
        }

        // building adj list: boss with their all employees
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){ // 1-based so 1 to n, 0 is ignored
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){ // 0 to n-2 only as the size of arr is n-1
            adj.get(a[i]).add(i+2);
        }


        // DP array -> dp[i] size of subtree rooted at i [including itself]
        int[] dp = new int[n+1];

        // dfs traversal -> recursive approach -> TLE ON TC 12
//        dfs(1, adj, dp); // start from node 1, ceo

        // iterative DFS using stack
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> order = new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()){
            int node = stack.pop();
            order.push(node);
            for(int child : adj.get(node)){
                stack.push(child);
            }
        }

        // post-order processing
        while(!order.isEmpty()){
            int node = order.pop();
            dp[node] = 1;
            for(int child : adj.get(node)){
                dp[node] += dp[child];
            }
        }

        // output prep:
        for(int i=1; i<=n; i++){
            out.print(dp[i]-1 + " ");
        }
        // dp[i] includes itself also, so for the count of subordinates of boss i,
        // we need dp[i]-1.
        out.close();
    }
    private static void dfs(int boss, ArrayList<ArrayList<Integer>> adj, int[] dp){
        dp[boss] = 1; // every node contributes q to its subtree
        for(int emp: adj.get(boss)){
            dfs(emp, adj, dp); // first compute the emp's subtree size
            dp[boss] += dp[emp]; // add emp's subtree size to curr boss value
        }
    }
}
class FastReader1{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader1(){
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