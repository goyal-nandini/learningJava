package Contest_CC_CF_LC_CSES.CSES;

import java.io.*;
import java.util.*;

public class RangeUpdatesandSums_AC {
    static long[] tree, lazyAdd, lazySet;
    static int n;

    public static void main(String[] args) {
        FastReader2 fr = new FastReader2();
        PrintWriter out = new PrintWriter(System.out);

        n = fr.nextInt();
        int q = fr.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextLong();

        tree = new long[4 * n];
        lazyAdd = new long[4 * n];
        lazySet = new long[4 * n];
        java.util.Arrays.fill(lazySet, -1);

        build(arr, 0, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int type = fr.nextInt();
            int a = fr.nextInt() - 1; // 0-indexed
            int b = fr.nextInt() - 1;
            if (type == 1) {
                long x = fr.nextLong();
                updateAdd(0, 0, n - 1, a, b, x);
            } else if (type == 2) {
                long x = fr.nextLong();
                updateSet(0, 0, n - 1, a, b, x);
            } else {
                sb.append(query(0, 0, n - 1, a, b)).append('\n');
            }
        }
        out.print(sb);
        out.close();
    }

    static void build(long[] arr, int idx, int start, int end) {
        if (start == end) { tree[idx] = arr[start]; return; }
        int mid = (start + end) / 2;
        build(arr, 2*idx+1, start, mid);
        build(arr, 2*idx+2, mid+1, end);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    static void pushDown(int idx, int start, int end) {
        int mid = (start + end) / 2;
        int left = 2*idx+1, right = 2*idx+2;
        int lenL = mid - start + 1, lenR = end - mid;

        if (lazySet[idx] != -1) {
            tree[left] = lazySet[idx] * lenL;
            lazySet[left] = lazySet[idx];
            lazyAdd[left] = 0;

            tree[right] = lazySet[idx] * lenR;
            lazySet[right] = lazySet[idx];
            lazyAdd[right] = 0;

            lazySet[idx] = -1;
        }
        if (lazyAdd[idx] != 0) {
            tree[left] += lazyAdd[idx] * lenL;
            lazyAdd[left] += lazyAdd[idx];

            tree[right] += lazyAdd[idx] * lenR;
            lazyAdd[right] += lazyAdd[idx];

            lazyAdd[idx] = 0;
        }
    }

    static void updateAdd(int idx, int start, int end, int l, int r, long val) {
        // outside
        if (r < start || end < l) return;
        // inside
        if (l <= start && end <= r) {
            tree[idx] += val * (end - start + 1);
            lazyAdd[idx] += val;
            return;
        }
        pushDown(idx, start, end);

        // partially inside
        int mid = (start + end) / 2;
        updateAdd(2*idx+1, start, mid, l, r, val);
        updateAdd(2*idx+2, mid+1, end, l, r, val);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    static void updateSet(int idx, int start, int end, int l, int r, long val) {
        if (r < start || end < l) return;
        if (l <= start && end <= r) {
            tree[idx] = val * (end - start + 1);
            lazySet[idx] = val;
            lazyAdd[idx] = 0;
            return;
        }
        pushDown(idx, start, end);
        int mid = (start + end) / 2;
        updateSet(2*idx+1, start, mid, l, r, val);
        updateSet(2*idx+2, mid+1, end, l, r, val);
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    static long query(int idx, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[idx];
        pushDown(idx, start, end);
        int mid = (start + end) / 2;
        return query(2*idx+1, start, mid, l, r) + query(2*idx+2, mid+1, end, l, r);
    }
}
class FastReader2 {
    StreamTokenizer st;
    public FastReader2() {
        st = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
    }
    int nextInt() {
        try {
            st.nextToken();
        } catch (IOException e) {}
        return (int) st.nval;
    }
    long nextLong() {
        try {
            st.nextToken();
        } catch (IOException e) {} return (long) st.nval;
    }
}
//class FastReader {
//
//    BufferedReader reader;
//    StringTokenizer tokenizer;
//    public FastReader() { reader = new BufferedReader(new InputStreamReader(System.in)); }
//    String next() {
//        while (tokenizer == null || !tokenizer.hasMoreElements()) {
//            try { tokenizer = new StringTokenizer(reader.readLine()); }
//            catch (IOException e) { return null; }
//        }
//        return tokenizer.nextToken();
//    }
//    int nextInt() { return Integer.parseInt(next()); }
//    long nextLong() { return Long.parseLong(next()); }
//}
