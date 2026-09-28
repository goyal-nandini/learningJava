//package HWI_Solid_prep.HWI_25;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//public class E1 {
//    static final long MOD = 1000000007;
//
//    public static void main(String[] args) {
//        FastReader fr = new FastReader();
//        PrintWriter out = new PrintWriter(System.out);
//
//        int n = fr.nextInt();  // Changed to int since n <= 10^5
//        int q = fr.nextInt();  // Changed to int
//
//        long[] arr = new long[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = fr.nextLong();
//        }
//
//        SegmentTree st = new SegmentTree(arr);
//        long totalAns = 0;
//
//        for(int i = 0; i < q; i++){
//            int type = fr.nextInt();
//            int l = fr.nextInt();
//            int r = fr.nextInt();
//
//            if (type == 1) {
//                // Note: We need to get the current value at arr[l]
//                // But arr[] in main might be outdated. Better approach:
//                // st.update(l, r, st.query(l, l)); // Get current value at l from segment tree
//                // But that would cause query during update. Alternative:
//                // Store base value differently or pass the index
//                st.update(l, r, l); // Pass the index, not the value
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
//    private long[] tree;
//    private long[] lazy;
//    private boolean[] lazyFlag;
//    private int n;
//    private static final long MOD = 1000000007;
//
//    SegmentTree(long[] arr) {
//        n = arr.length;
//        tree = new long[4 * n];
//        lazy = new long[4 * n];
//        lazyFlag = new boolean[4 * n];
//        buildTree(arr, 0, 0, n - 1);
//    }
//
//    private void buildTree(long[] arr, int idx, int start, int end) {
//        if (start == end) {
//            tree[idx] = arr[start] % MOD;
//            return;
//        }
//        int mid = (start + end) / 2;
//        buildTree(arr, 2 * idx + 1, start, mid);
//        buildTree(arr, 2 * idx + 2, mid + 1, end);
//        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % MOD;
//    }
//
//    private void pushDown(int idx, int start, int end) {
//        if (lazyFlag[idx]) {
//            int len = end - start + 1;
//            long baseVal = lazy[idx] % MOD;
//
//            // Calculate sum of (i-start+1)*baseVal for i from start to end
//            // Formula: baseVal * (len * (len+1) / 2)
//            long lenLong = len;
//            long sum = (baseVal * ((lenLong * (lenLong + 1) / 2) % MOD)) % MOD;
//            tree[idx] = sum;
//
//            if (start != end) {
//                // Pass the same base value to children
//                lazy[2 * idx + 1] = baseVal;
//                lazy[2 * idx + 2] = baseVal;
//                lazyFlag[2 * idx + 1] = true;
//                lazyFlag[2 * idx + 2] = true;
//            }
//
//            lazy[idx] = 0;
//            lazyFlag[idx] = false;
//        }
//    }
//
//    public long query(int l, int r) {
//        return query(0, 0, n - 1, l, r);
//    }
//
//    private long query(int idx, int start, int end, int ql, int qr) {
//        pushDown(idx, start, end);
//
//        if (qr < start || end < ql) {
//            return 0;
//        }
//
//        if (ql <= start && end <= qr) {
//            return tree[idx];
//        }
//
//        int mid = (start + end) / 2;
//        long left = query(2 * idx + 1, start, mid, ql, qr);
//        long right = query(2 * idx + 2, mid + 1, end, ql, qr);
//        return (left + right) % MOD;
//    }
//
//    public void update(int l, int r, int baseIndex) {
//        // First, get the current value at baseIndex
//        long baseVal = query(baseIndex, baseIndex);
//        update(0, 0, n - 1, l, r, baseVal);
//    }
//
//    private void update(int idx, int start, int end, int ql, int qr, long baseVal) {
//        pushDown(idx, start, end);
//
//        if (qr < start || end < ql) {
//            return;
//        }
//
//        if (ql <= start && end <= qr) {
//            lazy[idx] = baseVal % MOD;
//            lazyFlag[idx] = true;
//            pushDown(idx, start, end); // Apply immediately
//            return;
//        }
//
//        int mid = (start + end) / 2;
//        update(2 * idx + 1, start, mid, ql, qr, baseVal);
//        update(2 * idx + 2, mid + 1, end, ql, qr, baseVal);
//
//        tree[idx] = (tree[2 * idx + 1] + tree[2 * idx + 2]) % MOD;
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
//            try {
//                tokenizer = new StringTokenizer(reader.readLine());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return tokenizer.nextToken();
//    }
//
//    int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    long nextLong() {
//        return Long.parseLong(next());
//    }
//}
