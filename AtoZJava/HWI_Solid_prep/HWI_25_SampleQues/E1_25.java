//package HWI_Solid_prep.HWI_25;
//
//import java.io.*;
//import java.util.*;
//
//public class E1_25 {
//    static final long MOD = 1_000_000_007L;
//    static final long INV2 = (MOD + 1) / 2; // modular inverse of 2
//
//    public static void main(String[] args) {
//        FastReader fr = new FastReader();
//        PrintWriter out = new PrintWriter(System.out);
//
//        int n = fr.nextInt();
//        long[] arr = new long[n];
//        for (int i = 0; i < n; i++) arr[i] = fr.nextLong();
//
//        int q = fr.nextInt();
//        SegmentTree st = new SegmentTree(arr);
//        long totalAns = 0;
//
//        for (int i = 0; i < q; i++) {
//            int type = fr.nextInt();
//            int l = fr.nextInt();
//            int r = fr.nextInt();
//            if (type == 1) {
//                // BUG FIX: get current A[l] from the segment tree, not stale arr[]
//                long val = st.pointQuery(l);
//                st.update(l, r, l, val);
//            } else {
//                long res = st.query(l, r);
//                totalAns = (totalAns + res) % MOD;
//            }
//        }
//        out.println(totalAns);
//        out.close();
//    }
//}
//
//class SegmentTree {
//    private final long[] tree;
//    private final long[] lazyL;   // -1 means no pending lazy
//    private final long[] lazyVal;
//    private final int n;
//
//    SegmentTree(long[] arr) {
//        n = arr.length;
//        tree = new long[4 * n];
//        lazyL = new long[4 * n];
//        lazyVal = new long[4 * n];
//        Arrays.fill(lazyL, -1);
//        buildTree(arr, 0, 0, n - 1);
//    }
//
//    private void buildTree(long[] arr, int idx, int start, int end) {
//        if (start == end) {
//            tree[idx] = arr[start] % E1_HWI_25.MOD;
//            return;
//        }
//        int mid = (start + end) / 2;
//        buildTree(arr, 2 * idx + 1, start, mid);
//        buildTree(arr, 2 * idx + 2, mid + 1, end);
//        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % E1_HWI_25.MOD;
//    }
//
//    /**
//     * BUG FIX: Correct arithmetic series sum.
//     * Sum of (i - l + 1) * val for i in [start, end]
//     * = val * sum of k for k = (start-l+1) to (end-l+1)
//     * = val * len * (startOffset + endOffset) / 2
//     */
//    private long rangeSum(int start, int end, long l, long val) {
//        long MOD = E1_HWI_25.MOD;
//        long INV2 = E1_HWI_25.INV2;
//        long len = (end - start + 1) % MOD;
//        long startOffset = (start - l + 1) % MOD;
//        long endOffset = (end - l + 1) % MOD;
//        // sum = val * len * (startOffset + endOffset) / 2
//        return val % MOD * len % MOD * ((startOffset + endOffset) % MOD) % MOD * INV2 % MOD;
//    }
//
//    /**
//     * BUG FIX: Push down replace-lazy to children.
//     * Replace lazy is (l, val): element i = (i - l + 1) * val.
//     * This overwrites any previous lazy on children.
//     */
//    private void pushDown(int idx, int start, int end) {
//        if (lazyL[idx] == -1) return;
//        int mid = (start + end) / 2;
//        // Left child [start, mid]
//        tree[2 * idx + 1] = rangeSum(start, mid, lazyL[idx], lazyVal[idx]);
//        lazyL[2 * idx + 1] = lazyL[idx];
//        lazyVal[2 * idx + 1] = lazyVal[idx];
//        // Right child [mid+1, end]
//        tree[2 * idx + 2] = rangeSum(mid + 1, end, lazyL[idx], lazyVal[idx]);
//        lazyL[2 * idx + 2] = lazyL[idx];
//        lazyVal[2 * idx + 2] = lazyVal[idx];
//        // Clear
//        lazyL[idx] = -1;
//    }
//
//    // Point query: returns current A[pos] (needed to get A[l] for type 1 queries)
//    public long pointQuery(int pos) {
//        return pointQuery(0, 0, n - 1, pos);
//    }
//
//    private long pointQuery(int idx, int start, int end, int pos) {
//        if (start == end) return tree[idx];
//        pushDown(idx, start, end);
//        int mid = (start + end) / 2;
//        if (pos <= mid) return pointQuery(2 * idx + 1, start, mid, pos);
//        else return pointQuery(2 * idx + 2, mid + 1, end, pos);
//    }
//
//    public long query(int l, int r) {
//        return query(0, 0, n - 1, l, r);
//    }
//
//    private long query(int idx, int start, int end, int qsi, int qei) {
//        if (end < qsi || qei < start) return 0;
//        if (qsi <= start && end <= qei) return tree[idx];
//        pushDown(idx, start, end);
//        int mid = (start + end) / 2;
//        return (query(2 * idx + 1, start, mid, qsi, qei)
//                + query(2 * idx + 2, mid + 1, end, qsi, qei)) % E1_HWI_25.MOD;
//    }
//
//    public void update(int l, int r, long origL, long val) {
//        update(0, 0, n - 1, l, r, origL, val);
//    }
//
//    private void update(int idx, int start, int end, int qsi, int qei, long l, long val) {
//        if (end < qsi || qei < start) return;
//        if (qsi <= start && end <= qei) {
//            // BUG FIX: correct sum using actual offset from l, stored as replace-lazy
//            tree[idx] = rangeSum(start, end, l, val);
//            lazyL[idx] = l;
//            lazyVal[idx] = val;
//            return;
//        }
//        pushDown(idx, start, end);
//        int mid = (start + end) / 2;
//        update(2 * idx + 1, start, mid, qsi, qei, l, val);
//        update(2 * idx + 2, mid + 1, end, qsi, qei, l, val);
//        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % E1_HWI_25.MOD;
//    }
//}
//
//class FastReader {
//    BufferedReader reader;
//    StringTokenizer tokenizer;
//
//    public FastReader() {
//        reader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    String next() {
//        while (tokenizer == null || !tokenizer.hasMoreElements()) {
//            try { tokenizer = new StringTokenizer(reader.readLine()); }
//            catch (IOException e) { e.printStackTrace(); }
//        }
//        return tokenizer.nextToken();
//    }
//
//    int nextInt() { return Integer.parseInt(next()); }
//    long nextLong() { return Long.parseLong(next()); }
//}
