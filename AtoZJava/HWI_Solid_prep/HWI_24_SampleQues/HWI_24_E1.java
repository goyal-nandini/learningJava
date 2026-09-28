package HWI_Solid_prep.HWI_24_SampleQues;
// T2 Q1
/*Array Range Assignment with Arithmetic Progression
You have an array A of integers with n elements. There are q queries to process and each query consists of
four integers: l, r, x, and y. For the subarray of A ranging from index l to r, you need to
assign a sequence of integers for each subsequent element. The sequence should start from x and
increase by y. This means:

• A[l] will be assigned the value of x.
• A[l+1] will be assigned the value of x + y.
• A[l+2] will be assigned the value of x + 2*y.
• Continuing this pattern, A[l+i] will be assigned the value of x + i*y, where i ranges from 0 to (r - l).
Find the sum of all integers in A after processing all queries.
Since answer can be large, return it modulo 10^9 +7.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HWI_24_E1 {
    public static void main(String[] args) {
        FastReader3 fr = new FastReader3();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextLong();
        int q = fr.nextInt();
        long[][] queries = new long[q][4];
        for(int i=0; i<q; i++){
            queries[i][0] = fr.nextInt();
            queries[i][1] = fr.nextInt();
            queries[i][2] = fr.nextInt();
            queries[i][3] = fr.nextInt();
        }

        SegmentTree3 st = new SegmentTree3(arr);
        for (long[] query : queries) {
            long l = query[0];
            long r = query[1];
            long x = query[2];
            long y = query[3];
            st.replace(l, r, x, y);
        }
        out.println(st.getTotalSum());
        out.close();
    }
}
class SegmentTree3 {
    private long[] tree;
    private long[] lazyConst;
    private long[] lazySlope;
    private boolean[] isLazy;
    private int n;

    public SegmentTree3(long[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        lazyConst = new long[4 * n];
        lazySlope = new long[4 * n];
        isLazy = new boolean[4 * n];
        buildTree(arr, 0, 0, n - 1); // arr, idx, start, end
    }

    private void buildTree(long[] arr, int idx, int start, int end) {
        if (start == end) {
            tree[idx] = arr[start];
        } else {
            int mid = (start + end) / 2;
            // left
            buildTree(arr, 2 * idx + 1, start, mid);
            // right
            buildTree(arr, 2 * idx + 2, mid + 1, end);
            // merge
            tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        }
    }

    public long query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private long query(int idx, int start, int end, int qsi, int qei) {
        // 3 cases

        // completely inside
        if (start >= qsi && end <= qei) {
            return tree[idx];
        }
        // completely outside
        else if (end < qsi || start > qei) {
            return 0;
        }
        // overlapping
        else {
            int mid = (start + end) / 2;

            long leftSum = query(2 * idx + 1, start, mid, qsi, qei);
            long rightSum = query(2 * idx + 2, mid + 1, end, qsi, qei);

            return leftSum + rightSum;
        }
    }

    public void replace(long l, long r, long x, long y) {
        replace(0, 0L, n - 1, (int)l, (int)r, x, y);
    }

    public long getTotalSum() {
        return tree[0];
    }

    public long getSum(long start, long end, long C, long S){
        // we want sum of range
        long len = end - start + 1;
        long sumIndices = (start + end) * len / 2; // mind-blowing formula!!
        return C * len + S * sumIndices;
    }

    private void replace(int idx, long start, long end, int qsi, int qei, long x, long y) {
        if(isLazy[idx]){
            tree[idx] = getSum(start, end, lazyConst[idx], lazySlope[idx]);// !!
            if(start!=end){
                lazyConst[2*idx+1] = lazyConst[idx];
                lazySlope[2*idx+1] = lazySlope[idx];
                isLazy[2*idx+1] = true;

                lazyConst[2*idx+2] = lazyConst[idx];
                lazySlope[2*idx+2] = lazySlope[idx];
                isLazy[2*idx+2] = true;
            }
            isLazy[idx] = false;
        }

        // 3 cases
        // outside
        if(qei < start || end < qsi){
            return;
        }
        // full overlap
        if(qsi <= start && end <= qei){
            long C = (x-qsi*y);
            long S = (y);
            tree[idx] = getSum(start, end, C, S);// !!
            if(start != end){
                lazyConst[2*idx+1] = C;
                lazySlope[2*idx+1] = S;
                isLazy[2*idx+1] = true;

                lazyConst[2*idx+2] = C;
                lazySlope[2*idx+2] = S;
                isLazy[2*idx+2] = true;
            }
            return; // pls don't miss it
        }
        // partial
        long mid = (start+end)/2;
        replace(2*idx+1, start, mid, qsi, qei, x, y);
        replace(2*idx+2, mid+1, end, qsi, qei, x, y);

        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }
}
class FastReader3{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader3(){
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
