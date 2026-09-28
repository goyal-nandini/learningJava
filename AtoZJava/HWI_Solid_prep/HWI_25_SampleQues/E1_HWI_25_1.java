//package HWI_Solid_prep.HWI_25;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//// segment tree with lazy propagation, update and query both over a range, so laziness is IMP here!
//public class E1_HWI_25 {
//    static final long MOD = 1000000007;
//    public static void main(String[] args) {
//        FastReader1 fr = new FastReader1();
//        PrintWriter out = new PrintWriter(System.out);
//
//        long n = fr.nextLong();
//
//
//        long[] arr = new long[(int)n];
//        for(int i=0; i<n; i++){
//            arr[i] = fr.nextLong();
//        }
//        long q = fr.nextLong();
//        SegmentTree st = new SegmentTree(arr);
//        long totalAns = 0;
//        for(int i=0; i<q; i++){
//            int type = fr.nextInt();
//            int l = fr.nextInt();
//            int r = fr.nextInt();
//            if (type == 1) {
//                st.update(l, r, l);
//            }
////            Find the sum of answers to all type 2 queries. Since answer can be large, return it modulo 109+7.
//            else {
//                long res = st.query(l, r);
//                totalAns = (totalAns+res)%MOD;
//            }
//        }
//
//        System.out.println();
//        out.println(totalAns);
//        // imp imp
//        // Important: Close the PrintWriter to flush the output buffer
//        out.close();
//    }
//}
//class SegmentTree{
//    long[] tree;
//    long[] lazy;
//    boolean[] lazyFlag;
//    int n;
//    static final long MOD = 1000000007;
//
//    SegmentTree(long[] arr){
//        n = arr.length;
//        tree = new long[4*n];
//        lazy = new long[4*n];
//        lazyFlag = new boolean[4*n];
//
//        buildTree(arr, 0, 0, n-1);
//    }
//
//    private void buildTree(long[] arr, int idx, int start, int end){
//        if(start == end){
//            tree[idx] = arr[start]%MOD;
//            return;
//        }
//
//        int mid = (start+end)/2;
//        buildTree(arr, 2*idx+1, start, mid);
//        buildTree(arr, 2*idx+2, mid+1, end);
//
//        tree[idx] = (tree[2*idx+1] + tree[2*idx+2])%MOD;
//    }
//
//    private void pushDown(int idx, int start, int end){
//        if(lazyFlag[idx]){
//            int len = end-start+1;
//            // Formula: Sum of (i-start+1)*lazy[idx] for i from start to end
//            // = lazy[idx] * (len * (len+1) / 2)
//            long sum = (lazy[idx] % MOD) * (((long)len * (len+1)/2) % MOD) % MOD;
//            tree[idx] = sum;
//
//            if(start!=end){
//                lazy[2*idx+1] = lazy[idx];
//                lazy[2*idx+2] = lazy[idx];
//                lazyFlag[2*idx+1] = true;
//                lazyFlag[2*idx+2] = true;
//            }
//            lazy[idx] = 0;
//            lazyFlag[idx] = false;
//        }
//    }
//
////    - Calculate the sum of the elements in A from index l to index r.
//    public long query(int l, int r){
//        return query(0, 0, n-1, l, r);
//    }
//
//    private long query(int idx, int start, int end, int qsi, int qei){
//        pushDown(idx, start, end);
//
//        // outside
//        if(end < qsi || qei < start){
//            return 0;
//        }
//
//        // inside
//        if(qsi <= start && end <= qei){
//            return tree[idx];
//        }
//
//        // partial overlap
//        int mid = (start+end)/2;
//        long left = query(2*idx+1, start, mid, qsi, qei);
//        long right = query(2*idx+2, mid+1, end, qsi, qei);
//        return (left + right)%MOD;
//    }
//
////    - Replace A[i] with (i-l+1)*A[l] for each index i, where l <= i <= r.
//    // Note: we have to replace no increment!! MIND THIS CRIME NXT TIME!!
//    // hence have to tweak this method...
//    public void update(int l, int r, int baseIndex){
//        long baseVal = query(baseIndex, baseIndex);
//        update(0, 0, n-1, l, r, baseVal);
//    }
//    public void replace(int idx, int start, int end, long val, int l){
//        int len = end-start+1;
//        long sum = val % MOD * ((long)len * (len+1)/2 % MOD);
//        tree[idx] = sum;
//        if(start != end){
//            lazy[2*idx+1] = sum;
//            lazy[2*idx+2] = sum;
//        }
//    }
//    private void update (int idx, int start, int end, int qsi, int qei, long val){
////        pushDown(idx, start, end);
//
//        // outside
//        if(end < qsi || qei < start){
//            return;
//        }
//
//        // inside, updation time and lazily propagating to its child
//        if(qsi <= start && end <= qei){
//            lazy[idx] = val % MOD;
//            lazyFlag[idx] = true;
//            // not adding dear, just replace
////            tree[idx] += (idx-qsi+1)*arr[qei];
////            replace(idx, start, end, val, qsi);
//            pushDown(idx, start, end);
//            return;
//        }
//
//        // partial overlap
//        int mid = (start+end)/2;
//        update(2*idx+1, start, mid, qsi, qei, val);
//        update(2*idx+2, mid+1, end, qsi, qei, val);
//
//        tree[idx] = (tree[2*idx+1] + tree[2*idx+2]) % MOD;
//    }
//}
//class FastReader1{
//    BufferedReader reader;
//    StringTokenizer tokenizer;
//
//    public FastReader1() {
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
