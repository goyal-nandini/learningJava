package HWI_Solid_prep.HWI_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E1_25_AC {
    static final long MOD = 1000000007;
    public static void main(String[] args) {
        FastReader1 fr = new FastReader1();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();

        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextLong();
        }
        long q = fr.nextLong();
        SegmentTree st = new SegmentTree(arr);
        long totalAns = 0;
        for(int i=0; i<q; i++){
            int type = fr.nextInt();
            int l = fr.nextInt();
            int r = fr.nextInt();
            if (type == 1) {
//                st.update(l, r, );
                // We need A[l] from the current state of the array
                long baseVal = st.query(l, l); // Get A[l], (me)can say this a point query, want val at index l
                st.update(l, r, baseVal, l);  // Pass both A[l] and l
            }
//            Find the sum of answers to all type 2 queries. Since answer can be large, return it modulo 109+7.
            else {
                long res = st.query(l, r);
                totalAns = (totalAns+res)%MOD;
            }
        }
        out.println(totalAns);
        // imp imp
        // Important: Close the PrintWriter to flush the output buffer
        out.close();
    }

}

class SegmentTree {
    long[] tree;
    long[] lazyVal;     // Stores the A[l] value
    long[] lazyL;       // Stores the 'l' from the query (1, l, r)
    boolean[] lazyFlag;
//    https://docs.google.com/document/d/1QD9VQssw85x5QT2Ytc3jF5CCLztOtndE-86KbiodrGY/edit?usp=sharing
    int n;
    static final long MOD = 1000000007;

    SegmentTree(long[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        lazyVal = new long[4 * n];
        lazyL = new long[4 * n];
        lazyFlag = new boolean[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }

    private void buildTree(long[] arr, int idx, int start, int end) {
        if (start == end) {
            tree[idx] = arr[start] % MOD;
            return;
        }
        int mid = (start + end) / 2;
        buildTree(arr, 2 * idx + 1, start, mid);
        buildTree(arr, 2 * idx + 2, mid + 1, end);
        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % MOD;
    }

    // Helper to get sum of indices [i...j] : (i+j)*(j-i+1)/2
    // Sn formula of AP used here, Sn = (n/2) (a+l) or (n/2) (2a + (n-1)d)
    private long getSumIndices(long i, long j) {
        long count = (j - i + 1);
        long sum = (i + j) * count / 2; // a = i [first term] and l = j [last term]
         // (10^5 + 10^5) * 10^5 / 2 = 10^10 (fits in long)
        return sum % MOD;
    }

    private void pushDown(int idx, int start, int end) {
        if (lazyFlag[idx]) {
            long aL = lazyVal[idx];
            long l = lazyL[idx];
            int mid = (start + end) / 2;

            // Update children
            apply(2 * idx + 1, start, mid, aL, l);
            apply(2 * idx + 2, mid + 1, end, aL, l);

            lazyFlag[idx] = false;
            lazyVal[idx] = 0;
            lazyL[idx] = 0;
        }
    }
    //            Air@52688
    private void apply(int idx, int start, int end, long aL, long l) {
        long numElements = (end - start + 1);
        long sumOfI = getSumIndices(start, end);
//        given: (i-l+1)*A[l] <- expand it and u'll get A[i] = (i*A[l]) - (l*A[l]) + (A[l]) -> A[i] = A[l]*i - A[l]*(l - 1)
//        a Segment Tree node doesn't store just one A[i]; it stores the Sum of a range [start, end].
//        Sum= \summation from i=start to end OF[A[l]*i - A[l]*(l - 1)]
//        Sum = aL * Sum(i) - aL * (l - 1) * count
        long term1 = (aL * sumOfI) % MOD;
        long term2 = (aL * (l - 1 + MOD) % MOD * numElements) % MOD;

        tree[idx] = (term1 - term2 + MOD) % MOD;
        lazyVal[idx] = aL;
        lazyL[idx] = l;
        lazyFlag[idx] = true;
    }

    public long query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private long query(int idx, int start, int end, int qsi, int qei) {
        if (qsi <= start && end <= qei) return tree[idx];
        if (end < qsi || qei < start) return 0;

        pushDown(idx, start, end);
        int mid = (start + end) / 2;
        return (query(2 * idx + 1, start, mid, qsi, qei) +
                query(2 * idx + 2, mid + 1, end, qsi, qei)) % MOD;
    }

    public void update(int qsi, int qei, long aL, int l) {
        update(0, 0, n - 1, qsi, qei, aL, l);
    }

    private void update(int idx, int start, int end, int qsi, int qei, long aL, int l) {
        if (qsi <= start && end <= qei) {
            apply(idx, start, end, aL, l);
            return;
        }
        if (end < qsi || qei < start) return;

        pushDown(idx, start, end);
        int mid = (start + end) / 2;
        update(2 * idx + 1, start, mid, qsi, qei, aL, l);
        update(2 * idx + 2, mid + 1, end, qsi, qei, aL, l);
        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % MOD;
    }
}
class FastReader1{
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastReader1() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try { tokenizer = new StringTokenizer(reader.readLine()); }
            catch (IOException e) { e.printStackTrace(); }
        }
        return tokenizer.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
}
