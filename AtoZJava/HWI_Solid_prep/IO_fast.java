package HWI_Solid_prep;

import java.util.*;
import java.io.*;

/*import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in, 1 << 16));
        StringBuilder sb = new StringBuilder();

        // reading:
        in.nextToken(); int x = (int) in.nval;   // int
        in.nextToken(); long y = (long) in.nval;  // long

        // output:
        sb.append(answer).append('\n');
        System.out.print(sb); // flush once at end
    }
}

Why this is the real fastest:

StreamTokenizer — fastest input, parses numbers directly, no string splitting
BufferedInputStream with 1 << 16 — large buffer
StringBuilder + single System.out.print at end — one flush, no repeated I/O

BufferedReader is fast but needs manual parseInt/parseLong — extra overhead. StreamTokenizer skips that entirely.
This is the true C++ cin/cout equivalent in Java. Use this as your base template going forward.*/
class Main {
    public static void main(String[] args) throws IOException {
        // FAST I/O setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading a single integer (e.g., N)
        int n = Integer.parseInt(br.readLine().trim());

        // Reading an array (e.g., 1 2 3 4 5)
        int[] arr = new int[n];
        String[] input = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Your Logic Here
        long result = solve(n, arr);

        // Output
        System.out.println(result);
    }

    public static long solve(int n, int[] arr) {
        // Implement your DSA logic (Greedy/DP/Graph) here
        return 0;
    }
}
public class IO_fast {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}
