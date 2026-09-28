package extras_OA.ClaudeMockTest_realQueBased.MT1;

import java.io.*;
import java.util.*;

public class AtCoderKnapsack1 {
    public static void main(String[] args) {
        FastReader51 fr = new FastReader51();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = fr.nextInt();
        int W = fr.nextInt();

        int[] w = new int[N];
        long[] v = new long[N];

        for(int i=0; i<N; i++){
            w[i] = fr.nextInt();
            v[i] = fr.nextLong();
        }

        long[][] dp = new long[N][W+1];
        for(long[] row: dp){
            Arrays.fill(row, -1);
        }

//        long ans = solve(0, W, v, w, dp);
        long ans = solve(v, w, W);
        out.println(ans);
        out.flush();
    }
    // tabulation
    private static long solve(long[]v, int[] wt, int W){
        int n = v.length;

        long[][] dp = new long[n+1][W+1];

        for(int i=n-1; i>=0; i--){
            for(int w=0; w<=W; w++){
                long pick = 0;
                if(w>=wt[i]){
                    pick = v[i]+dp[i+1][w-wt[i]];
                }

                long not_pick = dp[i+1][w];

                dp[i][w] = Math.max(pick, not_pick);
            }
        }
        return dp[0][W];
    }

    // memo - submitted to AtCoder
    private static long solve(int idx, int sum, long[] v, int[] w, long[][] dp){
        if(idx >= w.length){
            return 0;
        }

        if(dp[idx][sum] != -1) return dp[idx][sum];

        long pick = 0;
        if(sum>=w[idx]) pick = v[idx]+solve(idx+1, sum-w[idx], v, w, dp);

        long not_pick = solve(idx+1, sum, v, w, dp);

        return dp[idx][sum] = Math.max(pick, not_pick);
    }
}
class FastReader51{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader51(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        while(tokenizer == null || !tokenizer.hasMoreElements()) {
            try{
                String line = reader.readLine();
                if(line == null) return null;
                tokenizer = new StringTokenizer(line);
            } catch(IOException e){
                return null;
            }
        }
        return tokenizer.nextToken();
    }
    int nextInt(){
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }
    double nextDouble(){
        return Double.parseDouble(next());
    }
    String nextLine(){
        try{
            return reader.readLine();
        } catch(IOException e){
            return null;
        }
    }
}

