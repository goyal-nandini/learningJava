package Contest_CC_CF_LC_CSES;
// AC :)
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class CF_GregandArray {
    public static void main(String[] args) {
        FastReader4 fr = new FastReader4();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextLong();

        long[][] operations = new long[m][3];
        for (int i = 0; i < m; i++) {
            long l = fr.nextLong();
            long r = fr.nextLong();
            long d = fr.nextLong();
            operations[i] = new long[]{l, r, d};
        }

        int[][] queries = new int[k][2];
        for (int i = 0; i < k; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            queries[i] = new int[]{x, y};
        }
        long[] ans = solve(arr, operations, queries);
        for (int i = 0; i < ans.length; i++) {
            out.print(ans[i] + " ");
            if (i < ans.length - 1) out.print(" ");
        }
        out.println();
        out.flush();  // don't forget this
    }

    // operation kitni brr apply krna hai, operations prr difference array
    // m+2, ktini brr operation perform krna hai, new operations query banegi...!!
    // new operations
    private static long[] solve(long[] arr, long[][] operations, int[][] queries) {
        int m = operations.length;
        long[] diff1 = new long[m + 2];
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diff1[l] += 1;
            diff1[r + 1] -= 1;
        }

        for (int i = 1; i < diff1.length; i++) {
            diff1[i] = diff1[i] + diff1[i - 1];
        }

        // build new operations
        long[] new_diff1 = Arrays.copyOfRange(diff1, 1, m + 1);

        for (int j = 0; j < operations.length; j++) {
            long d = operations[j][2];
            long new_d = d * new_diff1[j];
            operations[j][2] = new_d;
        }


        int n = arr.length;
        long[] diff2 = new long[n + 2];
        for (long[] op : operations) {
            long l = op[0];
            long r = op[1];
            long d = op[2];
            diff2[(int)l] += d;
            diff2[(int)r + 1] -= d;
        }

        for (int i = 1; i < diff2.length; i++) {
            diff2[i] = diff2[i] + diff2[i - 1];
        }
        long[] new_diff2 = Arrays.copyOfRange(diff2, 1, n + 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += new_diff2[i];
        }

        return arr;
    }

//    private static int[] solve_1(long[] arr, int[][] operations, int[][] queries){
//        int[] diff = new int[arr.length+2];
//        for(int[] q: queries){
//            int x = q[0];
//            int y = q[1];
//            // have to apply operations from x to y
//            for(for i=x; i<=y; i++){
//                int l = operations[i][0];
//                int r = operations[i][1];
//                int d = operations[i][2];
//                //
//                for(int i=0; i<diff.length; i++){
//                    diff[l] += d;
//                    diff[r+1] -= d;
//                }
//            }
//        }
//        for(int i=1; i<diff.length; i++){
//            diff[i] = diff[i]+diff[i-1];
//        }
//        return Arrays.copyOfRange(diff, 1, arr.length+1);
//    }
    private static long[] solve_brute(long[] arr, int[][] operations, int[][] queries) {
        int n = arr.length;
        long[] diff = new long[n + 2];

        for (int[] q : queries) {
            int x = q[0];
            int y = q[1];
            // apply operations x to y on the diff array
            for (int i = x; i <= y; i++) {          // ✅ was: for(for i=x ...) — syntax error
                int l = operations[i-1][0];          // 1-indexed op → 0-indexed array
                int r = operations[i-1][1];
                int d = operations[i-1][2];
                diff[l] += d;                        // ✅ just update endpoints
                diff[r + 1] -= d;                    // ❌ you had a loop here — unnecessary
            }
        }

        // prefix sum
        for (int i = 1; i < diff.length; i++) {
            diff[i] = diff[i] + diff[i - 1];
        }

        long[] additions = Arrays.copyOfRange(diff, 1, n + 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] += additions[i];
        }
        return arr;
    }
}
class FastReader4 {
    StreamTokenizer st;
    public FastReader4() {
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
