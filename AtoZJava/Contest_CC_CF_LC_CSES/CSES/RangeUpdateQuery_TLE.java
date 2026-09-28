package Contest_CC_CF_LC_CSES.CSES;

// TLE for test case 2 on CSES
// use of lazy propagation on segment tree.

/* The Key Insight for Point Query
Range Min → internal node stores MIN  (you need it for queries)
Range Sum → internal node stores SUM  (you need it for queries)

Point Query → internal node stores NOTHING useful
              you only care about LEAVES
              internal nodes are just a ROAD to reach the leaf */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RangeUpdateQuery_TLE {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int q = fr.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = fr.nextInt();
        }

        // initialise segment tree
        SegmentTree st = new SegmentTree(arr);

        // process queries on-the-fly to save memory and time
        for(int i=0; i<q; i++){
            int type = fr.nextInt();
            if (type == 1) {
                int a = fr.nextInt() - 1; // 0-based conversion
                int b = fr.nextInt() - 1;
                long u = fr.nextLong();
                st.update(a, b, u);
            } else {
                int k = fr.nextInt() - 1; // 0-based conversion
                out.println(st.query(k));
            }
        }
        // imp imp
        // Important: Close the PrintWriter to flush the output buffer
        out.close();
    }
}
class SegmentTree {
    // ATTENTION: long! values can reach 10^9 * 2*10^5 = 2*10^14
    private long[] tree;
    private long[] lazy;
    private int n;
    SegmentTree(int[] arr){
        n = arr.length;
        tree = new long[4*n];
        lazy = new long[4*n];

        buildTree(arr, 0, 0, n-1);
    }

    public void buildTree(int[] arr, int idx, int start, int end){
        if(start == end){
            tree[idx] = arr[start]; // leaf stores the actual value
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, 2*idx+1, start, mid);
        buildTree(arr, 2*idx+2, mid+1, end);
        tree[idx] = 0; // internal nodes stores nothing!!
    }

    /*Why your tree[idx] = 0 for internal nodes is okay:
In your buildTree, you set internal nodes to 0. That's fine! Because in a point query,
we only care about the values at the bottom. By using push as we travel down,
we ensure all the "lazy" additions we caught at higher levels eventually reach that leaf.*/

    public void update(int l, int r, long val){
        update(0, 0, n-1, l, r, val);
    }

    private void update(int idx, int start, int end, int qsi, int qei, long val){
        // apply any pending lazy to this node
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx];
            if(start != end){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx]=0;
        }

        // outside
        if(qei < start || end < qsi) {
            return;
        }

        // fully inside
        if(qsi <= start && end <= qei){
            tree[idx] += val;
            if(start != end){
                lazy[2*idx+1] += val;
                lazy[2*idx+2] += val;
            }
            return;
        }

        // partial - just recurse and no lazy application needed
        int mid = (start+end)/2;
        update(2*idx+1, start, mid, qsi, qei, val);
        update(2*idx+2, mid+1, end, qsi, qei, val);
        tree[idx] = 0;
    }

    // point query
    public long query(int k){
        return query(0, 0, n-1, k);
    }
    private long query(int idx, int start, int end, int k){
        // apply any pending lazy to this node
        if(lazy[idx]!=0){
            tree[idx] += lazy[idx];
            if(start != end){
                lazy[2*idx+1] += lazy[idx];
                lazy[2*idx+2] += lazy[idx];
            }
            lazy[idx]=0;
        }

        if(start == end){
            return tree[idx]; // we reached the index k
        }
        int mid = (start+end)/2;
        if(k<=mid){
            // go left
            return query(2*idx+1, start, mid, k);
        } else {
            // go right
            return query(2*idx+2, mid+1, end, k);
        }
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
