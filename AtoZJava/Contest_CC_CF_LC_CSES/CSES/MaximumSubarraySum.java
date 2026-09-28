package Contest_CC_CF_LC_CSES.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        FastReader6 fr = new FastReader6();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        long[] a = new long[(int)n];
        for(int i=0; i<n; i++) a[i] = fr.nextLong();
        long ans = solve(a);
        out.println(ans);
        out.flush();
    }

    static long solve(long[] a){
        long maxSum = Long.MIN_VALUE;
        long sum = 0L;
        for(int i=0; i<a.length; i++){
            sum += a[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0L;
        }
        return maxSum;
    }
}
class FastReader6{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader6(){
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
