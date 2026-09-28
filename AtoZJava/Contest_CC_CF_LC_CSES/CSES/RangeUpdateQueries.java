package Contest_CC_CF_LC_CSES.CSES;
// Fenwick Tree storing difference updates, point queries answered with prefix sums.

// AC :)
//tc: o((n+q)logn) sc: O(n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeUpdateQueries {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        long q = fr.nextLong();

        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextLong();
        }

//        FenwickTree bit = new FenwickTree(arr);
//        I passed arr into the constructor, but never actually use it to build anything.
//        That’s fine here, because the BIT is supposed to start empty (acting as a difference array). But it’s misleading — you could just pass n instead of arr, process queries on-the-fly to save memory and time
        FenwickTree bit = new FenwickTree(arr.length);
        for(int i=0; i<q; i++){
            int type = fr.nextInt();
            if (type == 1) {
                int a = fr.nextInt() - 1; // 0-based conversion
                int b = fr.nextInt() - 1;
                long u = fr.nextLong();
                bit.update(a, u);
                bit.update(b+1, -u);
            } else {
                int k = fr.nextInt() - 1; // 0-based conversion
                out.println(arr[k]+bit.prefixSum(k));
            }
        }
        // imp imp
        // Important: Close the PrintWriter to flush the output buffer
        out.close();
    }
}
class FenwickTree{
    long[] tree;
    int n;
    FenwickTree(int n){
        this.n = n;
        tree = new long[n+1];
    }

    // fenwick tree is now has 0 only in it -> act as a difference array

    // update the index idx with val
    void update(int idx, long val){
        int i = idx+1;
        while(i<=n){
            tree[i] += val;
            i += (i&-i);
        }
    }

    long prefixSum(int idx){
        long sum = 0;
        int i = idx+1;
        while(i>0){
            sum += tree[i];
            i -= (i&-i);
        }
        return sum;
    }
}
//class FastReader{
//    BufferedReader reader;
//    StringTokenizer tokenizer;
//
//    public FastReader(){
//        reader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    String next(){
//        while(tokenizer == null || !tokenizer.hasMoreElements()){
//            try{
//                String line = reader.readLine();
//                if(line == null) return null;
//                tokenizer = new StringTokenizer(line);
//            } catch (IOException e){
//                return null;
//            }
//        }
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt(){
//        return Integer.parseInt(next());
//    }
//    public Long nextLong(){
//        return Long.parseLong(next());
//    }
//}
