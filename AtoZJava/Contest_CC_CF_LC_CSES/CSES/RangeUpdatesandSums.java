package Contest_CC_CF_LC_CSES.CSES;

import java.io.PrintWriter;

public class RangeUpdatesandSums {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        long q = fr.nextLong();

        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextLong();
        }
        SegmentTree2 st = new SegmentTree2(arr);
        for(int i=0; i<q; i++){
            int type = fr.nextInt();
            if(type == 1){
                int a = fr.nextInt();
                int b = fr.nextInt();
                long x = fr.nextLong();
                st.update1(a, b, x);
            } else if(type == 2){
                int a = fr.nextInt();
                int b = fr.nextInt();
                long x = fr.nextLong();
                st.update2(a, b, x);
            } else {
                int a = fr.nextInt();
                int b = fr.nextInt();
                out.println(st.query(a, b));
            }
        }
        out.close();
    }
}
class SegmentTree2 {
    private long[] tree;
    private long[] lazy;
    private int n;

    public SegmentTree2(long[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
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

    public void update1(int l, int r, long x) {
        update1(0, 0, n - 1, l, r, x);
    }

    private void update1(int idx, int start, int end, int qsi, int qei, long val) {
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx]+lazy[idx];
            if(start!=end){
                lazy[2*idx+1] = lazy[idx];
                lazy[2*idx+2] = lazy[idx];
            }
            lazy[idx]=0;
        }

        // 3 cases
        if(qei < start || end < qsi){
            return;
        }

        if(start <= qsi && qei <= end){
            tree[idx] += val+tree[idx];
            if(start != end){
                lazy[2*idx+1] += val+lazy[idx];
                lazy[2*idx+2] += val+lazy[idx];
            }
            return; // pls don't miss it
        }
        int mid = (start+end)/2;
        update1(2*idx+1, start, mid, qsi, qei, val);
        update1(2*idx+2, mid+1, end, qsi, qei, val);

        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }
    public void update2(int l, int r, long x) {
        update2(0, 0, n - 1, l, r, x);
    }

    private void update2(int idx, int start, int end, int qsi, int qei, long val) {
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx];
            if(start!=end){
                lazy[2*idx+1] = lazy[idx];
                lazy[2*idx+2] = lazy[idx];
            }
            lazy[idx]=0;
        }

        // 3 cases
        if(qei < start || end < qsi){
            return;
        }

        if(start <= qsi && qei <= end){
            tree[idx] += val;
            if(start != end){
                lazy[2*idx+1] += val;
                lazy[2*idx+2] += val;
            }
            return;
        }
        int mid = (start+end)/2;
        update2(2*idx+1, start, mid, qsi, qei, val);
        update2(2*idx+2, mid+1, end, qsi, qei, val);

        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
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
