package Contest_CC_CF_LC_CSES;
// AC use of difference array only :)
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class AtCoder_NotAllCovered {
    public static void main(String[] args) {
        FastReader5 fr = new FastReader5();
        PrintWriter out = new PrintWriter(System.out);

        long n = fr.nextLong();
        long m = fr.nextLong();

        int[][] turrets = new int[(int)m][2];
        for (int i = 0; i < m; i++) {
            int l = fr.nextInt();
            int r = fr.nextInt();

            turrets[i] = new int[]{l, r};
        }
        long res = solve(n, turrets);

        out.print(res);
        out.flush();
    }

    private static long solve(long n, int[][] turrets){
        long[] diff = new long[(int)n+2];

        for(int[] t: turrets){
            int l = t[0];
            int r = t[1];

            diff[l] += 1;
            diff[r+1] -= 1;
        }

        for(int i=1; i<diff.length; i++){
            diff[i] = diff[i-1] + diff[i];
        }
        long[] new_diff = Arrays.copyOfRange(diff, 1, (int)n+1);
        long min = Long.MAX_VALUE;
        for(int i=0; i<new_diff.length; i++){
            min = Math.min(min, new_diff[i]);
        }
        return min;
    }
}
class FastReader5 {
    StreamTokenizer st;
    public FastReader5() {
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